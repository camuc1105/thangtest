package com.model;

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
@Table(name = "SUDUNGDICHVU")
@IdClass(SuDungDichVuID.class)
public class SuDungDichVu implements SuDungDichVuConstraints {
	
	@Id
    @ManyToOne
    @Valid
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    private KhachHang khachhang;

    @Id
    @ManyToOne
    @Valid
    @JoinColumn(name = "MaDV", referencedColumnName = "MaDV")
    private DichVu dichvu;

    @Id
    @Column(name = "NgaySuDung")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngaysudung;


    @Id
    @Column(name = "GioSuDung")
   
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime giosudung;
    
    @Column(name = "SoLuong")
    @Positive(message = "Số lượng phải là số nguyên dương")
    private int soluong;

	public KhachHang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}

	public DichVu getDichvu() {
		return dichvu;
	}

	public void setDichvu(DichVu dichvu) {
		this.dichvu = dichvu;
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

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	

	public SuDungDichVu(@Valid KhachHang khachhang, @Valid DichVu dichvu,
			@NotNull(message = "Ngày sử dụng không được để trống") @PastOrPresent(message = "Ngày sử dụng phải là ngày hiện tại hoặc trước đó") LocalDate ngaysudung,
			@NotNull(message = "Giờ sử dụng không được để trống") LocalTime giosudung,
			@Positive(message = "Số lượng phải là số nguyên dương") int soluong) {
		super();
		this.khachhang = khachhang;
		this.dichvu = dichvu;
		this.ngaysudung = ngaysudung;
		this.giosudung = giosudung;
		this.soluong = soluong;
	}

	public SuDungDichVu() {
		super();
	}



	
}

