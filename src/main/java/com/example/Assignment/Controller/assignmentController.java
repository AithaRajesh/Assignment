package com.example.Assignment.Controller;


import com.example.Assignment.Dto.EmployeeData;
import org.springframework.web.bind.annotation.*;

@RestController
public class assignmentController {

    @PostMapping(value = "/employees")
    public void addEmployees(@RequestBody EmployeeData employeeData){
        System.out.println("Posting the employee to the database.....");
    }

    @GetMapping(value = "/employees/{id}")
    public EmployeeData getEmployees(@PathVariable ("id") String id){
        System.out.println("Getting the employee from the database.....");

        return new EmployeeData();
    }
}
