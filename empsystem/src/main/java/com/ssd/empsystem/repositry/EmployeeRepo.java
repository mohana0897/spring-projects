package com.ssd.empsystem.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssd.empsystem.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
