package com.hrm.system;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(sequenceName = "empID",allocationSize = 1,initialValue = 10001, name = "empID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empID")
    private long empId;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private String joinDate;
    private String empPassword="0000";
    private String status;
    @Column(name = "Medical")
    private int availableMedicalLeave=7;
    @Column(name = "Casual")
    private int availableCasualLeave=7;
    @Column(name = "Annual")
    private int availableAnnualLeave=14;


    @ManyToOne
    @JoinColumn(name = "depId")
    private Department department;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeLeave> employeeLeaveList;

    public Employee(long empId, String firstName, String lastName, String contact, String email, String joinDate, String empPassword, String status, int availableMedicalLeave, int availableCasualLeave, int availableAnnualLeave, Department department, List<EmployeeLeave> employeeLeaveList) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.joinDate = joinDate;
        this.empPassword = empPassword;
        this.status = status;
        this.availableMedicalLeave = availableMedicalLeave;
        this.availableCasualLeave = availableCasualLeave;
        this.availableAnnualLeave = availableAnnualLeave;
        this.department = department;
        this.employeeLeaveList = employeeLeaveList;
    }

    public Employee(){}

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAvailableMedicalLeave() {
        return availableMedicalLeave;
    }

    public void setAvailableMedicalLeave(int availableMedicalLeave) {
        this.availableMedicalLeave = availableMedicalLeave;
    }

    public int getAvailableCasualLeave() {
        return availableCasualLeave;
    }

    public void setAvailableCasualLeave(int availableCasualLeave) {
        this.availableCasualLeave = availableCasualLeave;
    }

    public int getAvailableAnnualLeave() {
        return availableAnnualLeave;
    }

    public void setAvailableAnnualLeave(int availableAnnualLeave) {
        this.availableAnnualLeave = availableAnnualLeave;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<EmployeeLeave> getEmployeeLeaveList() {
        return employeeLeaveList;
    }

    public void setEmployeeLeaveList(List<EmployeeLeave> employeeLeaveList) {
        this.employeeLeaveList = employeeLeaveList;
    }
}
