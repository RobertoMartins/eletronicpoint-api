package com.electronicpoint.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronicpoint.domain.marking.Marking;
import com.electronicpoint.domain.user.User;
import com.electronicpoint.repositories.MarkingRepository;

@Service
public class MarkingService {

    @Autowired
    MarkingRepository repository;

    public List<Marking> getMarkingsByUser(Long userId) {
        return repository.findByUserId(userId);

    }

    public Marking createMarking(User user){
        Marking marking = new Marking();
        marking.setTimestamp(LocalDateTime.now());
        marking.setUser(user);
        marking.setIsValidated(true);
        return repository.save(marking);
    }
}
