package com.hrm.system;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeLeaveRepo extends JpaRepository<EmployeeLeave,Long> {
    List<EmployeeLeave> findByEmployee(Employee employee);
}
