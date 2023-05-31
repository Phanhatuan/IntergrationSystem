package com.example.testconnection2db.dive.dev.secondary.repo;

import com.example.testconnection2db.dive.dev.secondary.models.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, Long> {
}
