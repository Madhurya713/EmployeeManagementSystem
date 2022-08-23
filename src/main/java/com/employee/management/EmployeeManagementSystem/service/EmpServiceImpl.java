package com.employee.management.EmployeeManagementSystem.service;

import com.employee.management.EmployeeManagementSystem.model.Employee;
import com.employee.management.EmployeeManagementSystem.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    private EmployeeRepo repo;


    @Override
    public Employee addNewEmployee(Employee emp) {
        try {
            Employee save = repo.save(emp);
            return save;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public Employee findByid(Integer id) {
        try {
            Optional<Employee> byId = repo.findById(id);
            if (byId.isPresent()) {
                return byId.get();
            }
            return null;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public List<Employee> findAllEmp() {
        try {
            List<Employee> employeeList = repo.findAll();
            if (employeeList.size() > 0) {
                return employeeList;
            }
            return null;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public Employee updateEmployee(Integer id, Employee emp) {
        try {
            Optional<Employee> byId = repo.findById(id);
            if (byId.isPresent()) {
                Employee employee = byId.get();
                employee.setAddress(emp.getAddress());
                employee.setPhno(emp.getPhno());
                employee.setEmail(emp.getEmail());
                employee.setSalary(emp.getSalary());
                Employee save = repo.save(employee);
                return save;
            }
            return null;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public Boolean removeEmployee(Integer id) {
        try {
            Optional<Employee> byId = repo.findById(id);
            if (byId.isPresent()) {
                Employee employee = byId.get();
                repo.deleteById(id);
                return true;
            }
            return null;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
