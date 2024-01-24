package com.samba.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samba.springboot.model.Employee;
@Repository//optional
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{
	
	//All CRUD DB methods
	
	
	

}
