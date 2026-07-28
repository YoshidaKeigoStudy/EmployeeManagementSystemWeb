package employee.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import employee.form.EmployeeForm;
import employee.model.Employee;
import employee.service.EmployeeService;

@Controller
public class EmployeeController {
	private EmployeeService employeeService;

	// コンストラクタインジェクション
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// 社員一覧表示メソッド
	@GetMapping("/employees")
	public String show(Model model) {
		List<Employee> employees = employeeService.findActiveEmployees();
		model.addAttribute("employees", employees);
		return "employeeList";
	}

	// 登録メソッド
	@PostMapping("/regist")
	public String regist(EmployeeForm employeeForm) {
		Employee emp = new Employee(employeeForm.getEmployeeId(), employeeForm.getName(), employeeForm.getAge(),
				employeeForm.getDepartment());
		employeeService.register(emp);
		return "regist";
	}

	// 検索メソッド
	@GetMapping("/employees/search")
	public String search(@RequestParam("employeeId") String employeeId, Model model) {
		List<Employee> employees = Arrays.asList(employeeService.search(employeeId));
		model.addAttribute("employees", employees);
		return "employeeList";
	}

}
