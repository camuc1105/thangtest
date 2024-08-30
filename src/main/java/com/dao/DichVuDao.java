package com.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.DichVu;

@Repository
public class DichVuDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addDichVu(DichVu dichVu) {
		sessionFactory.getCurrentSession().save(dichVu);
	}
	
	@Transactional
	public void updateDichVu(DichVu dichVu) {
		sessionFactory.getCurrentSession().update(dichVu);
	}
	
	@Transactional
	public List<DichVu> getAllDichVu() {
		return sessionFactory.getCurrentSession().createQuery("from DichVu", DichVu.class).list();
	}
	
	@Transactional
	public DichVu getDichVuByMaDV(String maDV) {
		return sessionFactory.getCurrentSession().get(DichVu.class, maDV);
	}
	
	@Transactional
	public void deleteDichVu(String maDV) {
		DichVu dichVu = getDichVuByMaDV(maDV);
		if (dichVu != null) {
			sessionFactory.getCurrentSession().delete(dichVu);
		}
	}
	
	@Transactional
    public List<DichVu> searchDichVuByMaDVTenDV(String keyword) {
		 String hql = "FROM DichVu WHERE madv LIKE :keyword OR tendv LIKE :keyword";
	        return sessionFactory.getCurrentSession().createQuery(hql, DichVu.class)
	                .setParameter("keyword", "%" + keyword + "%")
	                .getResultList();
    }
}
