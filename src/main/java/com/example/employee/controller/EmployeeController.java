package com.example.employee.controller;

import java.util.List;
import java.util.Optional;import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@RestController

@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("")
	private void saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
	}

	@GetMapping("/{id}")
	private Optional<Employee> getEmployee(@PathVariable long id) {
		return employeeService.getEmployee(id);
	}

	@GetMapping("/all")
	private List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	
	@PutMapping("/{id}")
	private void updateEmployee(@PathVariable long id, @RequestBody Employee updatedEmployee) {
		employeeService.updateEmployee(updatedEmployee, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
	}
}
