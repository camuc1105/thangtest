package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.model.May;
import com.service.MayService;
import jakarta.validation.Valid;

@Controller
public class MayControllers {

	@Autowired
	private MayService mayService;

	@RequestMapping("/lietkedanhsachmay")
	public String listMays(Model model) {
		List<May> mays = mayService.getAllMay();
		model.addAttribute("mays", mays);
		return "lietkedanhsachmay";
	}

	/*
	 * @GetMapping("/taomay") public String showAddMayForm(Model
	 * model, @RequestParam(value = "mamay", required = false) String mamay) { if
	 * (mamay != null) { May may = mayService.getMayByMaMay(mamay);
	 * model.addAttribute("may", may); } else { model.addAttribute("may", new
	 * May()); } return "taomay"; }
	 */

	@GetMapping("/taomay")
	public String hienThiKhachHangForm(Model model) {
		model.addAttribute("may", new May());
		return "taomay";
	}

	@PostMapping("/saveMay")
	public String saveMay(@Valid @ModelAttribute("may") May may, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("bindingResult", bindingResult);
			return "taomay";
		}

		if (mayService.getMayByMaMay(may.getMamay()) != null) {
			mayService.updateMay(may);
		} else {
			mayService.addMay(may);
		}
		return "redirect:/lietkedanhsachmay";
	}

	@GetMapping("/deleteMay")
	public String deleteMay(@RequestParam("mamay") String mamay) {
		mayService.deleteMay(mamay);
		return "redirect:/lietkedanhsachmay";
	}

	@GetMapping("/searchMay")
	public String searchMay(@RequestParam("searchText") String mamay, Model model) {
		List<May> mays = mayService.searchDichVuByMaMay(mamay);
		model.addAttribute("mays", mays);
		return "lietkedanhsachmay";
	}
}
