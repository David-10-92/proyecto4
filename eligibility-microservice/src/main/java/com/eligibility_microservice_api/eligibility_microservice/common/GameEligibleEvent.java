package com.eligibility_microservice_api.eligibility_microservice.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class GameEligibleEvent {
    private Integer gameId;
    private String nameGame;
    private Integer userId;
    private Boolean isEligible;
}
