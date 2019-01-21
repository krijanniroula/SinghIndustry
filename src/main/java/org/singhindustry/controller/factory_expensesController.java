package org.singhindustry.controller;

import javax.validation.Valid;

import org.singhindustry.entities.Factory_expenses;
import org.singhindustry.services.Factory_expensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("factory_expenses")
public class factory_expensesController {
	
	@Autowired
	private Factory_expensesService factory_expensesService;

	@RequestMapping(value= {"","/"})
	public ModelAndView factory_expensess() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("factory_expensess",factory_expensesService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("factory_expenses/index");
		return modelAndView;
		
	}
	@GetMapping(value = "/create")
	public ModelAndView createfactory_expenses(Factory_expenses factory_expenses) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("factory_expenses/create");
		return modelAndView;
	}
	
	@PostMapping(value = "/save")
	public String savefactory_expenses(@Valid Factory_expenses factory_expenses, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "factory_expenses/create";
		}
		factory_expensesService.save(factory_expenses);
		return "redirect:/factory_expenses";
	}
	
	@GetMapping(value = "/update")
	public ModelAndView updatefactory_expenses(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("factory_expenses", factory_expensesService.findfactory_expenses(id));
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.setViewName("factory_expenses/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/view")
	public ModelAndView viewfactory_expenses(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("factory_expenses", factory_expensesService.findfactory_expenses(id));
		modelAndView.addObject("mode", "MODE_VIEW");
		modelAndView.setViewName("factory_expenses/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/delete")
	public ModelAndView deletefactory_expenses(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/factory_expenses");
		factory_expensesService.delete(id);
		return modelAndView;
	}
	
}
