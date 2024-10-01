package com.game_service_api.game_service.service.impl;

import com.game_service_api.game_service.common.constants.TopicConstants;
import com.game_service_api.game_service.common.dtos.CreateGame;
import com.game_service_api.game_service.common.dtos.UpdateGame;
import com.game_service_api.game_service.common.entity.GameModel;
import com.game_service_api.game_service.exceptions.GameException;
import com.game_service_api.game_service.repository.GameRepository;
import com.game_service_api.game_service.service.GameService;
import lombok.SneakyThrows;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final StreamBridge streamBridge;

    public GameServiceImpl(GameRepository gameRepository, StreamBridge streamBridge) {
        this.gameRepository = gameRepository;
        this.streamBridge = streamBridge;
    }

    @Override
    public GameModel createGame(String userId,CreateGame createGame) throws GameException {
        return Optional.of(createGame)
                .map(game -> mapToEntity(userId,createGame))
                .map(gameRepository::save)
                .map(this::sendGameEvent)
                .orElseThrow(() -> new GameException(HttpStatus.BAD_REQUEST,"Error creating game"));
    }

    private GameModel sendGameEvent(GameModel gameModel) {
         Optional.of(gameModel)
            .map(givenGame -> this.streamBridge.send(TopicConstants.GAME_CREATED_TOPIC,gameModel))
            .map(bool -> gameModel);
         return gameModel;
    }

    private GameModel mapToEntity(String userId, CreateGame createGame) {
        return GameModel.builder()
                .nameGame(createGame.getNameGame())
                .userId(Integer.parseInt(userId))
                .build();
    }

    @Override
    public GameModel getGame(String userId,Long gameId) throws GameException {
        return Optional.of(gameId)
                .flatMap(gameRepository::findById)
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND,"Game not found with ID "));
    }

    @SneakyThrows
    @Override
    public void updateGame(String userId,UpdateGame updateGame,Long gameId) {
        Optional.of(gameId)
                .map(this::getGameById)
                .map(existGame -> updateFieldsGame(existGame,updateGame))
                .map(gameRepository::save);
    }

    private GameModel updateFieldsGame(GameModel existGame, UpdateGame updateGame) {
        existGame.setNameGame(updateGame.getNameGame());
        return existGame;
    }

    private GameModel getGameById(Long aLong) throws GameException {
        return gameRepository.findById(aLong)
                .orElseThrow(()-> new GameException(HttpStatus.NOT_FOUND,"Game not found with ID "));
    }

    @SneakyThrows
    @Override
    public void deleteGame(String userId,Long gameId) {
        Optional.of(gameId)
                .map(this::getGameById)
                .ifPresent(gameRepository::delete);
    }
}
