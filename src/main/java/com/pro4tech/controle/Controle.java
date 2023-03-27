package com.pro4tech.controle;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.pro4tech.modelo.Funcionario;
import com.pro4tech.repositorio.RepositorioFuncionario;

import io.micrometer.common.lang.NonNull;

// import Servico.CookieService;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

@RestController
public class Controle {

    @Autowired
    private RepositorioFuncionario rep;

    @PostMapping("/login")
    public ResponseEntity<?> logar(@RequestBody Map<String, Object> json) {
        String email = (String) json.get("email");
        String senha = (String) json.get("senha");
        var funcionarioo = rep.findByEmailAndSenha(email, senha);
        if (funcionarioo.isPresent()) {
            return new ResponseEntity<>(funcionarioo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
