package com.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.KhachHang;

@Repository
public class KhachHangDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addKhachHang(KhachHang khachHang) {
		sessionFactory.getCurrentSession().save(khachHang);
	}
	
	@Transactional
	public void updateKhachHang(KhachHang khachHang) {
		sessionFactory.getCurrentSession().update(khachHang);
	}
	
	@Transactional
	public List<KhachHang> getAllKhachHang(int page, int pageSize) {
	    Session session = sessionFactory.getCurrentSession();
	    int offset = (page - 1) * pageSize;
	    String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY makh) AS RowNum, * FROM KhachHang) AS RowConstrainedResult WHERE RowNum > ? AND RowNum <= ?";
	    Query<KhachHang> query = session.createNativeQuery(sql, KhachHang.class);
	    query.setParameter(1, offset);
	    query.setParameter(2, offset + pageSize);
	    return query.list();
	}

    @Transactional
    public long getKhachHangCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from KhachHang", Long.class).uniqueResult();
    }
	
	@Transactional
	public KhachHang getKhachHangByMaKH(String maKH) {
		return sessionFactory.getCurrentSession().get(KhachHang.class, maKH);
	}
	
	@Transactional
	public void deleteKhachHang(String maKH) {
		KhachHang khachHang = getKhachHangByMaKH(maKH);
		if (khachHang != null) {
			sessionFactory.getCurrentSession().delete(khachHang);
		}
	}
	
	@Transactional
    public List<KhachHang> searchDichVuByMaKHTenKH(String keyword) {
		 String hql = "FROM KhachHang WHERE makh LIKE :keyword OR tenkh LIKE :keyword";
	        return sessionFactory.getCurrentSession().createQuery(hql, KhachHang.class)
	                .setParameter("keyword", "%" + keyword + "%")
	                .getResultList();
    }
	
}
