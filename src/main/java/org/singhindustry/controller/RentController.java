package org.singhindustry.controller;

import javax.validation.Valid;

import org.singhindustry.entities.Rent;
import org.singhindustry.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("rent")
public class RentController {
	
	@Autowired
	private RentService rentService;

	@RequestMapping(value= {"","/"})
	public ModelAndView rents() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("rents",rentService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("rent/index");
		return modelAndView;
		
	}
	@GetMapping(value = "/create")
	public ModelAndView createrent(Rent rent) {
		
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.setViewName("rent/create");
		return modelAndView;
	}
	
	@PostMapping(value = "/save")
	public String saverent(@Valid Rent rent, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "rent/create";
		}
		rentService.save(rent);
		return "redirect:/rent";
	}
	
	@GetMapping(value = "/update")
	public ModelAndView updaterent(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("rent", rentService.findrent(id));
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.setViewName("rent/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/view")
	public ModelAndView viewrent(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("rent", rentService.findrent(id));
		modelAndView.addObject("mode", "MODE_VIEW");
		modelAndView.setViewName("rent/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/delete")
	public ModelAndView deleterent(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/rent");
		rentService.delete(id);
		return modelAndView;
	}
	
}
