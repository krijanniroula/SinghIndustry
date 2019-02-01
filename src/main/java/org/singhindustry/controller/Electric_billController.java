package org.singhindustry.controller;

import javax.validation.Valid;

import org.singhindustry.entities.Electric_bill;
import org.singhindustry.services.Electric_billService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("electric_bill")
public class Electric_billController {
	
	@Autowired
	private Electric_billService electric_billService;

	@RequestMapping(value= {"","/"})
	public ModelAndView electric_bills() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("electric_bills",electric_billService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("electric_bill/index");
		return modelAndView;
		
	}
	@GetMapping(value = "/create")
	public ModelAndView createelectric_bill(Electric_bill electric_bill,Model model) {
		
		String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		
		model.addAttribute("months", monthNames);
		
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.setViewName("electric_bill/create");
		return modelAndView;
	}
	
	@PostMapping(value = "/save")
	public String saveelectric_bill(@Valid Electric_bill electric_bill, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "electric_bill/create";
		}
		electric_billService.save(electric_bill);
		return "redirect:/electric_bill";
	}
	
	@GetMapping(value = "/update")
	public ModelAndView updateelectric_bill(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("electric_bill", electric_billService.findelectric_bill(id));
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.setViewName("electric_bill/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/view")
	public ModelAndView viewelectric_bill(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("electric_bill", electric_billService.findelectric_bill(id));
		modelAndView.addObject("mode", "MODE_VIEW");
		modelAndView.setViewName("electric_bill/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/delete")
	public ModelAndView deleteelectric_bill(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/electric_bill");
		electric_billService.delete(id);
		return modelAndView;
	}
	
}
