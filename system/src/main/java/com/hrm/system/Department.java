package com.hrm.system;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table
public class Department {
    @Id
    private long depId;
    private String depName;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;

    public Department(long depId, String depName, List<Employee> employeeList) {
        this.depId = depId;
        this.depName = depName;
        this.employeeList = employeeList;
    }

    public Department(){}

    public long getDepId() {
        return depId;
    }

    public void setDepId(long depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
