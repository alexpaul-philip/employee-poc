package com.example.employee.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockRequestDispatcher;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeControllerTest {

	
	 private MockMvc mvc;
	
	@InjectMocks
	private EmployeeController employeeController;
	
	ObjectMapper om = new ObjectMapper();
	
	@Mock
	private EmployeeService employeeService;
	@Before
	public void setUp() throws Exception {
		mvc=MockMvcBuilders.standaloneSetup(employeeController).build();
	}
	
	@Test
	public void saveEmployee() throws Exception {
		Employee employee = new Employee("Alex", "paul", "9994882704");
		when(employeeService.saveEmployee(employee)).thenReturn(employee);
		String jsonRquest = om.writeValueAsString(employee);
		mvc.perform(MockMvcRequestBuilders.post("/api/employee").content(jsonRquest).contentType(org.springframework.http.MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getAllEmployee() throws Exception {
		Employee employee = new Employee("Alex", "paul", "9994882704");
		when(employeeService.getAllEmployee()).thenReturn(Collections.singletonList(employee));
		mvc.perform(MockMvcRequestBuilders.get("/api/employee/all"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getEmployee() throws Exception {
		Employee employee = new Employee("Alex", "paul", "9994882704");
		long empId=1;
		when(employeeService.getEmployee(empId)).thenReturn(employee);
		mvc.perform(MockMvcRequestBuilders.get("/api/employee/1"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void updateEmployee() throws Exception {
		Employee newEmp = new Employee("Updated Alex", "paul", "9994882704");
		long empId=1;
		String jsonRquest = om.writeValueAsString(newEmp);
		when(employeeService.updateEmployee(newEmp, empId)).thenReturn(newEmp);
		mvc.perform(MockMvcRequestBuilders.put("/api/employee/1").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(jsonRquest))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void deleteEmployee() throws Exception {
		long empId=1;
		when(employeeService.deleteEmployee(empId)).thenReturn(empId);
		mvc.perform(MockMvcRequestBuilders.delete("/api/employee/1"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
