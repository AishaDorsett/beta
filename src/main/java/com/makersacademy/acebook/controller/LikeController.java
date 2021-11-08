package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Like;
import com.makersacademy.acebook.repository.LikeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LikeController {
  @Autowired
    LikeRepository likeRepository;

  @GetMapping("/posts")
  public RedirectView index() {
		return new RedirectView("/posts");
  }

    @PostMapping("/posts")
    public RedirectView create(@ModelAttribute Like Like) {
        
        return new RedirectView("/posts");
    }

  


}
}
