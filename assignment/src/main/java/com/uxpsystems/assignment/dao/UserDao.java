package com.uxpsystems.assignment.dao;

import java.util.List;

import com.uxpsystems.assignment.model.User;

public interface UserDao {
	public void add(User student);
	public void edit(User student);
	public void delete(int id);
	public User getUser(int id);
	public List getAllUser();
}
