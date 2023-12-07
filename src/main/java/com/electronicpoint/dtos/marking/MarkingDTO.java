package com.electronicpoint.dtos.marking;

import java.time.LocalDateTime;


import lombok.Data;

@Data
public class MarkingDTO {
    private Long id;
    private LocalDateTime timestamp;
    private EmployeeMarkingDTO employee;
    private Boolean isValidated;
    private Boolean wasEdited;

}
