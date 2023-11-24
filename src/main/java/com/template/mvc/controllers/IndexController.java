package com.template.mvc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;


@Controller
public class IndexController{
    //login
     @GetMapping("/")
     public String login(){
        return "login";

     }




}
