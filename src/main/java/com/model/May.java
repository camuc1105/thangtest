package com.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "MAY")
public class May {

    @Id
    @Column(name = "MaMay")
    @NotBlank(message = "Mã máy không được bỏ trống")
    @Size(max = 20, message = "Mã máy không được vượt quá 20 ký tự")
    private String mamay;

    @Column(name = "ViTri")
    @NotBlank(message = "Vị trí không được bỏ trống")
    private String vitri;

    @Column(name = "TrangThai")
    @NotBlank(message = "Trạng thái không được bỏ trống")
    private String trangthai;
    
    @OneToMany(mappedBy = "may", cascade = CascadeType.ALL)
	private Set<SuDungMay> suDungMays;

    public May() {}

    public May(String mamay, String vitri, String trangthai) {
        this.mamay = mamay;
        this.vitri = vitri;
        this.trangthai = trangthai;
    }

    public String getMamay() {
        return mamay;
    }

    public void setMamay(String mamay) {
        this.mamay = mamay;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}

