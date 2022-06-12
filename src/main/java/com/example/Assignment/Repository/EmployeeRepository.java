package com.example.Assignment.Repository;

import com.example.Assignment.Dto.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeData, Long> {

    Optional<EmployeeData> findById(String id);

    List<EmployeeData> findAll();

    EmployeeData save(EmployeeData employeeData);
}
