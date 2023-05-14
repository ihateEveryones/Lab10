package com.cb.controller;

import com.cb.model.Tariff_Name;
import com.cb.model.User;
import com.cb.model.Users_Phone_Number;
import com.cb.repository.TariffNameRepository;
import com.cb.repository.UserPhoneNumberRepository;
import com.cb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class NewUserController {
    @Autowired
    private UserPhoneNumberRepository userPhoneNumberRepository;
    @Autowired
    private TariffNameRepository tariffNameRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createUser")
    public String createUser(@RequestParam String user_name, @RequestParam String user_phone, @RequestParam Integer id_tariff) {

        // Optional<Users_Phone_Number> users_phone_number= userPhoneNumberRepository.findById(id);
        /*System.out.println(users_phone_number);
        System.out.println(user_name);
        Users_Phone_Number user= users_phone_number.get();
        user.setUser_name(user_name);
        user.setUser_phone(user_phone);
        Optional<Tariff_Name> tariff = tariffNameRepository.findById(id_tariff);
        Tariff_Name tariff_name = new Tariff_Name();  Integer tariffId = tariff.get().getId_tariff();

        tariff_name.setId_tariff(tariffId);
        user.setId_tariff(tariff_name);*/
        Users_Phone_Number user = new Users_Phone_Number();
        user.setUser_name(user_name);
        user.setUser_phone(user_phone);
        Optional<Tariff_Name> tariff = tariffNameRepository.findById(id_tariff);
        Tariff_Name tariff_name = new Tariff_Name();
        Integer tariffId = tariff.get().getId_tariff();

        tariff_name.setId_tariff(tariffId);
        user.setId_tariff(tariff_name);
        user.setDelete(false);
        userPhoneNumberRepository.save(user);
       /* model.addAttribute("name",  user.getName());
        List<Users_Phone_Number> usersPhoneNumbers = userPhoneNumberRepository.findAll();
        System.out.println(usersPhoneNumbers);
        model.addAttribute("users", usersPhoneNumbers);*/
        return "redirect:/createUser";

    }

    @GetMapping("/createUser")
    public String createUserView() {

        return "newUser";

    }
}
