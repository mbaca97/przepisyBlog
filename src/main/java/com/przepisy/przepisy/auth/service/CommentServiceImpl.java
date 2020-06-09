package com.przepisy.przepisy.auth.service;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.przepisy.przepisy.auth.model.Comment;
import com.przepisy.przepisy.auth.model.Recipe;
import com.przepisy.przepisy.auth.model.User;
import com.przepisy.przepisy.auth.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private RecipeService recipeService;
    
	@Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment, Recipe recipe) {
    	User user = recipeService.getUser();
    	comment.setUser(user);
    	comment.setRecipe(recipe);
    	int number = this.numberOfCommentsToRecipe(recipe.getId());
    	if (number>=5) {
    		this.deleteById(this.smallestIdForRecipeComment(recipe.getId()));
    	}
        return commentRepository.saveAndFlush(comment);
    }

	@Override
	public Set<Comment> getCommentByRecipeId(Long id) {
		return commentRepository.findAllByRecipeId(id);
	}

	@Override
	public void deleteById(Long id) {
		commentRepository.deleteById(id);
		
	}
	
	//get number of comments to Recipe based on Recipe id
	private int numberOfCommentsToRecipe(Long id)
	{
		return this.getCommentByRecipeId(id).size();
	}
	// return the smallest id of comments based on Recipe id
	private Long smallestIdForRecipeComment(Long id) {
		Set<Comment> comments = this.getCommentByRecipeId(id);
		List<Long> ids = new ArrayList<Long>();
		for(Comment comment :comments) {
			ids.add(comment.getId());
		}
		Collections.sort(ids); 
		return ids.get(0);
	}
}