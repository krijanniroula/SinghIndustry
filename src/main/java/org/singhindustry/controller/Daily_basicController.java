package org.singhindustry.controller;

import javax.validation.Valid;

import org.singhindustry.entities.Attendence;
import org.singhindustry.entities.Kharcha;
import org.singhindustry.entities.Daily_basic;
import org.singhindustry.services.AttendenceService;
import org.singhindustry.services.KharchaService;
import org.singhindustry.services.Daily_basicService;
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
@RequestMapping("daily_basic")
public class Daily_basicController {

	@Autowired
	private KharchaService kharchaService;

	@Autowired
	private AttendenceService attendenceService;

	@Autowired
	private Daily_basicService daily_basicService;

	@RequestMapping(value = { "", "/" })
	public ModelAndView daily_basics() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("daily_basics", daily_basicService.findAll());
		modelAndView.addObject("mode", "MODE_ALL");
		modelAndView.setViewName("daily_basic/index");
		return modelAndView;

	}

	@GetMapping(value = "/create")
	public ModelAndView createdaily_basic(Daily_basic daily_basic) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("daily_basic/create");
		return modelAndView;
	}

	@PostMapping(value = "/save")
	public String savedaily_basic(@Valid Daily_basic daily_basic, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "daily_basic/create";
		}
		daily_basicService.save(daily_basic);
		return "redirect:/daily_basic";
	}

	@PostMapping(value = "/kharcha")
	public String daily_basicKharcha(@Valid Kharcha kharcha, BindingResult bindingResult) {

		kharchaService.save(kharcha);
		int id = kharcha.getEmployee().getDaily_basic().getId();
		return "redirect:/daily_basic/view?id=" + id;
	}

	@PostMapping(value = "/attendence")
	public String daily_basicAttendence(@Valid Attendence attendence, BindingResult bindingResult) {

		attendenceService.save(attendence);
		int id = attendence.getEmployee().getDaily_basic().getId();
		return "redirect:/daily_basic/view?id=" + id;
	}

	@GetMapping(value = "/update")
	public ModelAndView updatedaily_basic(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("daily_basic", daily_basicService.findDaily_basic(id));
		modelAndView.addObject("mode", "MODE_UPDATE");
		modelAndView.setViewName("daily_basic/index");
		return modelAndView;
	}

	@GetMapping(value = "/view")
	public ModelAndView viewdaily_basic(@RequestParam int id, Kharcha kharcha, Attendence attendence, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("daily_basic", daily_basicService.findDaily_basic(id));

		String[] months = { "January", "February", "March", "April", "May", "June", "July", "Auguest", "September",
				"October", "November", "December" };

		model.addAttribute("months", months);

		modelAndView.setViewName("daily_basic/view");
		return modelAndView;
	}

	@GetMapping(value = "/delete")
	public ModelAndView deletedaily_basic(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/daily_basic");
		daily_basicService.delete(id);
		return modelAndView;
	}

}
