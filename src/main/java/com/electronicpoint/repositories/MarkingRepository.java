package com.electronicpoint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.electronicpoint.domain.marking.Marking;

public interface MarkingRepository extends JpaRepository<Marking, Long> {

    List<Marking> findByEmployeeId(Long employeeId);

    @Query(value = "SELECT * FROM tb_marking as m  WHERE m.is_validated = false AND m.employee_id IN (SELECT id FROM tb_employee as e WHERE  e.manager_id = :managerId)", nativeQuery = true)
    List<Marking> getMarkinsPendingValidation(@Param("managerId") Long managerId);
}
