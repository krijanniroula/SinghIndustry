package org.singhindustry.controller;

import java.util.ArrayList;
import java.util.List;

import org.singhindustry.entities.Employee;
import org.singhindustry.entities.Material;
import org.singhindustry.entities.Sales;
import org.singhindustry.entities.Stock_in;
import org.singhindustry.services.EmployeeService;
import org.singhindustry.services.MaterialService;
import org.singhindustry.services.SalesService;
import org.singhindustry.services.Stock_inService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@Autowired
	private Stock_inService stock_inService;
	
	@Autowired
	private SalesService salesService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private MaterialService materialService;
	
	@GetMapping(value={"/", "/login"})
    public String loginForm(){
        return "login";
    }
	
	@GetMapping("/home")
	public ModelAndView indexPage() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<Stock_in> stocks = new ArrayList<>();
		stocks = stock_inService.findAll();
		int stockCount = stocks.size();
		modelAndView.addObject("stockCount", stockCount);
		
		List<Sales> sales = new ArrayList<>();
		sales = salesService.findAll();
		int salesCount = sales.size();
		modelAndView.addObject("salesCount", salesCount);
		
		List<Employee> employee = new ArrayList<>();
		employee = employeeService.findAll();
		int employeeCount = employee.size();
		modelAndView.addObject("employeeCount", employeeCount);
		
		List<Material> material = new ArrayList<>();
		material = materialService.findAll();
		int materialCount = material.size();
		modelAndView.addObject("materialCount", materialCount);
		
		modelAndView.setViewName("index");
		
		return modelAndView;
	}
	
}
