package com.rest.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.example.dto.EmployeeDTO;
import com.rest.example.entity.Employee;
import com.rest.example.exception.EmployeeException;
import com.rest.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeDTO> getAllEmployees() throws EmployeeException {
		List<EmployeeDTO> employees = employeeRepository.findAll().stream().
										map(e->e.convertToDTO()).collect(Collectors.toList());
		if(employees.isEmpty())
		{
			throw new EmployeeException("No Records Found");
		}
		System.out.println(employees);
		return employees;
	}

	public EmployeeDTO getEmployeeById(Integer id) throws EmployeeException {
		Employee employee = employeeRepository.findById(id).orElseThrow(
				()->new EmployeeException("Employee with id "+id+" not found"));
		System.out.println(employee.convertToDTO());
		return employee.convertToDTO();
	}

	public Integer addEmployee(EmployeeDTO employee) {
		Employee entity = employee.convertToEntity();
		employeeRepository.save(entity);
		return entity.getId();
	}

	public void deleteEmployeeById(Integer id) throws EmployeeException {
		Employee employee = employeeRepository.findById(id).orElseThrow(
				()->new EmployeeException("Employee with id "+id+" not found"));
		employeeRepository.delete(employee);
		
	}

	public void updateEmployee(EmployeeDTO employee) throws EmployeeException {
		employeeRepository.findById(employee.getId()).orElseThrow(
				()->new EmployeeException("Employee with id "+employee.getId()+" not found"));
		employeeRepository.save(employee.convertToEntity());
		
	}

}
