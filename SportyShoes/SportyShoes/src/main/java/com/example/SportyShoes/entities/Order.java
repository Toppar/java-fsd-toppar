package com.example.SportyShoes.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
@Table(name="orders")
public class Order {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User user;
	

    @ManyToMany(
      targetEntity = Product.class,
      cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "order_line",
      joinColumns = @JoinColumn(name = "order_id", nullable = false, updatable = false),
      inverseJoinColumns = @JoinColumn(name = "product_id", nullable = false, updatable = false))

    public Set<Product> products= new HashSet(0);

}