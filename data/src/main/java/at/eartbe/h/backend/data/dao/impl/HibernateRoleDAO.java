/**
 * 
 */
package at.eartbe.h.backend.data.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import at.eartbe.h.backend.data.HibernateSession;
import at.eartbe.h.backend.data.dao.RoleDAO;
import at.eartbe.h.backend.data.model.Role;

import at.eartbe.h.backend.data.model.Role;

/**
 * @author egoitz
 *
 */
public class HibernateRoleDAO implements RoleDAO{
	/*
	 * selects one role by Id
	 * 
	 * @param id
	 * 
	 * @return Role
	 */
	public Role selectById(Long id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Role role = (Role) session.get(Role.class, id);
		session.close();
		return role;
	}

	/*
	 * retrieves all roles from db
	 * 
	 * @return List of roles
	 */
	public List<Role> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Role> Roles = session.createCriteria(Role.class).list();
		session.close();
		return Roles;
	}

	/*
	 * inserts a new role in database retrieves generated id and sets to
	 * role instance
	 * 
	 * @param new role
	 */
	public void insert(Role role) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(role);
		role.setId(id);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * updates role
	 * 
	 * @param role to update
	 */
	public void update(Role role) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(role);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * delete given role
	 * 
	 * @param role to delete
	 */
	public void delete(Role role) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(role);
		session.getTransaction().commit();
		session.close();
	}
}
