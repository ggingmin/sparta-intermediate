package com.sparta.securityex.controller;

import com.sparta.securityex.domain.UserRoleEnum;
import com.sparta.securityex.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        try {
            model.addAttribute("username", userDetails.getUsername());
        } catch (NullPointerException e) {
            return "redirect:/user/login";
        }

        if (userDetails.getUser().getRole() == UserRoleEnum.ADMIN) {
            model.addAttribute("admin_role", true);
        }

        return "index";
    }
}