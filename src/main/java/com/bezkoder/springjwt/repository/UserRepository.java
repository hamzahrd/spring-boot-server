package com.bezkoder.springjwt.repository;

import java.util.Optional;

import com.bezkoder.springjwt.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Employee;

@Repository
public interface UserRepository extends JpaRepository<Employee, Long> {
	Optional<Employee> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
