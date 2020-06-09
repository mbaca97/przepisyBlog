package com.przepisy.przepisy.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.przepisy.przepisy.auth.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{

}
