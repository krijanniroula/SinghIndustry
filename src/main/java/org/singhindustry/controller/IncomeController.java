package org.singhindustry.controller;

import javax.validation.Valid;

import org.singhindustry.entities.Income;
import org.singhindustry.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("income")
public class IncomeController {
	
	@Autowired
	private IncomeService incomeService;

	@RequestMapping(value= {"","/"})
	public ModelAndView income() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("incomes",incomeService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("income/index");
		return modelAndView;
		
	}
	@GetMapping(value = "/create")
	public ModelAndView createincome(Income income) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("income/create");
		return modelAndView;
	}
	
	@PostMapping(value = "/save")
	public String saveincome(@Valid Income income, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "income/create";
		}
		incomeService.save(income);
		return "redirect:/income";
	}
	
	@GetMapping(value = "/update")
	public ModelAndView updateincome(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("income", incomeService.findincome(id));
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.setViewName("income/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/view")
	public ModelAndView viewincome(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("income", incomeService.findincome(id));
		modelAndView.addObject("mode", "MODE_VIEW");
		modelAndView.setViewName("income/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/delete")
	public ModelAndView deleteincome(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/income");
		incomeService.delete(id);
		return modelAndView;
	}
	
}
