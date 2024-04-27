package com.HRMS.Leave.Module;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;

@Entity
@Table
public class AdminLogin {
    @Id
    private long AdminID;
    private String password;

    public AdminLogin(){}

    public AdminLogin(long adminID, String password) {
        AdminID = adminID;
        this.password = password;
    }

    public long getAdminID() {
        return AdminID;
    }

    public void setAdminID(long adminID) {
        AdminID = adminID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
