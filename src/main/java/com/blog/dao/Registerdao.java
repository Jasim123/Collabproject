package com.blog.dao;

import java.util.List;

import com.blog.model.Registration;



public interface Registerdao {
	public void addUser(Registration user);
	public void updateUser(Registration user);
	public void deleteUser(Registration user);
	public Registration getUserByUsername(String username);
	public List<Registration> listUsers();
	

}
