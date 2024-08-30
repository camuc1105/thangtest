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

import com.model.KhachHang;
import com.service.KhachHangService;

import jakarta.validation.Valid;

@Controller
public class KhachHangControllers {
	
	@Autowired
	private KhachHangService khachHangService;
	
	@RequestMapping("/lietkedanhsachkhachhang")
    public String listKhachHang(Model model, @RequestParam(defaultValue = "1") int page) {
        int pageSize = 2; 
        List<KhachHang> khachHangs = khachHangService.getAllKhachHang(page, pageSize);
        long totalItems = khachHangService.getKhachHangCount();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        model.addAttribute("khachHangs", khachHangs);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "lietkedanhsachkhachhang";
    }
	
	@GetMapping("/taokhachhang")
	public String hienThiKhachHangForm(Model model) {
		model.addAttribute("khachHang", new KhachHang());
		return "taokhachhang";
	}
	
	@PostMapping("/luuKhachHang")
	public String luuKhachHang(@Valid @ModelAttribute("khachHang") KhachHang khachHang, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "taokhachhang";
        }
		
		if (khachHangService.getKhachHangByMaKH(khachHang.getMakh()) != null) {
			khachHangService.updateKhachHang(khachHang);
		} else {
			khachHangService.addKhachHang(khachHang);
		}		
		return "redirect:/lietkedanhsachkhachhang";
	}
	
	@GetMapping("/deleteKhachHang")
	public String deleteKhachHang(@RequestParam("makh") String makh) {
		khachHangService.deleteKhachHang(makh);
		return "redirect:/lietkedanhsachkhachhang";
	}
	
	@GetMapping("/searchKhachHang")
    public String searchKhachHang(@RequestParam("searchText") String keyword, Model model) {
        List<KhachHang> khachHangs = khachHangService.searchDichVuByMaDVTenDV(keyword);
        model.addAttribute("khachHangs", khachHangs);
        return "lietkedanhsachkhachhang";
    }
	
	
}
