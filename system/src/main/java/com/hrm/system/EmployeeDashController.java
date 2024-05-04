package com.hrm.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hrm")
public class EmployeeDashController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeLeaveService employeeLeaveService;

//    @GetMapping("/employee/dashboard")
//    public String  empDash(Model model){
//        model.addAttribute("employeeLeave",new EmployeeLeave());
//        return "employeeDashboard";
//    }

    @PostMapping("/employee/dashboard")
    public String applyForLeave(@ModelAttribute("employeeLeave")EmployeeLeave employeeLeave,@RequestParam("employee.empId")long empId, Employee employee,@RequestParam("leaveType") String leaveType,@RequestParam("noOfLeaveDays") int noOfLeaveDays, Model model){ //, @RequestParam("leaveType") String leaveType,@RequestParam("noOfLeaveDays") int noOfLeaveDays
        int leaveBalance;
        switch (leaveType){
            case "Annual":
                leaveBalance = employee.getAvailableAnnualLeave()-noOfLeaveDays;
                employee.setAvailableAnnualLeave(leaveBalance);
                break;
            case "Casual":
                leaveBalance = employee.getAvailableCasualLeave()-noOfLeaveDays;
                employee.setAvailableCasualLeave(leaveBalance);
                break;
            case "Medical":
                leaveBalance = employee.getAvailableMedicalLeave()-noOfLeaveDays;
                employee.setAvailableMedicalLeave(leaveBalance);
                break;
        }
        employeeLeaveService.addEmpLeave(employeeLeave);
        model.addAttribute("firstName",employee.getFirstName());
        model.addAttribute("lastName",employee.getLastName());
        model.addAttribute("empId",empId);
        model.addAttribute("annual",employee.getAvailableAnnualLeave());
        model.addAttribute("casual",employee.getAvailableCasualLeave());
        model.addAttribute("medical",employee.getAvailableMedicalLeave());
        model.addAttribute("employeeLeave",new EmployeeLeave());
        model.addAttribute("Applied","Applied For Leave Succesfully");
        return "employeeDashboard";
    }
}
