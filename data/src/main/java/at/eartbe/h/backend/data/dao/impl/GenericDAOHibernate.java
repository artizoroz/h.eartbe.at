/**
 * 
 */
package at.eartbe.h.backend.data.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import at.eartbe.h.backend.data.HibernateUtil;
import at.eartbe.h.backend.data.dao.GenericDAO;

/**
 * @author User
 *
 */
public class GenericDAOHibernate<T> implements GenericDAO<T> {
	
	private Session session;
	
	protected void start() {
		session = HibernateUtil.getSession();
		session.getTransaction().begin();
	}
	
	protected void end() {
		session.getTransaction().commit();
		session.close();
	}
	
	protected void handleException(HibernateException he)
			throws HibernateException {
		System.out.println("Exception: " + he.getMessage());
		session.getTransaction().rollback();
		throw he;
	}
	
	protected Session getSession() {
		return session;
	}

	

	public List<T> selectAll(Class entityClass) throws HibernateException {
		List<T> result = null;
		try {
			start();
			System.out.println("get data ");
			result = getSession().createQuery(
					"From " + entityClass.getSimpleName()).list();

		} catch (HibernateException he) {
			handleException(he);
		} finally {
			end();
		}
		return result;
	}

	public void insert(T entity) throws HibernateException {
		try {
			start();
			getSession().save(entity);
		} catch (HibernateException he) {
			handleException(he);
		} finally {
			end();
		}
	}

	public void update(T entity) throws HibernateException {
		try {
			start();
			getSession().save(entity);
			//getSession().saveOrUpdate(entity);
			//getSession().flush();
		} catch (HibernateException he) {
			handleException(he);
		} finally {
			end();
		}
		
	}

	public void delete(T entity) throws HibernateException {
		try {
			start();
			getSession().delete(entity);
			getSession().flush();
		} catch (HibernateException he) {
			handleException(he);
		} finally {
			end();
		}
	}

	public T selectById(Serializable id, Class<T> entityClass) throws HibernateException {
			T obj = null;
			try {
				start();
				obj = (T) getSession().get(entityClass, id);
			} catch (HibernateException he) {
				handleException(he);
			} finally {
				end();
			}
			return obj;
	}

}
