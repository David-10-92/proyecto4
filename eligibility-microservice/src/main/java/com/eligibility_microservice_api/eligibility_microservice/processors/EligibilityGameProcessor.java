package com.eligibility_microservice_api.eligibility_microservice.processors;

import com.eligibility_microservice_api.eligibility_microservice.common.GameCreatedEvent;
import com.eligibility_microservice_api.eligibility_microservice.common.GameEligibleEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class EligibilityGameProcessor {

    private final GameEligibleService gameEligibleService;

    public EligibilityGameProcessor(GameEligibleService gameEligibleService) {
        this.gameEligibleService = gameEligibleService;
    }

    public Flux<GameEligibleEvent> process(Flux<GameCreatedEvent> gameCreatedEventFlux){
        return gameCreatedEventFlux.doOnNext(given -> log.info("Entry event: {}",given))
                .flatMap(gameEligibleService::elibilityGame)
                .onErrorContinue(this::handleError);
    }

    private void handleError(Throwable throwable, Object object) {
        log.error("Error processing event: {}", object, throwable);
    }
}
