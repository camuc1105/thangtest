package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LietKeAllDao;

@Service
public class LietKeAllService {

	@Autowired
	private LietKeAllDao lietKeAllDao;
	
	public List<Object[]> getCustomerUsageDetails(){
		return lietKeAllDao.getCustomerUsageDetails();
		
	}

}
