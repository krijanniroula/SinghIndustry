package org.singhindustry.controller;

import javax.validation.Valid;

import org.singhindustry.entities.Material;
import org.singhindustry.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("material")
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;

	@RequestMapping(value= {"","/"})
	public ModelAndView Materials() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("materials",materialService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("material/index");
		return modelAndView;
		
	}
	@GetMapping(value = "/create")
	public ModelAndView createMaterial(Material material) {
		
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.setViewName("material/create");
		return modelAndView;
	}
	
	@PostMapping(value = "/save")
	public String saveMaterial(@Valid Material material, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "material/create";
		}
		materialService.save(material);
		return "redirect:/material";
	}
	
	@GetMapping(value = "/update")
	public ModelAndView updateMaterial(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("material", materialService.findMaterial(id));
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.setViewName("material/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/view")
	public ModelAndView viewMaterial(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("material", materialService.findMaterial(id));
		modelAndView.addObject("mode", "MODE_VIEW");
		modelAndView.setViewName("material/index");
		return modelAndView;
	}
	
	@GetMapping(value = "/delete")
	public ModelAndView deleteMaterial(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/material");
		materialService.delete(id);
		return modelAndView;
	}
	
}
