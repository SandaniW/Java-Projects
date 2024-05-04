package com.hrm.system;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginAdminRepo extends JpaRepository<LoginAdmin,Long> {
}
