package com.HRMS.Leave.Module;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminLoginRepo extends JpaRepository<AdminLogin,Long> {
}
