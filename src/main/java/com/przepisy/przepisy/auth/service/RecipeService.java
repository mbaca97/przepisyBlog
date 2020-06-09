package com.przepisy.przepisy.auth.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.przepisy.przepisy.auth.model.Recipe;
import com.przepisy.przepisy.auth.model.User;

public interface RecipeService {
	String userRecipies(User user);
//	UserDetails userName();
	User getUser();
	Set<Recipe> getRecipies();
	void save(Recipe recipe);
	List<Recipe> getAllRecipies();
	Set<Recipe> getRecipeById(Long id);
	Set<Recipe> getRecipiesByUserUsername(String username);
	Set<Recipe> getRecipiesByLvl(String lvl);
	Set<Recipe> getRecipiesByFoodKind(String foodKind);
	void deleteById(Long id);
	Recipe getOneRecipeById(Long id);
}
