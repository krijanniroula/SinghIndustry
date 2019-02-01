package org.singhindustry.controller;

import javax.validation.Valid;

import org.singhindustry.entities.Attendence;
import org.singhindustry.entities.Cutting;
import org.singhindustry.entities.Kharcha;
import org.singhindustry.entities.Master;
import org.singhindustry.services.AttendenceService;
import org.singhindustry.services.CuttingService;
import org.singhindustry.services.KharchaService;
import org.singhindustry.services.MasterService;
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
@RequestMapping("master")
public class MasterController {

	@Autowired
	private KharchaService kharchaService;
	
	@Autowired
	private CuttingService cuttingService;

	@Autowired
	private AttendenceService attendenceService;

	@Autowired
	private MasterService masterService;

	@RequestMapping(value = { "", "/" })
	public ModelAndView masters() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("masters", masterService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("master/index");
		return modelAndView;

	}

	@GetMapping(value = "/create")
	public ModelAndView createmaster(Master master) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("master/create");
		return modelAndView;
	}

	@PostMapping(value = "/save")
	public String savemaster(@Valid Master master, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "master/create";
		}
		masterService.save(master);
		return "redirect:/master";
	}

	@PostMapping(value = "/kharcha")
	public String masterKharcha(@Valid Kharcha kharcha, BindingResult bindingResult) {

		kharchaService.save(kharcha);
		int id = kharcha.getEmployee().getMaster().getId();
		return "redirect:/master/view?id=" + id;
	}

	@PostMapping(value = "/attendence")
	public String masterAttendence(@Valid Attendence attendence, BindingResult bindingResult) {

		attendenceService.save(attendence);
		int id = attendence.getEmployee().getMaster().getId();
		return "redirect:/master/view?id=" + id;
	}
	
	@PostMapping(value = "/cutting")
	public String masterCutting(@Valid Cutting cutting, BindingResult bindingResult) {

		cuttingService.save(cutting);
		int id = cutting.getEmployee().getMaster().getId();
		return "redirect:/master/view?id=" + id;
	}

	@GetMapping(value = "/update")
	public ModelAndView updateMaster(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("master", masterService.findMaster(id));
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.setViewName("master/index");
		return modelAndView;
	}

	@GetMapping(value = "/view")
	public ModelAndView viewMaster(@RequestParam int id, Kharcha kharcha, Attendence attendence, Cutting cutting ,Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("master", masterService.findMaster(id));

		String[] months = { "January", "February", "March", "April", "May", "June", "July", "Auguest", "September",
				"October", "November", "December" };

		model.addAttribute("months", months);

		modelAndView.setViewName("master/view");
		return modelAndView;
	}

	@GetMapping(value = "/delete")
	public ModelAndView deleteMaster(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/master");
		masterService.delete(id);
		return modelAndView;
	}

}
