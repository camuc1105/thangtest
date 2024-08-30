package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.DichVuConstraints;
import com.model.KhachHangConstraints;
import com.model.SuDungDichVu;
import com.model.SuDungDichVuConstraints;
import com.service.SuDungDichVuService;

import jakarta.validation.Valid;

@Controller
public class SuDungDichVuControllers {

    @Autowired
    private SuDungDichVuService suDungDichVuService;

    @GetMapping("/dangkysudungdichvu")
    public String showForm(Model model) {
        model.addAttribute("suDungDichVu", new SuDungDichVu());
        return "dangkysudungdichvu";
    }

    @PostMapping("/luuSuDungDichVu")
    public String registerService(
            @Validated({KhachHangConstraints.class, DichVuConstraints.class, SuDungDichVuConstraints.class}) @ModelAttribute("suDungDichVu") SuDungDichVu suDungDichVu,
            BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "dangkysudungdichvu";
        }

        String errorMessage = suDungDichVuService.dangKySuDungDichVu(
                suDungDichVu.getKhachhang().getMakh(),
                suDungDichVu.getDichvu().getMadv(),
                suDungDichVu.getNgaysudung(),
                suDungDichVu.getGiosudung(),
                suDungDichVu.getSoluong()
        );

        if (errorMessage != null) {
            redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
            return "redirect:/dangkysudungdichvu";
        }

        return "redirect:/danhsachsudungdichvu";
    }

    @GetMapping("/danhsachsudungdichvu")
    public String listAll(Model model) {
        List<SuDungDichVu> suDungDichVuList = suDungDichVuService.getAllSuDungDichVu();
        model.addAttribute("danhsachsudungdichvu", suDungDichVuList);
        return "danhsachsudungdichvu";
    }
}
