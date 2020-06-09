package com.przepisy.przepisy.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.przepisy.przepisy.auth.model.Comment;
import com.przepisy.przepisy.auth.service.CommentService;

import java.security.Principal;
import java.util.Optional;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	
	
//    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
//    public String createNewPost(Comment comment,
//                                BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return "/commentForm";
//
//        } else {
//        	commentService.save(comment);
//            return "redirect:/recipies/" + comment.getRecipe().getId();
//        }
//    }

//    @RequestMapping(value = "/commentPost/{id}", method = RequestMethod.GET)
//    public String commentPostWithId(@PathVariable Long id,
//                                    Principal principal,
//                                    Model model) {
//
//
//        if (post.isPresent()) {
//
//            if (user.isPresent()) {
//                Comment comment = new Comment();
//                comment.setUser(user.get());
//                comment.setPost(post.get());
//
//                model.addAttribute("comment", comment);
//
//                return "/commentForm";
//
//            } else {
//                return "/error";
//            }
//
//        } else {
//            return "/error";
//        }
//    }

}