package com.cb.controller;


import com.cb.model.User;
import com.cb.model.Users_Phone_Number;
import com.cb.repository.UserPhoneNumberRepository;
import com.cb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private UserPhoneNumberRepository userPhoneNumberRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userAdmin")
    public String adminView(Model model,@AuthenticationPrincipal UserDetails userDetails) {
       User user= userRepository.findByEmail(userDetails.getUsername());

        model.addAttribute("name",  user.getName());
        List<Users_Phone_Number> usersPhoneNumbers = userPhoneNumberRepository.findAll();
        System.out.println(usersPhoneNumbers);
        model.addAttribute("users", usersPhoneNumbers);
        return "admin";

    }
}
