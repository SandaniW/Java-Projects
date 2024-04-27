package com.HRMS.Leave.Module;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee_Info")
public class Employee {

    @Id
    private long empID;
    private long depId;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String empEmail;
    private String joinDate;
    private String empStatus;
    private String reasonForLeave;
    private int NoOfDaysOnLeave;
    private String startOfLeave;
    private String endOfLeave;
    private int annualLeave;
    private int casualLeave;
    private int medicalLeave;

    public Employee(long empID, long depId, String firstName, String lastName, String contactNumber, String empEmail, String joinDate, String empStatus, String reasonForLeave, int noOfDaysOnLeave, String startOfLeave, String endOfLeave, int annualLeave, int casualLeave, int medicalLeave) {
        this.empID = empID;
        this.depId = depId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.empEmail = empEmail;
        this.joinDate = joinDate;
        this.empStatus = empStatus;
        this.reasonForLeave = reasonForLeave;
        NoOfDaysOnLeave = noOfDaysOnLeave;
        this.startOfLeave = startOfLeave;
        this.endOfLeave = endOfLeave;
        this.annualLeave = annualLeave;
        this.casualLeave = casualLeave;
        this.medicalLeave = medicalLeave;
    }

    public Employee() {

    }

    public long getEmpID() {
        return empID;
    }

    public void setEmpID(long empID) {
        this.empID = empID;
    }

    public long getDepId() {
        return depId;
    }

    public void setDepId(long depId) {
        this.depId = depId;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public String getReasonForLeave() {
        return reasonForLeave;
    }

    public void setReasonForLeave(String reasonForLeave) {
        this.reasonForLeave = reasonForLeave;
    }

    public int getNoOfDaysOnLeave() {
        return NoOfDaysOnLeave;
    }

    public void setNoOfDaysOnLeave(int noOfDaysOnLeave) {
        NoOfDaysOnLeave = noOfDaysOnLeave;
    }

    public String getStartOfLeave() {
        return startOfLeave;
    }

    public void setStartOfLeave(String startOfLeave) {
        this.startOfLeave = startOfLeave;
    }

    public String getEndOfLeave() {
        return endOfLeave;
    }

    public void setEndOfLeave(String endOfLeave) {
        this.endOfLeave = endOfLeave;
    }

    public int getAnnualLeave() {
        return annualLeave;
    }

    public void setAnnualLeave(int annualLeave) {
        this.annualLeave = annualLeave;
    }

    public int getCasualLeave() {
        return casualLeave;
    }

    public void setCasualLeave(int casualLeave) {
        this.casualLeave = casualLeave;
    }

    public int getMedicalLeave() {
        return medicalLeave;
    }

    public void setMedicalLeave(int medicalLeave) {
        this.medicalLeave = medicalLeave;
    }
}
