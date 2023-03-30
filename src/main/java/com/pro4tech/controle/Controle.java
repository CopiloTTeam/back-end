package com.pro4tech.controle;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro4tech.repositorio.RepositorioFuncionario;

@RestController
public class Controle {

    @Autowired
    private RepositorioFuncionario rep;

    @PostMapping("/login")
    public ResponseEntity<?> logar(@RequestBody Map<String, Object> json) {
        try {
            String email = (String) json.get("email");
            String senha = (String) json.get("senha");
            var funcionarioo = rep.findByEmailAndSenha(email, senha);
            if (funcionarioo.isPresent()) {
                return new ResponseEntity<>(funcionarioo.get().getId_funcionario(), HttpStatus.OK);
            } else {
            return new ResponseEntity<>("Funcionario não cadastrado", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao fazer login", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
