package com.hrm.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public Employee getId(long empId){
        return employeeRepo.getReferenceById(empId);
    }
    public void deleteEmployee(long empId){employeeRepo.deleteById(empId);}

    public List<Employee> getAllEmployees(){return employeeRepo.findAll();} //use to map to employeeLeave

    public void addEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public List<Employee> getByEmpId(long empId){return employeeRepo.findByEmpId(empId);}
    public List<Employee> getByFirstName(String query){
        return employeeRepo.findByFirstNameContaining(query);
    }
    public List<Employee> getByLastName(String query){
        return employeeRepo.findByLastNameContaining(query);
    }
    public List<Employee> getByContact(String query){return employeeRepo.findByContactContaining(query);}
    public List<Employee> getByEmail(String query){ return employeeRepo.findByEmailContaining(query);
    }
    public List<Employee> getByStatus(String query){
        return employeeRepo.findByStatusContaining(query);
    }





}
