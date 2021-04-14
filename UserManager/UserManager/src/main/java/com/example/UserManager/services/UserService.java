package com.example.UserManager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.UserManager.entities.User;
import com.example.UserManager.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> GetAllUsers() {
		return userRepository.findAll();
	}

	public User GetUserById(int id) {

		// TODO: Handle non-existent user. Currently throws an exception
		Optional<User> user = userRepository.findById(id);
		return user.get();

	}

	public User EditUser(User user) {

		// TODO: Not doing any error checking

		return userRepository.save(user);
	}
}