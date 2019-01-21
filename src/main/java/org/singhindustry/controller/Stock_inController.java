package org.singhindustry.controller;

import javax.validation.Valid;

import org.singhindustry.entities.Stock_in;
import org.singhindustry.services.Stock_inService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("stock_in")
public class Stock_inController {
	
	@Autowired
	private Stock_inService stock_inService;

	@RequestMapping(value= {"","/"})
	public ModelAndView stock_ins() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("stock_ins",stock_inService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("stock_in/index");
		return modelAndView;
		
	}
	@GetMapping(value = "/create")
	public ModelAndView createstock_in(Stock_in stock_in) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("stock_in/create");
		return modelAndView;
	}
	
	@PostMapping(value = "/save")
	public String savestock_in(@Valid Stock_in stock_in, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("has error");
			return "stock_in/create";
		}
		stock_inService.save(stock_in);
		return "redirect:/stock_in";
	}
	
	@GetMapping(value = "/update")
	public ModelAndView updatestock_in(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("stock_in", stock_inService.findstock_in(id));
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.setViewName("stock_in/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/view")
	public ModelAndView viewstock_in(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("stock_in", stock_inService.findstock_in(id));
		modelAndView.addObject("mode", "MODE_VIEW");
		modelAndView.setViewName("stock_in/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/delete")
	public ModelAndView deletestock_in(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/stock_in");
		stock_inService.delete(id);
		return modelAndView;
	}
	
}
