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
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;


/**
 * Nombre de la clase: UserControl

 * Esta clase se encarga de poner en uso los eventos de UserRepository

 * @author:Emanuel

 * @version: 14/09/2021/v1


 */


@RestController
@RequestMapping("/users")
public class UserControl {

	private static final Logger log = LoggerFactory.getLogger(UserControl.class);

	@Autowired 
	private UserServiceImpl userServ;
        
        /**
	 * Metodo para recuperar un listado completo de los usuarios
	 * @return List<User>
	 * @author George
	 */
	@GetMapping
	public ResponseEntity<List<User>> usersByStatus(){
                String status = "CREATED";
                List<User> users = userServ.usersByStatus(status);
		if(users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(users);
	}


	@PostMapping("/add")
	public ResponseEntity<User> createUser(@Valid @RequestBody  User user, BindingResult result){
		log.info("-------Usuario creado "+user);
		User usuario = userServ.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);

	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
		log.info("Fetching User with id {}", id);
		User user = userServ.findByID(id);
		if(user == null){
			log.error("#########sUser with id {} not found", id);
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
        }
                
        /**
	 * Metodo para modificar un usuario
	 * @param user User
	 * @return ResponseEntity 200, OK
	 * @author George*/
	@PutMapping("/{id}")
	public ResponseEntity<User> modifyUser(@PathVariable("id") Long id, @RequestBody User user){
		log.info("Updating User with id {}", id);
		User userUpdated = userServ.findByID(id);
		if(userUpdated == null){
			log.error("Unable to update. No USer with id {}", id);
			return ResponseEntity.notFound().build();
		}
                user.setId(id);
                userUpdated = userServ.modifyUser(user);
		return ResponseEntity.ok(userUpdated);
	}
        
        /**
	 * Metodo para eliminar un evento
	 * @param user User
	 * @return ResponseEntity 200, OK
	 * @author George*/
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
		log.info("Fetching and deleting User with id {}", id);
		User userDeleted = userServ.findByID(id);
		if(userDeleted == null){
			log.error("Unable to delete. No User with id {}", id);
			return ResponseEntity.notFound().build();
		}
		userServ.deleteUser(userDeleted);
		return ResponseEntity.ok(userDeleted);
	}




}
