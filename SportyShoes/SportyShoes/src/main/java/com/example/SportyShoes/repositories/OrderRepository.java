package com.example.SportyShoes.repositories;


import org.springframework.data.repository.CrudRepository;
import com.example.SportyShoes.entities.Order;
import com.example.SportyShoes.entities.Product;



public interface OrderRepository extends CrudRepository<Product, Integer>{

}