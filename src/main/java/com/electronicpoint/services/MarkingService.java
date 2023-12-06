package com.electronicpoint.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicpoint.domain.employee.Employee;
import com.electronicpoint.domain.marking.Marking;
import com.electronicpoint.repositories.MarkingRepository;

@Service
public class MarkingService {

    @Autowired
    MarkingRepository repository;

    public List<Marking> getMarkingsByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);

    }

    public Marking createMarking(Employee employee) {
        Marking marking = new Marking();
        marking.setTimestamp(LocalDateTime.now());
        marking.setEmployee(employee);
        marking.setIsValidated(true);
        return repository.save(marking);
    }
}
