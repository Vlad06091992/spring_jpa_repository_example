package com.example.spring_data_jpa.service;


import com.example.spring_data_jpa.dao.EmployeeRepository;
import com.example.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("SERVICE");
        return this.repository.findAll();
    }

    public List<Employee> findAllByName(String name) {
        System.out.println(name);
        return this.repository.findAllByName(name);
    }

    @Override
    public void saveEmployee(Employee employee) {
        System.out.println(employee);
        this.repository.save(employee);
    }

    @Override
    public Employee getEmployeeById(String id) {
        Employee employee = null;
        Optional<Employee> emp = repository.findById(id);
        if (emp.isPresent()) {
            employee = emp.get();
        }

        return employee;
    }

    @Override
    public void deleteEmployeeById(String id) {
         this.repository.deleteById(id);
    }
}
