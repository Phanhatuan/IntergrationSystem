package com.example.testconnection2db.dive.dev.primary.repository;

import com.example.testconnection2db.dive.dev.primary.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
