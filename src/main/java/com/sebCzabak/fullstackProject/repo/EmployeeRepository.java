package com.sebCzabak.fullstackProject.repo;

import com.sebCzabak.fullstackProject.model.AppUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<AppUser,Long> {
    Optional<AppUser>findByEmail(String email);
}
