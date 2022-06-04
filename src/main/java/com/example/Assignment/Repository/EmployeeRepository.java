package com.example.Assignment.Repository;

import com.example.Assignment.Dto.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeData, Long> {
    EmployeeData findEmployee(String id);
}
