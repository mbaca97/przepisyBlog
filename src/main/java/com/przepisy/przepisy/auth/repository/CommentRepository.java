package com.przepisy.przepisy.auth.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.przepisy.przepisy.auth.model.Comment;
import com.przepisy.przepisy.auth.model.Ingredient;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	Set<Comment> findAllByRecipeId(Long id);
	void deleteById(Long id);
}
