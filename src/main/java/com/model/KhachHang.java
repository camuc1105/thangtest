package com.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "KHACHHANG")
public class KhachHang implements KhachHangConstraints {

	@Id
    @Column(name = "MaKH")
    @Pattern(regexp = "^KH\\d{5}$", message = "Mã KH phải có định dạng KHxxxxx")
    private String makh;

    @Column(name = "TenKH")
    @NotBlank(message = "Tên khách hàng không được bỏ trống")
    private String tenkh;

    @Column(name = "DiaChi")
    @NotBlank(message = "Địa chỉ không được bỏ trống")
    private String diachi;

    @Column(name = "SoDienThoai")
    @Pattern(regexp = "^(090|091)\\d{7}$|^(84\\+90|84\\+91)\\d{7}$", 
             message = "Số điện thoại phải theo định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String sdt;

    @Column(name = "DiaChiEmail")
    @NotBlank(message = "Email không được bỏ trống")
    @Email(message = "Địa chỉ email không đúng định dạng")
    //@Pattern(regexp = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,4}$", message = "Email không đúng định dạng")
    private String email;


	@OneToMany(mappedBy = "khachhang", cascade = CascadeType.ALL)
	private Set<SuDungDichVu> suDungDichVus;
	
	@OneToMany(mappedBy = "khachhang", cascade = CascadeType.ALL)
	private Set<SuDungMay> suDungMays;

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<SuDungDichVu> getSuDungDichVus() {
		return suDungDichVus;
	}

	public void setSuDungDichVus(Set<SuDungDichVu> suDungDichVus) {
		this.suDungDichVus = suDungDichVus;
	}

	public KhachHang(String makh, String tenkh, String diachi, String sdt, String email) {
		super();
		this.makh = makh;
		this.tenkh = tenkh;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
	}

	public KhachHang() {
		super();
	}

}
