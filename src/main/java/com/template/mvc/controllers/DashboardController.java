package com.template.mvc.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/api/users")
public class DashboardController {
    

    @GetMapping("/dashboard")
    public String home(Model model) {
        return "dashboard";
    }

    
    @GetMapping("/view-user/{_id}")
    public String viewUser(Model model) {
        return "view-user";
    }


    @GetMapping("/edit-user/{_id}")
    public String editUser(Model model) {
        return "edit-user";
    }


}
