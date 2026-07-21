package employee.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import employee.model.Employee;
import employee.service.EmployeeService;

@Controller
public class EmployeeController {
	private EmployeeService employeeService;

	// コンストラクタインジェクション
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public String show(Model model) {
		List<Employee> employees = employeeService.findActiveEmployees();
		model.addAttribute("employees", employees);
		return "employeeList";
	}
}
