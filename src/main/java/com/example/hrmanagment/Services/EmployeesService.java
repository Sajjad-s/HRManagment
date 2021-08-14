package com.example.hrmanagment.Services;

import com.example.hrmanagment.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hrmanagment.Entities.employee;

import java.util.List;

@Service
public class EmployeesService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<employee> listAll() {
        return employeeRepository.findAll();
    }

    public void save(employee employee) {
        employeeRepository.save(employee);
    }

    public employee get(Integer HRID) {
        return employeeRepository.findById(HRID).get();
    }

    public void delete(Integer HRID){
        employeeRepository.deleteById(HRID);
    }

    public List<employee> testService(String department){
        return (List<employee>) employeeRepository.findByDepartment(department);
    }
}
