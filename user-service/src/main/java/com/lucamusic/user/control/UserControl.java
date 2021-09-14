package com.lucamusic.user.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucamusic.user.entity.User;
import com.lucamusic.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserControl {

	@Autowired 
	private UserService userServ;


	@GetMapping("/add")
	public void newUser(User user, Model model) {
		model.addAttribute("user", user);

	}


}
