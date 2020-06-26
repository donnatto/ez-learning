package com.ezlearning.platform.controller;

import com.ezlearning.platform.dto.UserDto;
import com.ezlearning.platform.services.aws.AmazonS3ClientService;
import com.ezlearning.platform.services.core.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("userdto", new UserDto());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(UserDto userDto, @RequestParam("imgurl") MultipartFile image, Model model) {
        try {
            userService.createUser(userDto, image);
            return "registered";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e);
            return "error";
        }
    }

}
