package com.dailycodebuffer.Springboot.tutorial.service;

import java.util.List;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchAllDepartment();

	public Department fetchDepartmentByid(long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentByid(long departmentId);

	public Department updateDepartmentByid(long departmentId, Department department);

	public Department fetchDepartmentByName(String deptname);

}
