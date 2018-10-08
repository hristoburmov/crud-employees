package eu.burmov.crudemployees.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eu.burmov.crudemployees.entity.Employee;
import eu.burmov.crudemployees.service.EmployeeService;
import eu.burmov.crudemployees.service.OfficeService;
import eu.burmov.crudemployees.service.PositionService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private PositionService positionService;
	
	@Autowired
	private OfficeService officeService;
	
	// Pages
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(Model model) {
		model.addAttribute("employees", employeeService.getEmployees());
		return "employee/list";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public String add(Model model) {
		model.addAttribute("employee", new Employee());
		addPositionsOfficesToModel(model);
		return "employee/form";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/update")
	public String update(@RequestParam("id") int id, Model model) {
		Employee employee = employeeService.getEmployee(id);
		if(employee != null) {
			model.addAttribute("employee", employee);
			addPositionsOfficesToModel(model);
			return "employee/form";
		}
		return "redirect:/employees/list";
	}
	
	// Actions
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public String save(@Valid @ModelAttribute("employee") Employee e, BindingResult result, Model model) {
		if(result.hasErrors()) {
			addPositionsOfficesToModel(model);
			return "employee/form";
		}
		employeeService.saveEmployee(e);
		return "redirect:/employees/list";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/delete")
	public String delete(@RequestParam("id") int id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees/list";
	}
	
	// Helpers
	private void addPositionsOfficesToModel(Model model) {
		model.addAttribute("positions", positionService.getPositions());
		model.addAttribute("offices", officeService.getOffices());
	}

}
