package com.hrm.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    public Department getDepartmentId(long depId){
        return departmentRepo.getById(depId);
    }

    public List<Department> getDepartmentList(){
        return departmentRepo.findAll();
    }
}
