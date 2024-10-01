package com.game_service_api.game_service.service;

import com.game_service_api.game_service.common.dtos.CreateGame;
import com.game_service_api.game_service.common.dtos.UpdateGame;
import com.game_service_api.game_service.common.entity.GameModel;
import com.game_service_api.game_service.exceptions.GameException;

public interface GameService {
    GameModel createGame(String userId,CreateGame createGame) throws GameException;
    GameModel getGame(String userId,Long gameId) throws GameException;
    void updateGame(String userId,UpdateGame updateGame,Long gameId);
    void deleteGame(String userId,Long gameId);
}
