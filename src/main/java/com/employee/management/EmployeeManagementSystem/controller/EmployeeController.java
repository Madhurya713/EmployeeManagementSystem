package com.employee.management.EmployeeManagementSystem.controller;

import com.employee.management.EmployeeManagementSystem.model.Employee;
import com.employee.management.EmployeeManagementSystem.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmpService service;

    /**
     *
     * @param emp
     * @return
     */
    @PostMapping("addEmployee")
    public ResponseEntity<?> addNewEmployee(@RequestBody Employee emp) {
        try {
            if (emp.getId() != null) {
                Employee employee = service.addNewEmployee(emp);
                return new ResponseEntity<>(employee, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("getEmployee/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Integer id) {
        try {
            if (id != null) {
                Employee employee = service.findByid(id);
                if (employee == null) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(employee, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @return
     */
    @GetMapping("getAllEmployee")
    public ResponseEntity<?> getEmployee() {
        try {
            List<Employee> employee = service.findAllEmp();
            if (employee == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param id
     * @param emp
     * @return
     */
    @PutMapping("updateEmployee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer id, @RequestBody Employee emp) {
        try {
            if (id != null) {
                Employee employee = service.updateEmployee(id, emp);
                if (employee == null) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(employee, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param id
     * @return
     */
    @DeleteMapping("removeEmployee/{id}")
    public ResponseEntity<?> removeEmployee(@PathVariable Integer id) {
        try {
            if (id != null) {
                Boolean removeEmployee = service.removeEmployee(id);
                if (removeEmployee.booleanValue() == false) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

