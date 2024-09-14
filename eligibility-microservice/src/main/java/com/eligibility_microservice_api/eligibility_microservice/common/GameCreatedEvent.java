package com.eligibility_microservice_api.eligibility_microservice.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class GameCreatedEvent {
    private Integer gameId;
    private String nameGame;
    private Integer userId;
}
