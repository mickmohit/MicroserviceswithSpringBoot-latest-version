package com.mohit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.entity.Department;
import com.mohit.repository.DepartmentRepo;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;

	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepo.save(department);
	}

	public Department findDepartmentById(Long deptId) {
		// TODO Auto-generated method stub
		return departmentRepo.findByDeptId(deptId);
	}
}
