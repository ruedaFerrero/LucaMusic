package com.lucamusic.user.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucamusic.user.entity.User;
import com.lucamusic.user.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserControl {

	@Autowired 
	private UserServiceImpl userServ;


	@PostMapping("/add")
	public ResponseEntity<User> createUser( User user){
		User usuario = userServ.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);

	}


	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id){
		return userServ.findByID(id);
	}

}
