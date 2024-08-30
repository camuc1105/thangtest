package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.KhachHangDao;
import com.model.KhachHang;

@Service
public class KhachHangService {

	@Autowired
	private KhachHangDao khachHangDao;
	
	public void addKhachHang(KhachHang khachHang) {
		khachHangDao.addKhachHang(khachHang);
	}
	
	public void updateKhachHang(KhachHang khachHang) {
		khachHangDao.updateKhachHang(khachHang);
	}	
	
	 public List<KhachHang> getAllKhachHang(int page, int pageSize) {
	        return khachHangDao.getAllKhachHang(page, pageSize);
	    }

	    public long getKhachHangCount() {
	        return khachHangDao.getKhachHangCount();
	    }
	
	public KhachHang getKhachHangByMaKH(String maKH) {
		return khachHangDao.getKhachHangByMaKH(maKH);
	}
	
	public void deleteKhachHang(String maKH) {
		khachHangDao.deleteKhachHang(maKH);
	}
	
	public List<KhachHang> searchDichVuByMaDVTenDV(String keyword) {
        return khachHangDao.searchDichVuByMaKHTenKH(keyword);
    }
		 
		
}
