package com.przepisy.przepisy.auth.service;

import java.util.Set;

import com.przepisy.przepisy.auth.model.Comment;
import com.przepisy.przepisy.auth.model.Recipe;

public interface CommentService {

    Comment save(Comment comment, Recipe recipe);
    Set<Comment> getCommentByRecipeId(Long id);
    void deleteById(Long id);
}