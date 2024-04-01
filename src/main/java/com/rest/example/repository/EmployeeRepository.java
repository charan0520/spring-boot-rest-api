package com.rest.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.example.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
