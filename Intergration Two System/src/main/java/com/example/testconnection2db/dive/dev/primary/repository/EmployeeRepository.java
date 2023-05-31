package com.example.testconnection2db.dive.dev.primary.repository;

import com.example.testconnection2db.dive.dev.primary.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
