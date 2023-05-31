package com.example.testconnection2db.dive.dev.secondary.controller;

import com.example.testconnection2db.dive.dev.secondary.models.Employee;
import com.example.testconnection2db.dive.dev.secondary.models.EmployeeDetail;
import com.example.testconnection2db.dive.dev.secondary.models.PersonInfo;
import com.example.testconnection2db.dive.dev.secondary.repo.EmployeeTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTestController {

    @Autowired
    EmployeeTestRepository employeeRepository;

    @GetMapping("/list123/{id}")
    public String showList(@Param("personId") Long personId,Model model){
        Optional<PersonInfo> a = employeeRepository.findByIdWithPersonContact(personId);
        model.addAttribute("employees", a);
        return "/list2";
    }
}
