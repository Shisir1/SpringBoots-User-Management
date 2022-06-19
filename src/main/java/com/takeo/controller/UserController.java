package com.takeo.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import com.takeo.User;
import com.takeo.UserDAOService;
import com.takeo.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
	
	//to access the Service method we need  to used Autowired
	@Autowired
	private UserDAOService daoService;
	
	@GetMapping("/users")
	public List<User> retriveAllUsers()
	{
		return daoService.findAll();
	}
	
	@PostMapping("/users")
	public void createUser(@RequestBody User user)
	{
		User savedused = daoService.save(user);
		System.out.println(savedused);
	}

	//retrieve a specific User details
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id)
	{
		User user = daoService.findOne(id);
		
		if(user ==null)
		{
			throw new UserNotFoundException("Id: " + id);
		}
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		User user = daoService.deleteById(id);
		
		if(user == null)
		{
			throw new UserNotFoundException("Id Not Found :" + id);
		}
		
		System.out.println("Given user is deleted: "+user);
	}
}
