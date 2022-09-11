package com.dailycodebuffer.Springboot.tutorial.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUp(){
		Department department=Department.builder().departmentName("IT")
				.departmentAddress("Telangana")
				.departmentCode("IT-056")
				.departmentId(1L)
				.build();
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
						.thenReturn(department);
	}

	@Test
	@DisplayName("Get Data Based on Valid Department Name")
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName="IT";
		Department found=departmentService.fetchDepartmentByName(departmentName);
		assertEquals(departmentName, found.getDepartmentName());
	}

}
