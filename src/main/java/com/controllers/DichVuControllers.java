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
import com.model.DichVu;
import com.service.DichVuService;

import jakarta.validation.Valid;

@Controller
public class DichVuControllers {

	@Autowired
	private DichVuService dichVuService;
	
	@RequestMapping("/lietkedanhsachdichvu")
	public String listDichVu(Model model) {
		List<DichVu> dichVus = dichVuService.getAllDichVu();
		model.addAttribute("dichVus", dichVus);
		return "lietkedanhsachdichvu";
	}
	
	@GetMapping("/taodichvu")
    public String hienThiDichVuForm(Model model) {
        model.addAttribute("dichVu", new DichVu());
        return "taodichvu";
    }
	
	@PostMapping("/luuDichVu")
	public String luuDichVu(@Valid @ModelAttribute("dichVu") DichVu dichVu, BindingResult result, Model model) {
		  if (result.hasErrors()) {
	            return "taodichvu";
	        }
		  
		if (dichVuService.getDichVuByMaDV(dichVu.getMadv()) != null) {
			dichVuService.updateDichVu(dichVu);
		} else {
			dichVuService.addDichVu(dichVu);
		}		
		return "redirect:/lietkedanhsachdichvu";
	}
	
	@GetMapping("/deleteDichVu")
	public String deleteDichVu(@RequestParam("madv") String madv) {
		dichVuService.deleteDichVu(madv);
		return "redirect:/lietkedanhsachdichvu";
	}
	
	@GetMapping("/searchDichVu")
    public String searchDichVu(@RequestParam("searchText") String keyword, Model model) {
        List<DichVu> dichVus = dichVuService.searchDichVuByMaDVTenDV(keyword);
        model.addAttribute("dichVus", dichVus);
        return "lietkedanhsachdichvu";
    }
	
}
