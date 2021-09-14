package com.lucamusic.user.service;

import java.util.List;

import com.lucamusic.user.entity.User;

public interface UserService {

	public void save(User user);
	
	public List<User> getAllUsers();
	
	public void findByID(Long id);
	
	public void DeleteUser(Long id);
}
