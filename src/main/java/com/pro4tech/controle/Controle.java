package com.pro4tech.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pro4tech.modelo.Funcionario;
import com.pro4tech.repositorio.RepositorioFuncionario;

import Servico.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Controller
public class Controle {

    @Autowired
    private RepositorioFuncionario rep;

    @GetMapping("/")
    public String index(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/logar")
    public String logar(@ModelAttribute Funcionario funcionario , HttpServletResponse response){
        String email = funcionario.getEmail();
        String senha = funcionario.getSenha();
        Funcionario funcionarioLogado = rep.findByEmailAndSenha(email, senha);

        if(funcionarioLogado != null){
            CookieService.setCookie(response," 123", funcionarioLogado.getId().toString(),10);
            return "redirect:/home";
        }
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home(HttpServletRequest request){
        // if( CookieService.getCookie(request, null) == null){
        //     return "redirect:/login";
        // }else{
        //     return "home";
        System.out.println(CookieService.getCookie(request, null));
        // }
        return "home";
    }

}
