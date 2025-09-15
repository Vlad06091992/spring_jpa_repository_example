package com.example.spring_data_jpa.service;





import com.example.spring_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    public List<Employee> getAllEmployees();
    public List<Employee> findAllByName(String name);
    public void saveEmployee(Employee employee);
    public Employee getEmployeeById(String id);
    public void deleteEmployeeById(String id);
}
