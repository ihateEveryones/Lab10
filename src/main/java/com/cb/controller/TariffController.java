package com.cb.controller;


import com.cb.model.Tariff_Name;
import com.cb.model.User;
import com.cb.repository.TariffNameRepository;
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

@RequestMapping("/user")
@Controller
public class TariffController {
    @Autowired
    private TariffNameRepository tariffNameRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/tariff")
    public String userView(Model model,@AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername());
        model.addAttribute("name", user.getName());
        List<Tariff_Name> tariffNames = tariffNameRepository.findAll();
        System.out.println(tariffNames);
        model.addAttribute("tariff", tariffNames);
        return "tariff";

    }
}
