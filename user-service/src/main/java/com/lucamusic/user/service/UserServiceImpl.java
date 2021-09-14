package com.lucamusic.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucamusic.user.entity.User;
import com.lucamusic.user.repository.UserRepository;

/**
* Nombre de la clase: UserServiceImpl

 * Esta clase es la encargada de ejecutar los metodos del UserService

 * @author:Emanuel

 * @version: 14/09/2021/v1

 
 */


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	public User createUser(User user) {
		Optional<User> userDB = userRepo.findById(user.getId());


		if(userDB.isPresent()) {
			 return userDB.get();
		}

		return userRepo.save(user);

	}




	@Override
	public void save(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByID(Long id) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public void DeleteUser(Long id) {
		// TODO Auto-generated method stub

	}


}
