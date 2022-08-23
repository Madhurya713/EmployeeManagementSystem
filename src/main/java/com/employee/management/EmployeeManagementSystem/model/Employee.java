package com.employee.management.EmployeeManagementSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_Id")
    private Integer id;

    @Column(name = "EMP_NAME")
    private String name;

    @Column(name = "EMP_ADDRESS")
    private String address;

    @Column(name = "EMP_EMAIL")
    private String email;

    @Column(name = "EMP_PHno.")
    private String phno;

    @Column(name = "EMP_SALARY")
    private int salary;

    @Column(name = "EMP_ROLE")
    private String role;
}
