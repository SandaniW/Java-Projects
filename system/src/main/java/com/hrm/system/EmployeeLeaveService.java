package com.hrm.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeLeaveService {
    @Autowired
    EmployeeLeaveRepo employeeLeaveRepo;

    public List<EmployeeLeave> getEmployeeLeaveByEmployee(Employee employee){
        return employeeLeaveRepo.findByEmployee(employee);
    }
    public void addEmpLeave(EmployeeLeave employeeLeave){employeeLeaveRepo.save(employeeLeave);}
    public List<EmployeeLeave> getEmployeeLeaveList(){
        return employeeLeaveRepo.findAll();
    }
}
