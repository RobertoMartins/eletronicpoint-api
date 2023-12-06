package com.electronicpoint.domain.marking;

import java.time.LocalDateTime;

import com.electronicpoint.domain.employee.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "marking")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "TB_MARKING")
public class Marking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDateTime timestamp;

    private Boolean isValidated;

}
