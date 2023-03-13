package com.pro4tech.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controle {

    @GetMapping("/")
    public String index(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/cadastro")
    public String cadastrar(){
        return "cadastro";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

}
