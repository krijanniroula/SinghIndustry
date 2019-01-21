package org.singhindustry.services;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Employee;
import org.singhindustry.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        employees = employeeRepository.findAll();
        return employees;
    }

    public Employee findemployee(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
    	employeeRepository.deleteById(id);

    }
    
      public void save(Employee employee) {
    	employeeRepository.save(employee);
    }

}
