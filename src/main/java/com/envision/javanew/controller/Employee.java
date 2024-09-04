package com.envision.javanew.controller;


import com.envision.javanew.component.ResourceNotFoundException;
import com.envision.javanew.entity.EmployeeDetails;
import com.envision.javanew.repositry.EmployeeRepositry;
import com.envision.javanew.service.ConumerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobsheet")
public class Employee {
@Autowired
private EmployeeRepositry employeeRepositry;
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDetails>> getUsers(@RequestParam("limit") int limit) {
        if (limit < 1) {
            throw new ResourceNotFoundException("Limit must be greater than zero");
        }

        List<EmployeeDetails> users = employeeRepositry.findAll();
        return ResponseEntity.ok(users);
    }

}
