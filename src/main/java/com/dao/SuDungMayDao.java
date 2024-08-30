package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.SuDungMay;
import com.model.SuDungMayID;

@Repository
public class SuDungMayDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void addSuDungMay(SuDungMay suDungMay) {
		sessionFactory.getCurrentSession().save(suDungMay);
	}

	@Transactional
	public void updateSuDungMay(SuDungMay suDungMay) {
		sessionFactory.getCurrentSession().update(suDungMay);
	}

	@Transactional
	public List<SuDungMay> getAllSuDungMay() {
		return sessionFactory.getCurrentSession().createQuery("from SuDungMay", SuDungMay.class).getResultList();
	}

	@Transactional
	public SuDungMay getSuDungMayByMaSuDungMay(SuDungMayID  id) {
		return sessionFactory.getCurrentSession().get(SuDungMay.class, id);
	}

	@Transactional
	public void deleteSuDungMay(SuDungMayID id) {
		SuDungMay suDungMay = getSuDungMayByMaSuDungMay(id);
		if (suDungMay != null) {
			sessionFactory.getCurrentSession().delete(suDungMay);
		}
	}
}
