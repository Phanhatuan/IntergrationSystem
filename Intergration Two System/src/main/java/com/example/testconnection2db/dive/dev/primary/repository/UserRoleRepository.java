package com.example.testconnection2db.dive.dev.primary.repository;

import com.example.testconnection2db.dive.dev.primary.models.UsersRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UsersRole, Long> {
}
