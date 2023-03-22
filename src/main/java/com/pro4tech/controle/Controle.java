package com.pro4tech.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pro4tech.modelo.Funcionario;
import com.pro4tech.repositorio.RepositorioFuncionario;

// import Servico.CookieService;
// import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Controller
public class Controle {

    @Autowired
    private RepositorioFuncionario rep;

    @PostMapping("/logar")
    public String logar(@ModelAttribute Funcionario funcionario , HttpServletResponse response){
        String email = funcionario.getEmail();
        String senha = funcionario.getSenha();
        Funcionario funcionarioLogado = rep.findByEmailAndSenha(email, senha);
        return funcionarioLogado.getCpf();
    }
} //return de um token para o front que vai ser usado para usar todas as outras rotas


// }
