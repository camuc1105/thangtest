package com.controllers;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.SuDungMay;
import com.model.SuDungMay;
import com.service.SuDungMayService;

import jakarta.validation.Valid;

@Controller
public class SuDungMayControllers {

    @Autowired
    private SuDungMayService suDungMayService;

    @GetMapping("/dangkysudungmay")
    public String showForm(Model model) {
        model.addAttribute("suDungMay", new SuDungMay());
        return "dangkysudungmay";
    }

    @PostMapping("/luuSuDungMay")
    public String registerService(
            @Valid @ModelAttribute("suDungMay") SuDungMay suDungMay,
            BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

//        if (bindingResult.hasErrors()) {
//            // Nếu có lỗi, quay lại form đăng ký và hiển thị lỗi
//            return "dangkysudungmay";
//        }

        String errorMessage = suDungMayService.dangKySuDungMay(
                suDungMay.getKhachhang().getMakh(),
                suDungMay.getMay().getMamay(),
                suDungMay.getNgaysudung(),
                suDungMay.getGiosudung(),
                suDungMay.getThoigiansudung()
        );

        if (errorMessage != null) {
            redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
            return "redirect:/dangkysudungmay";
        }

        return "redirect:/danhsachsudungmay";
    }

    @GetMapping("/danhsachsudungmay")
    public String listAll(Model model) {
        List<SuDungMay> suDungMayList = suDungMayService.getAllSuDungMay();
        model.addAttribute("danhsachsudungmay", suDungMayList);
        return "danhsachsudungmay";
    }
}
