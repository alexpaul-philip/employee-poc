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
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}
	public void updateEmployee(Employee updatedEmployee,long id) {
		Optional<Employee> oldEmployee  = employeeRepository.findById(id);
		if(oldEmployee.isPresent()) {
			oldEmployee.map(emp->{
				emp.setFirstName(updatedEmployee.getFirstName());
				emp.setLastName(updatedEmployee.getLastName());
				emp.setPhone(updatedEmployee.getPhone());
				return employeeRepository.save(emp);
			});
		}
	}
	public Optional<Employee> getEmployee(long id) {
		return employeeRepository.findById(id);
	}
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
}
