package com.hrm.system;

import ch.qos.logback.core.util.DelayStrategy;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hrm")
public class LoginController {
    @Autowired
    LoginAdminService loginAdminService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/welcome")
    public String welcome(Model model){
        return "Welcome";
    }



    //admin login
    @GetMapping("/login/admin")
    public String adminLogin(Model model){
        return "LoginAdmin";
    }
    @PostMapping("/login/admin")
    public String checkAdminLogin(Model model,long adminId,String adminPassword){

        /*if((10001)==(adminId) && "password".equals(adminPassword)){
            model.addAttribute("adminId",adminId);
            return "adminDashboard";*/
        LoginAdmin loginAdmin = loginAdminService.getId(adminId);
        if (loginAdmin != null && loginAdmin.getAdminPassword().equals(adminPassword)){
            model.addAttribute("adminId",adminId);
            return "adminDashboard";
        }else{
            model.addAttribute("error","Invalid Admin Id or Password");
            return "LoginAdmin";
        }

    }

    //employee login
    @GetMapping("/login/employee")
    public String empLogin(Model model){
        return "LoginEmployee";
    }

    @PostMapping("/login/employee")
    public String checkEmpLogin(Model model,long empId,String empPassword){
        Employee employee = employeeService.getId(empId);
        if(employee != null && employee.getEmpPassword().equals(empPassword)){
            model.addAttribute("firstName",employee.getFirstName());
            model.addAttribute("lastName",employee.getLastName());
            model.addAttribute("empId",empId);
            model.addAttribute("annual",employee.getAvailableAnnualLeave());
            model.addAttribute("casual",employee.getAvailableCasualLeave());
            model.addAttribute("medical",employee.getAvailableMedicalLeave());
            model.addAttribute("employeeLeave",new EmployeeLeave());
            return "employeeDashboard";//redirect:/ hrm/employee/dashboard
        }else{
            model.addAttribute("error","Invalid Employee Id or Password");
            return "LoginEmployee";
        }
    }



}
