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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Controller
public class DeleteController {
    @Autowired
    private UserPhoneNumberRepository userPhoneNumberRepository;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam Integer id) {

        Optional<Users_Phone_Number> users_phone_number= userPhoneNumberRepository.findById(id);
        System.out.println(users_phone_number);
        System.out.println("lsal");
        Users_Phone_Number user= users_phone_number.get();
        user.setDelete(true);
        userPhoneNumberRepository.save(user);
        return "redirect:/admin/userAdmin";

    }
}
