package com.sienko.demo.dto;

import lombok.Value;

@Value
public class ActionDTO {

    int userId;
    int gameId;
    String actionDescription;
}
