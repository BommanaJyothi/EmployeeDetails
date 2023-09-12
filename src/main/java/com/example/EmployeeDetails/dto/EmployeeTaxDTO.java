package com.example.EmployeeDetails.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class EmployeeTaxDTO {

        private int empCode;
        private String firstName;
        private String lastName;
        private double taxAmount;
        private double yearlySalary;
        private double cessAmount;

    }
