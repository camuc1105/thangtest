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

import com.dao.DichVuDao;
import com.dao.KhachHangDao;
import com.dao.SuDungDichVuDao;
import com.model.DichVu;
import com.model.KhachHang;
import com.model.SuDungDichVu;
import com.model.SuDungDichVuID;

@Service
public class SuDungDichVuService {

    @Autowired
    private KhachHangDao khachHangDao;
    
    @Autowired
    private DichVuDao dichVuDao;
    
    @Autowired
    private SuDungDichVuDao suDungDichVuDao;

    @Transactional
    public String dangKySuDungDichVu(String makh, String madv, LocalDate ngaysudung, LocalTime giosudung, int soluong) {
        KhachHang khachHang = khachHangDao.getKhachHangByMaKH(makh);
        DichVu dichVu = dichVuDao.getDichVuByMaDV(madv);

        if (khachHang == null) {
            return "Mã khách hàng không tồn tại.";
        }

        if (dichVu == null) {
            return "Mã dịch vụ không tồn tại.";
        }
        
        // Tạo đối tượng ID
        SuDungDichVuID id = new SuDungDichVuID(makh, madv, ngaysudung, giosudung);

        // Kiểm tra xem ID đã tồn tại chưa
        if (suDungDichVuDao.getSuDungDichVuByMaSuDungDichVu(id) != null) {
            return "Sử dụng dịch vụ với mã này đã tồn tại.";
        }

        SuDungDichVu suDungDichVu = new SuDungDichVu(khachHang, dichVu, ngaysudung, giosudung, soluong);
        suDungDichVuDao.addSuDungDichVu(suDungDichVu);
        return null; 
    }

    @Transactional
    public List<SuDungDichVu> getAllSuDungDichVu() {
        return suDungDichVuDao.getAllSuDungDichVu();
    }
    
}
