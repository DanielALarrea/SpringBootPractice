package com.example.SpringBootMySQL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringBootMySQL.UserRepository;
import com.example.SpringBootMySQL.model.User;

@Controller
@RequestMapping(path="/demo")
public class MainController {

	@Autowired
	private UserRepository userRepo;
	
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestParam String name,
			@RequestParam String email) {
		
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepo.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepo.findAll();
	}
}
