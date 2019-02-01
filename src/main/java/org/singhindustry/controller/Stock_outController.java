package org.singhindustry.controller;

import javax.validation.Valid;

import org.singhindustry.entities.Stock_out;
import org.singhindustry.services.Stock_inService;
import org.singhindustry.services.Stock_outService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("stock_out")
public class Stock_outController {
	
	@Autowired
	private Stock_outService stock_outService;
	
	@Autowired
	private Stock_inService stock_inService;

	@RequestMapping(value= {"","/"})
	public ModelAndView stock_outs() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("stock_outs",stock_outService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("stock_out/index");
		return modelAndView;
		
	}
	@GetMapping(value = "/create")
	public ModelAndView createstock_out(Stock_out stock_out) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("products",stock_inService.findAll());
		
		modelAndView.setViewName("stock_out/create");
		return modelAndView;
	}
	
	@PostMapping(value = "/save")
	public ModelAndView savestock_out(@Valid Stock_out stock_out, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("products",stock_inService.findAll());
			modelAndView.setViewName("stock_out/create");
			return modelAndView;
		}
		stock_outService.save(stock_out);
		modelAndView.setViewName("redirect:/stock_out");
		return modelAndView;
	}
	
	@GetMapping(value = "/update")
	public ModelAndView updatestock_out(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("stock_out", stock_outService.findstock_out(id));
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.addObject("products",stock_inService.findAll());
		modelAndView.setViewName("stock_out/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/view")
	public ModelAndView viewstock_out(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("stock_out", stock_outService.findstock_out(id));
		modelAndView.addObject("mode", "MODE_VIEW");
		modelAndView.setViewName("stock_out/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/delete")
	public ModelAndView deletestock_out(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/stock_out");
		stock_outService.delete(id);
		return modelAndView;
	}
	
}
