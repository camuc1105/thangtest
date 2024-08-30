package com.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "SUDUNGMAY")
@IdClass(SuDungMayID.class)
public class SuDungMay {
	
    @Id
    @ManyToOne
    @Valid
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    private KhachHang khachhang;

    @Id
    @ManyToOne
    @Valid
    @JoinColumn(name = "MaMay", referencedColumnName = "MaMay")
    private May may;

    @Id
    @Column(name = "NgayBatDauSuDung")
    @NotNull(message = "Ngày sử dụng không được để trống")
    @PastOrPresent(message = "Ngày sử dụng phải là ngày hiện tại hoặc trước đó")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngaysudung;

    @Id
    @Column(name = "GioBatDauSuDung")
    @NotNull(message = "Giờ sử dụng không được để trống")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime giosudung;

    @Column(name = "ThoiGianSuDung")
    @Positive(message = "Số lượng phải là số nguyên dương")
    private int thoigiansudung;

	public KhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public May getMay() {
		return may;
	}

	public void setMay(May may) {
		this.may = may;
	}

	

	public LocalDate getNgaysudung() {
		return ngaysudung;
	}

	public void setNgaysudung(LocalDate ngaysudung) {
		this.ngaysudung = ngaysudung;
	}

	public LocalTime getGiosudung() {
		return giosudung;
	}

	public void setGiosudung(LocalTime giosudung) {
		this.giosudung = giosudung;
	}

	public int getThoigiansudung() {
		return thoigiansudung;
	}

	public void setThoigiansudung(int thoigiansudung) {
		this.thoigiansudung = thoigiansudung;
	}

	public SuDungMay() {
		super();
	}

	public SuDungMay(KhachHang khachhang, May may, LocalDate ngaysudung, LocalTime giosudung, int thoigiansudung) {
		super();
		this.khachhang = khachhang;
		this.may = may;
		this.ngaysudung = ngaysudung;
		this.giosudung = giosudung;
		this.thoigiansudung = thoigiansudung;
	}

	
	
    
}

