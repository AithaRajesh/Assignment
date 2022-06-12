package com.example.Assignment.Service;

import com.example.Assignment.Dto.EmployeeData;
import com.example.Assignment.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(EmployeeData employeeData){
        employeeRepository.save(employeeData);
    }
    public Optional<EmployeeData> getEmployee(String id){
        return employeeRepository.findById(id);
    }
    public List<EmployeeData> getAllEmployee(){
        return employeeRepository.findAll();
    }
}
