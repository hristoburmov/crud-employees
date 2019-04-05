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

import eu.burmov.crudemployees.entity.Office;
import eu.burmov.crudemployees.service.OfficeService;

@Controller
@RequestMapping("/offices")
public class OfficeController {
	
	private OfficeService officeService;
	
	// Constructors
	@Autowired
	public OfficeController(OfficeService officeService) {
		this.officeService = officeService;
	}
	
	// Pages
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(Model model) {
		model.addAttribute("offices", officeService.getOffices());
		return "office/list";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public String add(Model model) {
		model.addAttribute("office", new Office());
		return "office/form";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/update")
	public String update(@RequestParam("id") int id, Model model) {
		Office office = officeService.getOffice(id);
		if(office != null) {
			model.addAttribute("office", office);
			return "office/form";
		}
		return "redirect:/offices/list";
	}
	
	// Actions
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public String save(@Valid @ModelAttribute("office") Office o, BindingResult result) {
		if(result.hasErrors()) {
			return "office/form";
		}
		officeService.saveOffice(o);
		return "redirect:/offices/list";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/delete")
	public String delete(@RequestParam("id") int id) {
		officeService.deleteOffice(id);
		return "redirect:/offices/list";
	}

}
