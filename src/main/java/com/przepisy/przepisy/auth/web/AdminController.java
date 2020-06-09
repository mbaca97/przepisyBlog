package com.przepisy.przepisy.auth.web;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.przepisy.przepisy.auth.model.Recipe;
import com.przepisy.przepisy.auth.model.User;
import com.przepisy.przepisy.auth.service.RecipeService;
import com.przepisy.przepisy.auth.service.SecurityService;
import com.przepisy.przepisy.auth.service.UserService;
import com.przepisy.przepisy.auth.validator.UserValidator;

@Controller
public class AdminController {
    @Autowired
    
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private RecipeService recipeService;


    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("recipeIdForm", new Recipe());

        return "admin";
    }
    
    @PostMapping("/admin")
    public String adminDelete(@ModelAttribute("recipeIdForm") Recipe recipeToDelete, Model model) {
    	Long id;
    	try {
    		id = Long.parseLong(recipeToDelete.getLvl());
    		recipeService.deleteById(id);
    		model.addAttribute("success", "You successfully deleted recipe with id: "+id);
		}
		catch (Exception e)
		{
			model.addAttribute("success", "Recipe was not deleted");
		}
        
        return "admin";
    }
}
