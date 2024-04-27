package com.HRMS.Leave.Module;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    List<Employee> findByEmpID(long query);

    List<Employee> findByFirstNameContaining(String query);

    List<Employee> findByLastNameContaining(String query);

    List<Employee> findByContactNumberContaining(String query);

    List<Employee> findByEmpEmailContaining(String query);

    List<Employee> findByJoinDateContaining(String query);

    List<Employee> findByEmpStatusContaining(String query);


}
