package com.example.SportyShoes.repositories;


import org.springframework.data.repository.CrudRepository;
import com.example.SportyShoes.entities.Product;


public interface ProductRepository extends CrudRepository<Product, Integer> {

}