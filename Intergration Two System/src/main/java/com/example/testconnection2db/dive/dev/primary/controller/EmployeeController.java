package com.example.testconnection2db.dive.dev.primary.controller;

import com.example.testconnection2db.dive.dev.primary.models.Employee;
import com.example.testconnection2db.dive.dev.primary.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/list")
    public String showList(Model model){
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees",employees);
        return "/list1";
    }
}
