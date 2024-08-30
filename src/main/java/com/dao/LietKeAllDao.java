package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LietKeAllDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public List<Object[]> getCustomerUsageDetails() {
        String sql = "SELECT kh.MaKH, kh.TenKH, m.MaMay, m.ViTri, m.TrangThai, " +
                     "sm.NgayBatDauSuDung, sm.GioBatDauSuDung, sm.ThoiGianSuDung, " +
                     "dv.MaDV, sdv.NgaySuDung, sdv.GioSuDung, sdv.SoLuong, " +
                     "(dv.DonGia * sdv.SoLuong) AS ThanhTien, " +
                     "SUM(dv.DonGia * sdv.SoLuong) OVER(PARTITION BY kh.MaKH) AS TongTien " +
                     "FROM KHACHHANG kh " +
                     "JOIN SUDUNGMAY sm ON kh.MaKH = sm.MaKH " +
                     "JOIN MAY m ON sm.MaMay = m.MaMay " +
                     "LEFT JOIN SUDUNGDICHVU sdv ON kh.MaKH = sdv.MaKH " +
                     "LEFT JOIN DICHVU dv ON sdv.MaDV = dv.MaDV " +
                     "ORDER BY kh.MaKH, m.MaMay, sdv.NgaySuDung";

        Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
      

        return query.getResultList();
    }
    
    
//    @Transactional
//    public List<Object[]> getCustomerUsageDetails() {
//        String hql = "SELECT kh.makh, kh.tenkh, m.mamay, m.vitri, m.trangthai, " +
//                     "sm.ngaysudung, sm.giosudung, sm.thoigiansudung, " +
//                     "dv.madv, sdv.ngaysudung, sdv.giosudung, sdv.soluong, " +
//                     "(dv.dongia * sdv.soluong) AS ThanhTien, " +
//                     "SUM(dv.dongia * sdv.soluong) OVER(PARTITION BY kh.makh) AS TongTien " +
//                     "FROM KhachHang kh " +
//                     "JOIN kh.suDungMays sm " +
//                     "JOIN sm.may m " +
//                     "LEFT JOIN kh.suDungDichVus sdv " +
//                     "LEFT JOIN sdv.dichvu dv " +
//                     "ORDER BY kh.makh, m.mamay, sdv.ngaysudung";
//
//        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//        return query.getResultList();
//    }


//    @Transactional
//    public long countTotalRecords() {
//        String sql = "SELECT COUNT(*) FROM KHACHHANG kh " +
//                     "JOIN SUDUNGMAY sm ON kh.MaKH = sm.MaKH " +
//                     "JOIN MAY m ON sm.MaMay = m.MaMay " +
//                     "LEFT JOIN SUDUNGDICHVU sdv ON kh.MaKH = sdv.MaKH " +
//                     "LEFT JOIN DICHVU dv ON sdv.MaDV = dv.MaDV";
//        return ((Number) sessionFactory.getCurrentSession().createSQLQuery(sql).uniqueResult()).longValue();
//    }
}
