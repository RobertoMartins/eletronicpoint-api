package com.electronicpoint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electronicpoint.domain.marking.Marking;

public interface MarkingRepository extends JpaRepository<Marking, Long> {

    List<Marking> findByUserId(Long userId);
}
