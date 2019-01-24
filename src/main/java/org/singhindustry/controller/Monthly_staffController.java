package org.singhindustry.controller;

import javax.validation.Valid;

import org.singhindustry.entities.Attendence;
import org.singhindustry.entities.Kharcha;
import org.singhindustry.entities.Monthly_staff;
import org.singhindustry.services.AttendenceService;
import org.singhindustry.services.KharchaService;
import org.singhindustry.services.Monthly_staffService;
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
@RequestMapping("monthly_staff")
public class Monthly_staffController {

	@Autowired
	private KharchaService kharchaService;

	@Autowired
	private AttendenceService attendenceService;

	@Autowired
	private Monthly_staffService monthly_staffService;

	@RequestMapping(value = { "", "/" })
	public ModelAndView monthly_staffs() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("monthly_staffs", monthly_staffService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("monthly_staff/index");
		return modelAndView;

	}

	@GetMapping(value = "/create")
	public ModelAndView createmonthly_staff(Monthly_staff monthly_staff) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("monthly_staff/create");
		return modelAndView;
	}

	@PostMapping(value = "/save")
	public String savemonthly_staff(@Valid Monthly_staff monthly_staff, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "monthly_staff/create";
		}
		monthly_staffService.save(monthly_staff);
		return "redirect:/monthly_staff";
	}

	@PostMapping(value = "/kharcha")
	public String monthly_staffKharcha(@Valid Kharcha kharcha) {

		kharchaService.save(kharcha);
		int id = kharcha.getEmployee().getMonthly_staff().getId();
		return "redirect:/monthly_staff/view?id=" + id;
	}

	@PostMapping(value = "/attendence")
	public String monthly_staffAttendence(@Valid Attendence attendence) {

		attendenceService.save(attendence);
		int id = attendence.getEmployee().getMonthly_staff().getId();
		return "redirect:/monthly_staff/view?id=" + id;
	}

	@GetMapping(value = "/update")
	public ModelAndView updatemonthly_staff(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("monthly_staff", monthly_staffService.findmonthly_staff(id));
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.setViewName("monthly_staff/index");
		return modelAndView;
	}

	@GetMapping(value = "/view")
	public ModelAndView viewmonthly_staff(@RequestParam int id, Kharcha kharcha, Attendence attendence, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("monthly_staff", monthly_staffService.findmonthly_staff(id));

		String[] months = { "January", "February", "March", "April", "May", "June", "July", "Auguest", "September",
				"October", "November", "December" };

		model.addAttribute("months", months);

		modelAndView.setViewName("monthly_staff/view");
		return modelAndView;
	}

	@GetMapping(value = "/delete")
	public ModelAndView deletemonthly_staff(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/monthly_staff");
		monthly_staffService.delete(id);
		return modelAndView;
	}

}
