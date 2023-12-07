package com.electronicpoint.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electronicpoint.domain.employee.Employee;
import com.electronicpoint.domain.marking.Marking;
import com.electronicpoint.dtos.marking.MarkingDTO;
import com.electronicpoint.services.MarkingService;

@RestController()
@RequestMapping("/manager/markings")
public class MarkingManagerController {

    @Autowired
    MarkingService markingService;

    @Autowired
    ModelMapper mapper;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Marking>> getMarkingsByEmployee(@PathVariable("userId") Long userId) {

        List<Marking> markings = markingService.getMarkingsByEmployee(userId);
        return new ResponseEntity<>(markings, HttpStatus.OK);

    }

    @GetMapping("/pending")
    public ResponseEntity<List<MarkingDTO>> getMarkingsPending() {

        Employee manager = (Employee) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<MarkingDTO> markings = markingService.getMarkinsPendingValidation(manager.getId()).stream()
                .map(marking -> mapper.map(marking, MarkingDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(markings, HttpStatus.OK);

    }

}
