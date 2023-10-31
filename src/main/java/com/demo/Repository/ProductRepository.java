package com.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}