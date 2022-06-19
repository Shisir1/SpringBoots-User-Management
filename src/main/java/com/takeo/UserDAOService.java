package com.takeo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
	
	public static int usersCount = 5;
	
	private static List<User> users = new ArrayList<>();
	
	static
	{
		users.add(new User(1,"rani",new Date()));
		users.add(new User(2,"rani",new Date()));
		users.add(new User(3,"rani",new Date()));
		users.add(new User(4,"rani",new Date()));
		users.add(new User(5,"rani",new Date()));
	
	}
	
	//static block only execute once in entire application
	//method that retrieve all users from the list
	
	public List<User>findAll()

	{
		return users;
	}
	
	//method to add the user in the list
	public User save(User user)
	{
		user.setId(++usersCount);
		users.add(user);
		
		return user;
	}
	
	//method that find a particular user from the list
	public User findOne(int id)
	{
		for(User user: users)
		{
			System.out.println(user.getId());
			if(user.getId() == id)
				return user;
		}
		return null;
	}
	
	public User deleteById(int id)
	{
		for(User user: users)
		{
			if(user.getId() == id)
			{
				users.remove(user);
				return user;
			}
		}
		return null;
	}
}
