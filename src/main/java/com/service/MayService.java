package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.MayDao;
import com.model.May;

@Service
public class MayService {
	
	@Autowired
	private MayDao mayDao;

	public void addMay(May may) {
		mayDao.addMay(may);
	}

	public void updateMay(May may) {
		mayDao.updateMay(may);
	}

	public List<May> getAllMay() {
		return mayDao.getAllMay();
	}

	public May getMayByMaMay(String mamay) {
		return mayDao.getMayByMaMay(mamay);
	}

	public void deleteMay(String mamay) {
		mayDao.deleteMay(mamay);
	}
	
	 public List<May> searchDichVuByMaMay(String mamay) {
	        return mayDao.searchDichVuByMaMay(mamay);
	    }
}
