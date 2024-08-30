package com.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class SuDungDichVuID implements Serializable {
	
    private String khachhang;
    private String dichvu;
    private LocalDate ngaysudung;
    private LocalTime giosudung;
    
	public String getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(String khachhang) {
		this.khachhang = khachhang;
	}
	public String getDichvu() {
		return dichvu;
	}
	public void setDichvu(String dichvu) {
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
	@Override
	public int hashCode() {
		return Objects.hash(dichvu, giosudung, khachhang, ngaysudung);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuDungDichVuID other = (SuDungDichVuID) obj;
		return Objects.equals(dichvu, other.dichvu) && Objects.equals(giosudung, other.giosudung)
				&& Objects.equals(khachhang, other.khachhang) && Objects.equals(ngaysudung, other.ngaysudung);
	}
	public SuDungDichVuID(String khachhang, String dichvu, LocalDate ngaysudung, LocalTime giosudung) {
		super();
		this.khachhang = khachhang;
		this.dichvu = dichvu;
		this.ngaysudung = ngaysudung;
		this.giosudung = giosudung;
	}
	public SuDungDichVuID() {
		super();
	}
	
	
    
	
}
