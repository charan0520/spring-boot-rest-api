package com.rest.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.example.dto.EmployeeDTO;
import com.rest.example.exception.EmployeeException;
import com.rest.example.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping(path="/api")
public class EmployeeController{
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping(path = "/employees/all")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() throws EmployeeException
	{
		List<EmployeeDTO> employees = employeeService.getAllEmployees();
		return new ResponseEntity<List<EmployeeDTO>>(employees,HttpStatus.OK);
	}
	
	@GetMapping(path = "/employees/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer id) throws EmployeeException
	{
		EmployeeDTO employee = employeeService.getEmployeeById(id);
		return new ResponseEntity<EmployeeDTO>(employee,HttpStatus.OK);
	}
	
	@PostMapping(path = "/employees")
	public ResponseEntity<String> addEmployee(@Valid@RequestBody EmployeeDTO employee) throws EmployeeException
	{
		Integer id = employeeService.addEmployee(employee);
		return new ResponseEntity<String>("Employee saved with id : "+id,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping(path = "employees/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id) throws EmployeeException
	{
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<String>("Employee with id : "+id+" deleted successfully",HttpStatus.OK);
	}
	
	@PutMapping(path = "/employees")
	public ResponseEntity<String> updateEmployee(@Valid@RequestBody EmployeeDTO employee) throws EmployeeException
	{
		employeeService.updateEmployee(employee);
		return new ResponseEntity<String>("Employee with id : "+employee.getId()+" updated successfully",HttpStatus.OK);
	}
}
