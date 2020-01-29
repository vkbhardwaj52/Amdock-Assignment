package com.uxpsystems.assignment.service;

import java.util.List;

import com.uxpsystems.assignment.model.User;

public interface UserService {
	public void add(User user);
	public void edit(User user);
	public void delete(int id);
	public User getUser(int id);
	public List getAllUser();
}
