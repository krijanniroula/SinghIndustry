package org.singhindustry.controller;

import javax.validation.Valid;

import org.singhindustry.entities.Attendence;
import org.singhindustry.entities.Kharcha;
import org.singhindustry.entities.Karigar;
import org.singhindustry.entities.Karigar_record;
import org.singhindustry.services.AttendenceService;
import org.singhindustry.services.KharchaService;
import org.singhindustry.services.KarigarService;
import org.singhindustry.services.Karigar_recordService;
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
@RequestMapping("karigar")
public class KarigarController {

	@Autowired
	private KharchaService kharchaService;

	@Autowired
	private AttendenceService attendenceService;
	
	@Autowired
	private Karigar_recordService karigar_recordService;

	@Autowired
	private KarigarService karigarService;

	@RequestMapping(value = { "", "/" })
	public ModelAndView karigars() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("karigars", karigarService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("karigar/index");
		return modelAndView;

	}

	@GetMapping(value = "/create")
	public ModelAndView createkarigar(Karigar karigar) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("karigar/create");
		return modelAndView;
	}

	@PostMapping(value = "/save")
	public String savekarigar(@Valid Karigar karigar, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "karigar/create";
		}
		karigarService.save(karigar);
		return "redirect:/karigar";
	}

	@PostMapping(value = "/kharcha")
	public String karigarKharcha(@Valid Kharcha kharcha, BindingResult bindingResult) {

		kharchaService.save(kharcha);
		int id = kharcha.getEmployee().getKarigar().getId();
		return "redirect:/karigar/view?id=" + id;
	}

	@PostMapping(value = "/attendence")
	public String karigarAttendence(@Valid Attendence attendence, BindingResult bindingResult) {

		attendenceService.save(attendence);
		int id = attendence.getEmployee().getKarigar().getId();
		return "redirect:/karigar/view?id=" + id;
	}
	
	@PostMapping(value = "/record")
	public String karigarRecord(@Valid Karigar_record karigar_record, BindingResult bindingResult) {

		karigar_recordService.save(karigar_record);
		int id = karigar_record.getEmployee().getKarigar().getId();
		return "redirect:/karigar/view?id=" + id;
	}

	@GetMapping(value = "/update")
	public ModelAndView updateKarigar(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("karigar", karigarService.findKarigar(id));
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.setViewName("karigar/index");
		return modelAndView;
	}

	@GetMapping(value = "/view")
	public ModelAndView viewKarigar(@RequestParam int id, Kharcha kharcha, Attendence attendence,Karigar_record karigar_record ,Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("karigar", karigarService.findKarigar(id));

		String[] months = { "January", "February", "March", "April", "May", "June", "July", "Auguest", "September",
				"October", "November", "December" };

		model.addAttribute("months", months);

		modelAndView.setViewName("karigar/view");
		return modelAndView;
	}

	@GetMapping(value = "/delete")
	public ModelAndView deleteKarigar(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/karigar");
		karigarService.delete(id);
		return modelAndView;
	}

}
