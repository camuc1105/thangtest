package com.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "DICHVU")
public class DichVu implements DichVuConstraints {
	
	  	@Id
	    @Column(name = "MaDV")
	    @Pattern(regexp = "^DV\\d{3}$", message = "Mã DV phải có định dạng DVxxx")
	    private String madv;

	    @Column(name = "TenDV")
	    @NotBlank(message = "Tên dịch vụ không được để trống")
	    private String tendv;

	    @Column(name = "DonViTinh")
	    @NotBlank(message = "Đơn vị tính không được để trống")
	    private String donvitinh;

	    @Column(name = "DonGia")
	    @Positive(message = "Đơn giá phải là số nguyên dương")
	    private Double dongia;
    

    @OneToMany(mappedBy = "dichvu", cascade = CascadeType.ALL)
    private Set<SuDungDichVu> suDungDichVus;

	public String getMadv() {
		return madv;
	}

	public void setMadv(String madv) {
		this.madv = madv;
	}

	public String getTendv() {
		return tendv;
	}

	public void setTendv(String tendv) {
		this.tendv = tendv;
	}

	public String getDonvitinh() {
		return donvitinh;
	}

	public void setDonvitinh(String donvitinh) {
		this.donvitinh = donvitinh;
	}

	public Double getDongia() {
		return dongia;
	}

	public void setDongia(Double dongia) {
		this.dongia = dongia;
	}

	
	
	public Set<SuDungDichVu> getSuDungDichVus() {
		return suDungDichVus;
	}

	public void setSuDungDichVus(Set<SuDungDichVu> suDungDichVus) {
		this.suDungDichVus = suDungDichVus;
	}

	public DichVu(String madv, String tendv, String donvitinh, Double dongia) {
		super();
		this.madv = madv;
		this.tendv = tendv;
		this.donvitinh = donvitinh;
		this.dongia = dongia;
	}

	public DichVu() {
		super();
	}

	
}

