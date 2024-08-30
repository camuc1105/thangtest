package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.May;

@Repository
public class MayDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void addMay(May may) {
		sessionFactory.getCurrentSession().save(may);
	}

	@Transactional
	public void updateMay(May may) {
		sessionFactory.getCurrentSession().update(may);
	}

	@Transactional
	public List<May> getAllMay() {
		return sessionFactory.getCurrentSession().createQuery("from May", May.class).list();
	}

	@Transactional
	public May getMayByMaMay(String mamay) {
		return sessionFactory.getCurrentSession().get(May.class, mamay);
	}

	@Transactional
	public void deleteMay(String mamay) {
		May may = getMayByMaMay(mamay);
		if (may != null) {
			sessionFactory.getCurrentSession().delete(may);
		}
	}
	
	@Transactional
    public List<May> searchDichVuByMaMay(String mamay) {
		 String hql = "FROM May WHERE mamay LIKE :mamay";
	        return sessionFactory.getCurrentSession().createQuery(hql, May.class)
	                .setParameter("mamay", "%" + mamay + "%")
	                .getResultList();
    }
}

