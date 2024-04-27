package com.HRMS.Leave.Module;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpLoginRepository extends JpaRepository<EmpLogin, Long> {
    public interface EmployeeRepository extends JpaRepository<Employee, Long> {
        List<Employee> findByEmpIdOrNameContainingOrFirstNameContainingOrLastNameContainingOrContactNumberContainingOrEmpEmailContainingOrJoinDateContainingOrEmpStatusContaining(String empId, String name, String firstName, String lastName, String contactNumber, String empEmail, String joinDate, String empStatus);
    }


}
