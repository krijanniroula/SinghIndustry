package org.singhindustry.controller;

import javax.validation.Valid;

import org.singhindustry.entities.Machinary;
import org.singhindustry.services.MachinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("machinary")
public class MachinaryController {
	
	@Autowired
	private MachinaryService machinaryService;

	@RequestMapping(value= {"","/"})
	public ModelAndView Machinary() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("machinarys",machinaryService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("machinary/index");
		return modelAndView;
		
	}
	@GetMapping(value = "/create")
	public ModelAndView createMachinary(Machinary machinary) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("machinary/create");
		return modelAndView;
	}
	
	@PostMapping(value = "/save")
	public String saveMachinary(@Valid Machinary machinary, BindingResult bindingResult,Model model) {
		
		if (bindingResult.hasErrors()) {
			return "machinary/create";
		}
		machinaryService.save(machinary);
		return "redirect:/machinary";
	}
	
	@GetMapping(value = "/update")
	public ModelAndView updateMachinary(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("machinary", machinaryService.findMachinary(id));
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.setViewName("machinary/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/view")
	public ModelAndView viewMachinary(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("machinary", machinaryService.findMachinary(id));
		modelAndView.addObject("mode", "MODE_VIEW");
		modelAndView.setViewName("machinary/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/delete")
	public ModelAndView deleteMachinary(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/machinary");
		machinaryService.delete(id);
		return modelAndView;
	}
	
}
