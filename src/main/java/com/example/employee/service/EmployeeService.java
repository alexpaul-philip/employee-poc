package com.example.employee.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	@Autowired EmployeeRepository employeeRepository;
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public long deleteEmployee(long id) {
		employeeRepository.deleteById(id);
		return id;
	}
	public Employee updateEmployee(Employee updatedEmployee,long id) {
		Optional<Employee> oldEmployee  = employeeRepository.findById(id);
		if(oldEmployee.isPresent()) {;
			oldEmployee.get().setFirstName(updatedEmployee.getFirstName());
			oldEmployee.get().setLastName(updatedEmployee.getLastName());
			oldEmployee.get().setPhone(updatedEmployee.getPhone());
			employeeRepository.save(oldEmployee.get());
		}
		return oldEmployee.get();
	}
	public Employee getEmployee(long id) {
		return employeeRepository.findById(id).get();
	}
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
}
