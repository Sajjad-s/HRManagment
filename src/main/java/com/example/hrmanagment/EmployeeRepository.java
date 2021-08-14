package com.example.hrmanagment;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hrmanagment.Entities.employee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<employee,Integer> {
    @Query(value = "SELECT * FROM employee where department =?1 ", nativeQuery = true)
    List<employee> findByDepartment (String department);
}
