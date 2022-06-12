package com.example.Assignment.Controller;

import com.example.Assignment.Service.EmployeeService;
import com.example.Assignment.Dto.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/")
public class assignmentController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "employees")
    public String addEmployees(@RequestBody EmployeeData employeeData){
        System.out.println("Posting the employee to the database.....");
        employeeService.saveEmployee(employeeData);
        return "Sucessfully Inserted";
    }

    @GetMapping(value = "employees/{id}")
    public Optional<EmployeeData> getEmployees(@PathVariable ("id") String id){
        System.out.println("Getting the employee from the database.....");
        return employeeService.getEmployee(id);
    }

    @GetMapping(value = "employees")
    public List<EmployeeData> getAllEmployees(){
        System.out.println("Getting the employee from the database.....");
        return employeeService.getAllEmployee();
    }
}
