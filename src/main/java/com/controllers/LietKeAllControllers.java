package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.LietKeAllService;

@Controller
public class LietKeAllControllers {

	@Autowired
	private LietKeAllService lietKeAllService;

	@GetMapping("/lietkeall")
	public String getCustomerUsageDetails(Model model) {
			List<Object[]> details = lietKeAllService.getCustomerUsageDetails();			
	        model.addAttribute("usageDetails", details);
		return "lietkeall";
	}
}
