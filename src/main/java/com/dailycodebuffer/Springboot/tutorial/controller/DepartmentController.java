package com.dailycodebuffer.Springboot.tutorial.controller;

import java.util.List;

import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger logger=LoggerFactory.getLogger(DepartmentController.class);
	
	
	
	@PostMapping("/add/department")
	public Department saveDepartment(@Valid @RequestBody Department department)
	{
		logger.info("Inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> fetchAllDepartment()
	{
		logger.info("Inside fetchAllDepartment of DepartmentController");
		return departmentService.fetchAllDepartment();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentByid(@PathVariable("id") long departmentId) throws DepartmentNotFoundException
	{
		logger.info("Inside fetchDepartmentByid of DepartmentController");
		return departmentService.fetchDepartmentByid(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentByid(@PathVariable("id") long departmentId)
	{
		logger.info("Inside deleteDepartmentByid of DepartmentController");
		departmentService.deleteDepartmentByid(departmentId);
		return "Department Deleted SUccessfully";
	}
	
	@PutMapping("/add/departments/{id}")
	public Department updateDepartmentByid(@PathVariable("id") long departmentId,@RequestBody
			Department department)
	{
		logger.info("Inside updateDepartmentByid of DepartmentController");
		return departmentService.updateDepartmentByid(departmentId,department);
	}
	
	@GetMapping("departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String deptname)
	{
		logger.info("Inside fetchDepartmentByName of DepartmentController");
		return departmentService.fetchDepartmentByName(deptname);
		
	}
	
	
}
