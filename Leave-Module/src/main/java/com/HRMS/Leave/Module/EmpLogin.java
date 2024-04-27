package com.HRMS.Leave.Module;

import jakarta.persistence.*;

@Entity
@Table
public class EmpLogin {
    @Id
    private long employeeID;
    private String password;

    @ManyToOne
    @JoinColumn(name = "empId", referencedColumnName = "empId")
    private Employee employee;

    public EmpLogin(long employeeID, String password, Employee employee) {
        this.employeeID = employeeID;
        this.password = password;
        this.employee = employee;
    }

    public EmpLogin (){}

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
