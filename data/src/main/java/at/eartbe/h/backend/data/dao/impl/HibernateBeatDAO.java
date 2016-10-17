/**
 * 
 */
package at.eartbe.h.backend.data.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import at.eartbe.h.backend.data.HibernateSession;
import at.eartbe.h.backend.data.dao.BeatDAO;
import at.eartbe.h.backend.data.model.Beat;
import at.eartbe.h.backend.data.model.User;

/**
 * @author User
 *
 */
public class HibernateBeatDAO implements BeatDAO {

	public Beat selectById(Long id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Beat beat = (Beat) session.get(Beat.class, id);
		session.close();
		return beat;
	}

	public List<Beat> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Beat> beat = session.createCriteria(Beat.class).list();
		session.close();
		return beat;
	}

	public void insert(Beat beat) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(beat);
		beat.setId(id);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Beat beat) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(beat);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Beat beat) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(beat);
		session.getTransaction().commit();
		session.close();
	}

}
