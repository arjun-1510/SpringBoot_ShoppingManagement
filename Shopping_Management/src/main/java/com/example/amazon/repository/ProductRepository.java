package com.example.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.amazon.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
