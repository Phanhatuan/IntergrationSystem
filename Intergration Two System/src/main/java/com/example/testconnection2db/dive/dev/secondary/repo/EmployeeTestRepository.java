package com.example.testconnection2db.dive.dev.secondary.repo;

import com.example.testconnection2db.dive.dev.secondary.models.Employee;
import com.example.testconnection2db.dive.dev.secondary.models.EmployeeDetail;
import com.example.testconnection2db.dive.dev.secondary.models.PersonInfo;
import com.example.testconnection2db.dive.dev.secondary.models.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeTestRepository extends JpaRepository<PersonInfo, Long> {
    @Query("SELECT pi FROM PersonInfo pi JOIN FETCH pi.personContact WHERE pi.id = :personId")
    Optional<PersonInfo> findByIdWithPersonContact(@Param("personId") Long personId);
}
