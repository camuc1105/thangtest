package com.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class SuDungMayID implements Serializable {
	
    private String khachhang;
    private String may;
    private LocalDate ngaysudung;
    private LocalTime giosudung;
	public String getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(String khachhang) {
		this.khachhang = khachhang;
	}
	public String getMay() {
		return may;
	}
	public void setMay(String may) {
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
	@Override
	public int hashCode() {
		return Objects.hash(giosudung, khachhang, may, ngaysudung);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuDungMayID other = (SuDungMayID) obj;
		return Objects.equals(giosudung, other.giosudung) && Objects.equals(khachhang, other.khachhang)
				&& Objects.equals(may, other.may) && Objects.equals(ngaysudung, other.ngaysudung);
	}
    
	
    
}

