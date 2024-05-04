package com.hrm.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/hrm")
public class AdminDashController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeLeaveService employeeLeaveService;

    @GetMapping("/adminDashboard")
    public String adminDashboard(Model model){
        //get a list of employee leave
        //get the empid of that
        //get a list of employees and count and get thoses depid
        //get the dep name

        return "adminDashboard";
    }

    //add employee - is done - make msgs show added and password
    @GetMapping("/adminDashboard/newEmp")
    public String showAddEmployee(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("departments",departmentService.getDepartmentList());
        return "addEmployee";}

    @PostMapping
    @RequestMapping("/adminDashboard/newEmp")
    public String addEmployee(@ModelAttribute("employee") Employee employee,Model model){ //,@RequestParam("depId") String depId
//        Department department = departmentService.getDepartmentId(Long.parseLong(depId));
//        employee.setDepartment(department);
        //i thought that i had to put the value to department, but i only had to fill the form and submit it
        //keeping the above code so that i wont forget it again
        employeeService.addEmployee(employee);
        model.addAttribute("added", "Employee added successfully");
        model.addAttribute("password","Default Password:0000");
        return "adminDashboard";

    }

    //edit
    @GetMapping("/admin/editEmployee/{empId}")
    public String getEditEmployee(@PathVariable(name = "empId") long empId,Model model){ //,@RequestParam("departmentId") String departmentId
//        Department department = departmentService.getDepartmentId(Long.parseLong(departmentId));
//        employee.setDepartment(department);
        //same mistake as add new emp
        Employee employee = employeeService.getId(empId);
        model.addAttribute("employee",employee);
        return "UpdateEmployee"; //redirect to the dashboard
    }
    @PostMapping("/admin/editEmployee/{empId}")
    public String editEmployee(@PathVariable(name = "empId") long empId,@ModelAttribute("employee")Employee employee){
        employeeService.addEmployee(employee);
        return "empSearch";
    }

    //delete - is done ig
    @PostMapping("/deleteEmployee/{empId}")
    public String deleteEmployee(@PathVariable(name = "empId") long id,@ModelAttribute("employee") Employee employee) {
        employeeService.deleteEmployee(id);
        return "redirect:/hrm/adminDashboard/search";

    }

    //Search -is done
    @GetMapping("/adminDashboard/search")
    public String getSearchEmp(){
        return "empSearch";
    }
    @PostMapping("/adminDashboard/search")
    public String searchEmployee(@RequestParam("keyword") String keyword,@RequestParam("searchBy") String searchBy,Model model){
        List<Employee> employeeList = null;
        if(keyword != null && !keyword.isEmpty()) {
            switch (searchBy) {
                case "empId":
                    employeeList = employeeService.getByEmpId(Long.parseLong(keyword));
                    break;
                case "firstName":
                    employeeList = employeeService.getByFirstName(keyword);
                    break;
                case "lastName":
                    employeeList = employeeService.getByLastName(keyword);
                    break;
                case "contact":
                    employeeList = employeeService.getByContact(keyword);
                    break;
                case "email":
                    employeeList = employeeService.getByEmail(keyword);
                    break;
                case "status":
                    employeeList = employeeService.getByStatus(keyword);
                    break;
            }
        }else {
            employeeList = employeeService.getAllEmployees();
        }

        model.addAttribute("employeeList",employeeList);
        return "empSearch";
    }

    //report - should work
    @GetMapping("/adminDashboard/report")
    public String empReport(Model model){
        List<Employee> employeeList = employeeService.getAllEmployees();
        model.addAttribute("employeeList",employeeList);
        return "empReport";
    }







}
