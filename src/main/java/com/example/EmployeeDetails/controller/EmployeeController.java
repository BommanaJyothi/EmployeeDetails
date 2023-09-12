package com.example.EmployeeDetails.controller;


import com.example.EmployeeDetails.EmployeeService;
import com.example.EmployeeDetails.dto.EmployeeTaxDTO;
import com.example.EmployeeDetails.exception.DataNotFound;
import com.example.EmployeeDetails.exception.InValidDataProvided;
import com.example.EmployeeDetails.exception.MandatoryDataNotFound;
import com.example.EmployeeDetails.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployeeDetails(@RequestBody Employee employee) throws InValidDataProvided, MandatoryDataNotFound {
        if (employee != null) {
            if (employee.getId() <= 0) {
                throw new InValidDataProvided("Invalid data Supplied", "employee id provided is invalid");
            }
            if (employee.getFirstName() == null || employee.getFirstName().isEmpty()) {
                throw new MandatoryDataNotFound("Mandatory fields are not provided or provided null", "firstName is not provided");
            }
            if (employee.getLastName() == null || employee.getLastName().isEmpty()) {
                throw new MandatoryDataNotFound("Mandatory fields are not provided or provided null", "lastName is not provided");
            }
            if (employee.getEmail() == null || employee.getEmail().isEmpty()) {
                throw new MandatoryDataNotFound("Mandatory fields are not provided or provided null", "email is not provided");
            }
            if (employee.getDoj() == null) {
                throw new MandatoryDataNotFound("Mandatory fields are not provided or provided null", "DOJ is not provided");
            }
            if (employee.getSalary() > 0) {
                throw new MandatoryDataNotFound("Mandatory fields are not provided or provided null", "salary is not provided");
            }
            if (employee.getPhoneNumber() >0) {
                throw new MandatoryDataNotFound("Mandatory fields are not provided or provided null", "phoneNumber is not provided");
            }

            return employeeService.addEmployee(employee);
        }


        return null;
    }

    @GetMapping("/getEmployeeTaxInfo/{id}")
    public EmployeeTaxDTO getTaxDeduction(@PathVariable int id) throws InValidDataProvided, DataNotFound {
        if (id > 0) {
            return employeeService.getTaxInfo(id);
        } else {
            throw new InValidDataProvided("Invalid data Supplied", "employee id provided is invalid");
        }
    }

    @GetMapping("/api/getAllEmployee")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
}
