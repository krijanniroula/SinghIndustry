package org.singhindustry.controller;

import javax.validation.Valid;

import org.singhindustry.entities.Sales;
import org.singhindustry.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("sales")
public class SalesController {
	
	@Autowired
	private SalesService salesService;

	@RequestMapping(value= {"","/"})
	public ModelAndView saless() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("saless",salesService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("sales/index");
		return modelAndView;
		
	}
	@GetMapping(value = "/create")
	public ModelAndView createsales(Sales sales) {
		
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.setViewName("sales/create");
		return modelAndView;
	}
	
	@PostMapping(value = "/save")
	public String savesales(@Valid Sales sales, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "sales/create";
		}
		salesService.save(sales);
		return "redirect:/sales";
	}
	
	@GetMapping(value = "/update")
	public ModelAndView updatesales(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("sales", salesService.findsales(id));
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.setViewName("sales/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/view")
	public ModelAndView viewsales(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("sales", salesService.findsales(id));
		modelAndView.addObject("mode", "MODE_VIEW");
		modelAndView.setViewName("sales/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/delete")
	public ModelAndView deletesales(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sales");
		salesService.delete(id);
		return modelAndView;
	}
	
}
