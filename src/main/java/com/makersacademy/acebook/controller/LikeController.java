package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Like;
import com.makersacademy.acebook.model.User;
import com.makersacademy.acebook.repository.LikeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LikeController {
  @Autowired
    LikeRepository likeRepository;

  // @GetMapping("/like")
  // public RedirectView index() {
	// 	return new RedirectView("/posts");
  // }

  // @PostMapping("/posts/{id}/likes")
  //   public RedirectView like(@PathVariable("id") Long id) {System.out.println("******* Liking a post");
    
  //   return new RedirectView("/posts");
  // }
  @PostMapping("/posts/{id{/likes")
    public RedirectView create(@ModelAttribute Like like, @RequestParam(value = "post_id") Long postId,
  @RequestParam(value = "user_id") Long userId) {
    like.addLike(userId,postId);

    


    

    return new RedirectView("/posts");
  }
 
}

