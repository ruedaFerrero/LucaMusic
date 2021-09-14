package com.lucamusic.user.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.lucamusic.user.entity.User;

public interface UserService {

	public void save(User user);
	
	public List<User> getAllUsers();
	
	public User findByID(Long id);
	
	public void DeleteUser(Long id);
}
