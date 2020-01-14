package com.softuni.exodia.web.controllers;

import com.softuni.exodia.domain.models.binding.UserLoginBindingModel;
import com.softuni.exodia.domain.models.binding.UserRegisterBindingModel;
import com.softuni.exodia.domain.models.service.UserServiceModel;
import com.softuni.exodia.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView, HttpSession session){
        if (session.getAttribute("username") != null){
            modelAndView.setViewName("redirect:/home");
        }else {
            modelAndView.setViewName("register");
        }

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@ModelAttribute UserRegisterBindingModel model,
                                        ModelAndView modelAndView){
        if (!model.getPassword().equals(model.getConfirmPassword())){
            throw new IllegalArgumentException("Passwords don't match!");
        }

        UserServiceModel serviceModel = this.modelMapper.map(model, UserServiceModel.class);
        if (!this.userService.registerUser(serviceModel)){
            throw new IllegalArgumentException("UserRegistration failed!");
        }

        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, HttpSession session){
        if (session.getAttribute("username") != null){
            modelAndView.setViewName("redirect:/home");
        }else {
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginConfirm(@ModelAttribute UserLoginBindingModel userLoginBindingModel,
                                     ModelAndView modelAndView, HttpSession session){
        UserServiceModel model = this.modelMapper.map(userLoginBindingModel, UserServiceModel.class);
        UserServiceModel userServiceModel = this.userService.loginUser(model);

        if (userServiceModel == null){
            throw new IllegalArgumentException("User login failed!");
        }
        session.setAttribute("userId", model.getId());
        session.setAttribute("username", model.getUsername());

        modelAndView.setViewName("redirect:/home");

        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView modelAndView, HttpSession session){
        if (session.getAttribute("username") != null){
            session.invalidate();
            modelAndView.setViewName("redirect:/");
        }else {
            modelAndView.setViewName("redirect:/login");
        }

        return modelAndView;
    }
}
