package com.example.EmployeeDetails.model;

import lombok.*;

import javax.persistence.*;
import java.lang.reflect.GenericArrayType;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Double phoneNumber;
    private Date Doj;
    private double salary;
}
