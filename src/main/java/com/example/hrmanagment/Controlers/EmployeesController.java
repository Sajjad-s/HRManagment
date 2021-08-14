package com.example.hrmanagment.Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hrmanagment.Entities.employee;
import com.example.hrmanagment.Services.EmployeesService;

import java.util.List;

@RestController
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/employees")
    public List<employee> getAll() {
        return employeesService.listAll();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<employee> getOneById(@PathVariable Integer id) {
        employee employee = employeesService.get(id);
        try {
            return new ResponseEntity<employee>(employee, HttpStatus.OK);
        } catch (NoSuchFieldError ex) {
            return new ResponseEntity<employee>(employee, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/employee")
    public ResponseEntity<employee> addEmployee(@RequestBody employee employee) {
        try {
            employeesService.save(employee);
            return new ResponseEntity<employee>(employee, HttpStatus.OK);
        } catch (InternalError ex) {
            return new ResponseEntity<employee>(employee, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeesService.delete(id);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<employee> editEmployee(@RequestBody employee newEmployee, @PathVariable Integer id) {
        try {
            employee oldEmployee = employeesService.get(id);
            oldEmployee.setFirstName(newEmployee.getFirstName());
            oldEmployee.setLastName(newEmployee.getLastName());
            oldEmployee.setBirthDate(newEmployee.getBirthDate());
            oldEmployee.setPhone(newEmployee.getPhone());
            oldEmployee.setEmail(newEmployee.getEmail());
            oldEmployee.setDepartment(newEmployee.getDepartment());
            employeesService.save(oldEmployee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchFieldError ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/test/{department}")
    public List<employee> testQuerry(@PathVariable String department){
        return  employeesService.testService(department);
    }

}