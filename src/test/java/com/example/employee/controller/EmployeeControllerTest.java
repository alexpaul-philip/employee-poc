package com.example.employee.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
	@InjectMocks
	EmployeeController employeeController;
	
	@Mock
	EmployeeService employeeService;
	
	@Test
	public void getAllEmployees() {
		Employee e1 = new Employee();
		e1.setFirstName("Alexpaul");
		e1.setLastName("Philip");
		e1.setPhone("9994882704");
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(e1);
		when(employeeService.getAllEmployee()).thenReturn(emp);
		ResponseEntity<List<Employee>> response = employeeController.getAllEmployee();
		assertThat(response.getBody()).isNotNull();
	}
	
	@Test
	public void getEmployee() {
		Employee e1 = new Employee();
		e1.setFirstName("Alexpaul");
		e1.setLastName("Philip");
		e1.setPhone("9994882704");
		when(employeeService.getEmployee(1)).thenReturn(e1);
		ResponseEntity<Employee> response = employeeController.getEmployee(1);
		assertThat(response.getBody()).isNotNull();
	}
	
	@Test
	public void updateEmployee() {
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setFirstName("Alexpaul");
		e1.setLastName("Philip");
		e1.setPhone("9994882704");
		when(employeeService.updateEmployee(e1,1)).thenReturn(e1);
		Employee response = employeeController.updateEmployee(1, e1);
		assertThat(response.getId()).isGreaterThan(0);
	}
	
	@Test
	public void saveEmployee() {
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setFirstName("Alexpaul");
		e1.setLastName("Philip");
		e1.setPhone("9994882704");
		long empId=1;
		when(employeeService.saveEmployee(e1)).thenReturn(e1);
		long response = employeeController.saveEmployee(e1);
		assertThat(response).isEqualTo(empId);
	}
	
	@Test
	public void deleteEmployee() {
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setFirstName("Alexpaul");
		e1.setLastName("Philip");
		e1.setPhone("9994882704");
		long empId=1;
		when(employeeService.deleteEmployee(empId)).thenReturn(empId);
		ResponseEntity<Long> response = employeeController.deleteEmployee(empId);
		assertThat(response.getBody()).isEqualTo(empId);
	}
}
