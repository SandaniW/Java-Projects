package com.HRMS.Leave.Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/hrms")
public class HrmsController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    private EmpLoginRepository empLoginRepository;

    @Autowired
    private AdminLoginRepo adminLoginRepo;

    @Autowired
    EmployeeRepo employeeRepo;



    @GetMapping("/welcome")
    public String welcom(Model model){
        return "Login";
    }
    @GetMapping("admin/dashboard")
    public String dashboard(Model model){
        return "Dashboard";
    }

    //employee login page getting id and password
    @GetMapping("/login/employee")
    public String empLogin(Model model) {
        model.addAttribute("EmpLogin", new EmpLogin());
        return "Employeelogin";
    }

    //checking password and id for employee
    @PostMapping("/login/employee")
    public String checkEmpLogin(@RequestParam long id, @RequestParam String password, Model model) {

        EmpLogin empLogin = empLoginRepository.getReferenceById(id);
        if (empLogin != null && empLogin.getPassword().equals(password)) {
            return "Dashboard"; // Successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "Employeelogin"; // Failed login
        }
    }

    //admin login page
    @GetMapping("/login/admin")
    public String adminLogin(Model model) {
        model.addAttribute("AdminLogin", new AdminLogin());
        return "AdminLogin";
    }

    //checking password and id
    @PostMapping("/login/admin")
    public String checkAdminLogin(@RequestParam long id, @RequestParam String password, Model model) {

        AdminLogin adminLogin = adminLoginRepo.getReferenceById(id);
        if (adminLogin != null && adminLogin.getPassword().equals(password)) {
            return "redirect:/Dashboard"; // Successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "AdminLogin"; // Failed login
        }
    }

    //add
    @PostMapping
    @RequestMapping("/admin/addEmployee")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "newEmployee";
    }
    //edit employee
    @GetMapping
    @RequestMapping("/admin/editEmployee/{empId}")
    public String editEmployee(@PathVariable(name = "empId") long id){
        ModelAndView mav =  new ModelAndView("edit_Employee");
        Employee employee = employeeService.getEmployee(id);
        mav.addObject("employee",employee);
        return "redirect/admin/dashboard"; //redirect to the search result page list


    }
    //remove employee
    @GetMapping
    @RequestMapping("/admin/removeEmployee/{empId}")
    public String deleteEmployee(@PathVariable(name="empId") long id){
        employeeService.deleteEmployee(id);
        return "redirect/admin/dashboard"; //redirect to the search result page list
    }

    //search - get employee by id,name
    @GetMapping
    @RequestMapping("/admin/search")
    public String getEmployeeSearch(@RequestParam("query") String query, @RequestParam("searchCriteria") String searchCriteria, Model model) {
        List<Employee> searchResults = null;
        List<Employee> employees = null;
        switch(searchCriteria) {
            case "empID":
                employees = employeeRepo.findByEmpID(Long.parseLong(query));
                break;
            case "firstName":
                employees = employeeRepo.findByFirstNameContaining(query);
                break;
            case "lastName":
                employees = employeeRepo.findByLastNameContaining(query);
                break;
            case "contactNumber":
                employees = employeeRepo.findByContactNumberContaining(query);
                break;
            case "empEmail":
                employees = employeeRepo.findByEmpEmailContaining(query);
                break;
            case "joinDate":
                employees = employeeRepo.findByJoinDateContaining(query);
                break;
            case "empStatus":
                employees = employeeRepo.findByEmpStatusContaining(query);
                break;
            default:

                break;
        }
        searchResults = employees;
        model.addAttribute("searchResults", searchResults);
        return "searchResults";
    }
    //show search
    @GetMapping("/admin/search")
    public String searchForm() {
        return "search";
    }


    //report with employee id,name and leave balance
    @GetMapping
    @RequestMapping("/admin/report")
    public String report(Model model){
        model.addAttribute("employees",employeeService.getEmployeelist());
        return "report";
    }

    //for editing and romoving employees
    @GetMapping
    @RequestMapping("/admin/editRemove")
    public String editRemove(Model model){
        model.addAttribute("employees",employeeService.getEmployeelist());
        return "EditRemove";
    }
}

