package com.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.SuDungDichVu;
import com.model.SuDungDichVuID;

@Repository
public class SuDungDichVuDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void addSuDungDichVu(SuDungDichVu suDungDichVu) {
		sessionFactory.getCurrentSession().save(suDungDichVu);
	}

	@Transactional
	public void updateSuDungDichVu(SuDungDichVu suDungDichVu) {
		sessionFactory.getCurrentSession().update(suDungDichVu);
	}

	@Transactional
	public List<SuDungDichVu> getAllSuDungDichVu() {
		return sessionFactory.getCurrentSession().createQuery("from SuDungDichVu", SuDungDichVu.class).getResultList();
	}

	@Transactional
	public SuDungDichVu getSuDungDichVuByMaSuDungDichVu(SuDungDichVuID  id) {
		return sessionFactory.getCurrentSession().get(SuDungDichVu.class, id);
	}

	@Transactional
	public void deleteSuDungDichVu(SuDungDichVuID id) {
		SuDungDichVu suDungDichVu = getSuDungDichVuByMaSuDungDichVu(id);
		if (suDungDichVu != null) {
			sessionFactory.getCurrentSession().delete(suDungDichVu);
		}
	}
}
