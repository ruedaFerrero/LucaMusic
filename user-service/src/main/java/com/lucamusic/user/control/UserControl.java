package com.lucamusic.user.control;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucamusic.user.entity.User;
import com.lucamusic.user.service.UserServiceImpl;


/**
 * Nombre de la clase: UserControl

 * Esta clase se encarga de poner en uso los eventos de UserRepository

 * @author:Emanuel

 * @version: 14/09/2021/v1


 */


@RestController
@RequestMapping("/user")
public class UserControl {

	private static final Logger log = LoggerFactory.getLogger(UserControl.class);

	@Autowired 
	private UserServiceImpl userServ;


	@PostMapping("/add")
	public ResponseEntity<User> createUser(@Valid @RequestBody  User user, BindingResult result){
		log.info("-------Usuario creado "+user);
		User usuario = userServ.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);

	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getEventById(@PathVariable("id") Long id){
		log.info("Fetching User with id {}", id);
		User user = userServ.findByID(id);
		if(user == null){
			log.error("Event with id {} not found", id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	


}

}
