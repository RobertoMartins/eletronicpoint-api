package com.electronicpoint.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electronicpoint.domain.employee.Employee;
import com.electronicpoint.domain.marking.Marking;
import com.electronicpoint.dtos.marking.MarkingDTO;
import com.electronicpoint.services.MarkingService;

@RestController()
@RequestMapping("/employee/markings")
public class MarkingEmployeeController {

    @Autowired
    MarkingService markingService;

    @Autowired
    ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<MarkingDTO>> getMarkings() {

        Employee employee = (Employee) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<MarkingDTO> markings = markingService.getMarkingsByEmployee(employee.getId()).stream()
                .map(marking -> mapper.map(marking, MarkingDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(markings, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<String> createMarking() {
        Employee employee = (Employee) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Marking marking = markingService.createMarking(employee);
        return new ResponseEntity<>(marking.getEmployee().getFirstName() + " - Marcação efetuada com sucesso! ",
                HttpStatus.OK);
    }

}
