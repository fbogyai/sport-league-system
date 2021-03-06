package cz.muni.fi.pv243.sportleaguesystem.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.Clustered;

import cz.muni.fi.pv243.sportleaguesystem.dao.interfaces.UserDAO;
import cz.muni.fi.pv243.sportleaguesystem.entities.User;

@Clustered
@Stateless
public class UsersDAOImpl implements UserDAO{

	@Inject
	private EntityManager em;
	
	@Override
	public void create(User user) {
		em.persist(user);
		
	}

	@Override
	public User get(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public void update(User user) {
		em.merge(user);
		
	}

	@Override
	public void delete(User user) {
		em.remove(em.merge(user));		
	}

	@Override
	public List<User> findAll() {
		return (List<User>) em.createQuery("SELECT u FROM User u").getResultList();		
	}

	@Override
	public List<User> findUsersByName(String name) {
		name = name.replaceAll(" ", "");
		Query query = em.createQuery("SELECT u FROM User u WHERE UPPER(CONCAT(u.firstName,u.lastName,u.firstName)) LIKE UPPER(:name)");
		query.setParameter("name", "%" + name + "%");
		return (List<User>) query.getResultList();
	}

}
