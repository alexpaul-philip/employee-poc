package com.example.employee;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import com.example.employee.controller.EmployeeController;
import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@SpringBootTest
class EmployeeApplicationTests {
}
