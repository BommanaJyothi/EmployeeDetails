package com.example.EmployeeDetails;

import com.example.EmployeeDetails.dao.EmployeeRepository;
import com.example.EmployeeDetails.dto.EmployeeTaxDTO;
import com.example.EmployeeDetails.exception.DataNotFound;
import com.example.EmployeeDetails.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee addEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public EmployeeTaxDTO getTaxInfo(int id) throws DataNotFound {
        Optional<Employee> employee = employeeRepository.findById(id);
        EmployeeTaxDTO employeeTaxDTO = null;
        if (employee.isPresent()) {
            Employee emp = employee.get();
            double yearlySalary = emp.getSalary() *12;
            double tax =0;
            if (yearlySalary> 250000  && yearlySalary <= 500000){

                tax = tax+((yearlySalary-250000)*0.05);

            }else if (yearlySalary > 500000 && yearlySalary <= 1000000){
                tax+= ((yearlySalary - 500000)*0.1);
            }
            else if(yearlySalary > 1000000){
                tax+= ((yearlySalary - 1000000)*0.2);
            }
            employeeTaxDTO = new EmployeeTaxDTO( emp.getId(), emp.getFirstName(), emp.getLastName(), tax, yearlySalary,
            yearlySalary > 2500000 ? 300000*0.02 : 0);
        }
        else{
            throw new DataNotFound("Data Not Found", "Employee details not found with the given Id: "+id);
        }
        return employeeTaxDTO;
        }
    }
