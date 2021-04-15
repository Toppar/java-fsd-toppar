package com.example.SportyShoes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SportyShoes.entities.User;
import com.example.SportyShoes.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> GetAllUsers() {
		return userRepository.findAll();
	}

	public User GetUserByName(String name) {
		User user = userRepository.findByName(name);
		if (user == null) {
			throw new RuntimeException("User Not Found!");
		}
		return user;
	}

	public boolean ConfirmUserPassword(User user, String password) {
		return (user.getPassword().equals(password));
	}
}
