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

import eu.burmov.crudemployees.entity.Position;
import eu.burmov.crudemployees.service.PositionService;

@Controller
@RequestMapping("/positions")
public class PositionController {
	
	@Autowired
	private PositionService positionService;
	
	// Pages
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public String list(Model model) {
		model.addAttribute("positions", positionService.getPositions());
		return "position/list";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public String add(Model model) {
		model.addAttribute("position", new Position());
		return "position/form";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/update")
	public String update(@RequestParam("id") int id, Model model) {
		Position position = positionService.getPosition(id);
		if(position != null) {
			model.addAttribute("position", position);
			return "position/form";
		}
		return "position/list";
	}
	
	// Actions
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public String save(@Valid @ModelAttribute("position") Position p, BindingResult result) {
		if(result.hasErrors()) {
			return "position/form";
		}
		positionService.savePosition(p);
		return "redirect:/positions/list";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/delete")
	public String delete(@RequestParam("id") int id) {
		positionService.deletePosition(id);
		return "redirect:/positions/list";
	}

}
