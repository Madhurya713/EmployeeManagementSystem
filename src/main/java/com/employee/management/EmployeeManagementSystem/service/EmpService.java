package com.employee.management.EmployeeManagementSystem.service;

import com.employee.management.EmployeeManagementSystem.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmpService {
    /**
     *
     * @param emp
     * @return
     */
    Employee addNewEmployee(Employee emp);

    /**
     *
     * @param id
     * @return
     */
    Employee findByid(Integer id);

    /**
     *
     * @return
     */
    List<Employee> findAllEmp();

    /**
     *
     * @param id
     * @param emp
     * @return
     */
    Employee updateEmployee(Integer id, Employee emp);

    /**
     *
     * @param id
     * @return
     */
    Boolean removeEmployee(Integer id);
}
