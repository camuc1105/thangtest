package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.DichVu;
import com.dao.DichVuDao;

@Service
public class DichVuService {
	
	@Autowired
	private DichVuDao dichVuDao;
	
	public void addDichVu(DichVu DichVu) {
		dichVuDao.addDichVu(DichVu);
	}
	
	public void updateDichVu(DichVu DichVu) {
		dichVuDao.updateDichVu(DichVu);
	}	
	
	public List<DichVu> getAllDichVu() {
		return dichVuDao.getAllDichVu();
	}
	
	public DichVu getDichVuByMaDV(String maDV) {
		return dichVuDao.getDichVuByMaDV(maDV);
	}
	
	public void deleteDichVu(String maDV) {
		dichVuDao.deleteDichVu(maDV);
	}
	
	public List<DichVu> searchDichVuByMaDVTenDV(String keyword) {
        return dichVuDao.searchDichVuByMaDVTenDV(keyword);
    }
}
