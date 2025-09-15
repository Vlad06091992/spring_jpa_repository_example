package com.example.spring_data_jpa.controller;

import com.example.spring_data_jpa.entity.Employee;
import com.example.spring_data_jpa.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private EmployeeServiceInterface employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        List<Employee> employees = this.employeeService.getAllEmployees();
        return employees;
    }

    @GetMapping("/employees/byName")
    public List<Employee> getAllEmployeesByName(@RequestParam String name){
        System.out.println("Controller: " + name);
        List<Employee> employees = this.employeeService.findAllByName(name);
        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") String empId ) {
        Employee employee = this.employeeService.getEmployeeById(empId);
        return employee;
    }

    @PostMapping("/employees")
    public Employee getAllEmployees(@RequestBody Employee employee){
        System.out.println(employee);
        this.employeeService.saveEmployee(employee);
        return employee;
    }


    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") String empId ){
        employee.setId(empId);
        this.employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") String empId) {
       employeeService.deleteEmployeeById(empId);
        return null;
    }
}
