package com.HRMS.Leave.Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public void addEmployee(Employee employee){
        employeeRepo.save(employee);

    }
    public Employee editEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public void deleteEmployee(long id){
        employeeRepo.deleteById(id);
    }
    public Employee getEmployee(long empID){
        return employeeRepo.getReferenceById(empID);
    }
    public List<Employee> getEmployeelist(){
        return employeeRepo.findAll();}




}

