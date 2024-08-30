package com.service;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.KhachHangDao;
import com.dao.MayDao;
import com.dao.SuDungMayDao;
import com.model.KhachHang;
import com.model.May;
import com.model.SuDungMay;

@Service
public class SuDungMayService {

	@Autowired
	private KhachHangDao khachHangDao;

	@Autowired
	private MayDao mayDao;

	@Autowired
	private SuDungMayDao suDungMayDao;

	@Transactional
	public String dangKySuDungMay(String makh, String mamay, LocalDate ngaysudung, LocalTime giosudung, int soluong) {
		KhachHang khachhang = khachHangDao.getKhachHangByMaKH(makh);
		May may = mayDao.getMayByMaMay(mamay);

		if (khachhang == null) {
			return "Mã khách hàng không tồn tại.";
		}

		if (may == null) {
			return "Mã máy không tồn tại.";
		}

		SuDungMay suDungMay = new SuDungMay(khachhang, may, ngaysudung, giosudung, soluong);
		suDungMayDao.addSuDungMay(suDungMay);
		return null; // Không có lỗi, trả về null
	}

	@Transactional
	public List<SuDungMay> getAllSuDungMay() {
		return suDungMayDao.getAllSuDungMay();
	}

//	// Hàm hỗ trợ chuyển đổi String sang Date
//	public Date convertStringToDate(String dateStr) {
//		return Date.valueOf(dateStr);
//	}
//
//	// Hàm hỗ trợ chuyển đổi String sang Time
//	public Time convertStringToTime(String timeStr) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//		long ms = sdf.parse(timeStr).getTime();
//		return new Time(ms);
//	}
}
