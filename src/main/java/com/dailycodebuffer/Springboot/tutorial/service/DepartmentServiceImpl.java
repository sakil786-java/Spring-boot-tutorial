package com.dailycodebuffer.Springboot.tutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl  implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchAllDepartment() {
		
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentByid(long departmentId) throws DepartmentNotFoundException {
		
		Optional<Department>department= departmentRepository.findById(departmentId);
		
		if(!department.isPresent())
			throw new DepartmentNotFoundException("Department Not Availble");
	
		return department.get();
	}

	@Override
	public void deleteDepartmentByid(long departmentId) {
		 departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartmentByid(long departmentId, Department department) {
		Department depDb=departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName())&& !"".equalsIgnoreCase(department.getDepartmentName())) {
			depDb.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentCode())&& !"".equalsIgnoreCase(department.getDepartmentCode())) {
			depDb.setDepartmentCode(department.getDepartmentCode());
		}
		if(Objects.nonNull(department.getDepartmentAddress())&& !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDb.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		return departmentRepository.save(depDb);
				
	}

	@Override
	public Department fetchDepartmentByName(String deptname) {
		
		return departmentRepository.findByDepartmentNameIgnoreCase(deptname);
	}

}
