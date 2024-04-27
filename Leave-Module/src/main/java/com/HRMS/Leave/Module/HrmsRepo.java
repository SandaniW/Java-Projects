package com.HRMS.Leave.Module;

import org.springframework.data.jpa.repository.JpaRepository;

//database connection layer
public interface HrmsRepo extends JpaRepository<Employee,Long> {
}
