package com.hrm.system;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    List<Employee> findByEmpId(long l);
    List<Employee> findByFirstNameContaining(String query);
    List<Employee> findByLastNameContaining(String query);
    List<Employee> findByContactContaining(String query);
    List<Employee> findByEmailContaining(String query);
    List<Employee> findByStatusContaining(String query);
}
