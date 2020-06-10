package com.przepisy.przepisy.auth.web;

import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.przepisy.przepisy.auth.model.Comment;
import com.przepisy.przepisy.auth.model.Recipe;
import com.przepisy.przepisy.auth.service.CommentService;
import com.przepisy.przepisy.auth.service.RecipeService;
import com.przepisy.przepisy.auth.service.SecurityService;
import com.przepisy.przepisy.auth.service.UserService;
import com.przepisy.przepisy.auth.validator.UserValidator;

@Controller
public class RecipiesController {
	
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private RecipeService recipeService;
    
    @Autowired
    private CommentService commentService;
    
    
    @GetMapping("/recipies")
    public String recipies(Model model) {
        model.addAttribute("recipeForm", new Recipe());
    	model.addAttribute("recipeList", recipeService.getRecipies());
        return "recipies";
    }
    @PostMapping("/recipies")
    public String addRecipies(@RequestParam("photo") MultipartFile coto, 
    		@RequestParam("description") String description, 
    		@RequestParam("foodKind") String foodKind,
    		@RequestParam("lvl") String lvl,
    		@RequestParam("time") String time
    		)throws IOException, SerialException, SQLException {
    	byte[] photoBytes = coto.getBytes();
    	Blob blob = new javax.sql.rowset.serial.SerialBlob(photoBytes);
    	Recipe recipe = new Recipe();
    	recipe.setDescription(description);
    	recipe.setFoodKind(foodKind);
    	recipe.setLvl(lvl);
    	recipe.setTime(time);
    	recipe.setPhoto(blob);
        recipeService.save(recipe);

        return "redirect:/recipies";
    }
    
    @RequestMapping(value = "/recipe/{id}", method = RequestMethod.GET)
    public String getPostWithId(@PathVariable Long id,  Model model) {
    	model.addAttribute("recipeById", recipeService.getRecipeById(id).iterator().next());
    	model.addAttribute("commentToRecipe", commentService.getCommentByRecipeId(id));
    	return "recipe";
    	
    }
    
    @RequestMapping(value = "/recipe/{id}", method = RequestMethod.POST)
    public String addPost(@PathVariable Long id,  Model model, @ModelAttribute("commentForm") Comment commentForm) {
    	commentService.save(commentForm, recipeService.getRecipeById(id).iterator().next());
    	return "redirect:/recipe/"+id;
    	
    }
    
    @RequestMapping(value = "/recipe_filter", method = RequestMethod.GET)
    public String getFiltered( Model model) {
    	return "recipefilter";
    }
    
    @RequestMapping(value = "/recipe_filter", method = RequestMethod.POST)
    public String filterRecipies(Model model, @ModelAttribute("recipeFilterForm") Recipe recipe) {
    	Set<Recipe> recipiesUserUN = recipeService.getRecipiesByUserUsername(recipe.getTime());
    	Set<Recipe> recipiesFK = recipeService.getRecipiesByFoodKind(recipe.getFoodKind());
    	Set<Recipe> recipiesLvl = recipeService.getRecipiesByLvl(recipe.getLvl());
    	recipiesFK.retainAll(recipiesLvl);
    	recipiesFK.retainAll(recipiesUserUN);
    	model.addAttribute("recipeList", recipiesFK);
    	return "recipefilter";
    	
    }
    
	@RequestMapping(value = "/getRecipePhoto/{id}")
	public void getRecipePhoto(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		try {
			response.setContentType("image/jpeg");
			Blob ph = recipeService.getOneRecipeById(id).getPhoto();
			byte[] bytes =  ph.getBytes(1, (int) ph.length());
			InputStream inputStream = new ByteArrayInputStream(bytes);
			IOUtils.copy(inputStream, response.getOutputStream());
		}catch(Exception e) {
			
		}
	}
	
	
}
