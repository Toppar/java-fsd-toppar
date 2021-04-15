package com.example.SportyShoes.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.SportyShoes.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public User findByName(String Name);
}