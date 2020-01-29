package com.uxpsystems.assignment.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uxpsystems.assignment.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(User user) {
		session.getCurrentSession().save(user);
	}

	@Override
	public void edit(User user) {
		session.getCurrentSession().update(user);
	}

	@Override
	public void delete(int id) {		
		session.getCurrentSession().delete(getUser(id));
	}

	@Override
	public User getUser(int id) {
		return (User)session.getCurrentSession().get(User.class, id);
	}

	@Override
	public List getAllUser() {
		return session.getCurrentSession().createQuery("from User").list();
	}

}
