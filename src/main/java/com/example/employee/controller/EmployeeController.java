package com.example.employee.controller;

import java.util.List;
import java.util.Optional;import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@RestController

@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("")
	public long saveEmployee(@RequestBody Employee employee) {
		 employeeService.saveEmployee(employee);
		 return employee.getId();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
		return ResponseEntity.ok(employeeService.getEmployee(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.ok(employeeService.getAllEmployee()); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee updatedEmployee) {
		return ResponseEntity.ok(employeeService.updateEmployee(updatedEmployee, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deleteEmployee(@PathVariable long id) {
		return ResponseEntity.ok(employeeService.deleteEmployee(id));
	}
}
