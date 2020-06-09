package com.przepisy.przepisy.auth.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.przepisy.przepisy.auth.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	Recipe getRecipeById(Long id);
	Set<Recipe> findAllByUserId(Long id);
	Set<Recipe> findAllById(Long id);
	Set<Recipe> findAllByUserUsernameContaining(String username);
	Set<Recipe> findAllByLvlContaining(String lvl);
	Set<Recipe> findAllByFoodKindContaining(String foodKind);
	void deleteById(Long id);
}
