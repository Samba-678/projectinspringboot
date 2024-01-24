package com.samba.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.samba.springboot.model.Employee;
import com.samba.springboot.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
		@Autowired
		private EmployeeRepository  employeeRepository;
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		Employee employee=new Employee();
//		employee.setFirstName("Gajula");
//		employee.setLastName("samba");
//		employee.setEmailId("samba@gmail.com");
//		employeeRepository.save(employee);
//		
//		
//		Employee employee1=new Employee();
//		employee1.setFirstName("John");
//		employee1.setLastName("Cena");
//		employee1.setEmailId("cena@gmail.com");
//		employeeRepository.save(employee1);
		
	}

}
