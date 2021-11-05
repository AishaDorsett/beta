package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Authority;
import com.makersacademy.acebook.model.User;
import com.makersacademy.acebook.repository.AuthoritiesRepository;
import com.makersacademy.acebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.RequestMapping;
import com.makersacademy.acebook.service.IUserService;
@Controller
public class UsersController {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    private IUserService userService;

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @GetMapping("/users/new")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping("/users")
    public RedirectView signup(@ModelAttribute User user) {
        //userRepository.save(user);
        if(userService.save(user)){
            Authority authority = new Authority(user.getUsername(), "ROLE_USER");
            authoritiesRepository.save(authority);
        }
        return new RedirectView("/login.html");


    }

	@RequestMapping("/login.html")
	public String login() {
		return "/users/login.html";
	}

	@RequestMapping("/login-error.html")
	public String loginError(Model model) {
	model.addAttribute("loginError", true);
	return "/users/login.html";
	}
}
