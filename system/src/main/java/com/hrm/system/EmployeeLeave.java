package com.hrm.system;

import jakarta.persistence.*;

@Entity
@Table
public class EmployeeLeave {
    @SequenceGenerator(name = "leave_sequence",sequenceName = "leave_sequence",initialValue = 900001,allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "leave_sequence")
    private long leaveId;
    private String leaveType;
    private int noOfLeaveDays;
    private String leaveStartDate;
    private String leaveEndDate;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "empId")
    private Employee employee;

    public EmployeeLeave(long leaveId, String leaveType, int noOfLeaveDays, String leaveStartDate, String leaveEndDate, String reason, Employee employee) {
        this.leaveId = leaveId;
        this.leaveType = leaveType;
        this.noOfLeaveDays = noOfLeaveDays;
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
        this.reason = reason;
        this.employee = employee;
    }

    public EmployeeLeave(){}

    public long getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(long leaveId) {
        this.leaveId = leaveId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public int getNoOfLeaveDays() {
        return noOfLeaveDays;
    }

    public void setNoOfLeaveDays(int noOfLeaveDays) {
        this.noOfLeaveDays = noOfLeaveDays;
    }

    public String getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(String leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public String getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(String leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
