package com.electronicpoint.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MarkingDTO {
    private Long id;
    private LocalDateTime timestamp;
    private UserMarkingDTO user;
    private Boolean isValidated;

}
