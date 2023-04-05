package com.pro4tech.controle;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro4tech.modelo.Funcionario;
import com.pro4tech.repositorio.RepositorioFuncionario;
import java.util.List;
import java.util.Optional;

@RestController
public class Controle {


    private final PasswordEncoder encoder;

    public Controle(PasswordEncoder encoder) {
        this.encoder = encoder;
    }
    @Autowired
    private RepositorioFuncionario rep;
  

    @PostMapping("/login")
    public ResponseEntity<?> logar(@RequestBody Map<String, Object> json) {
                
            String email = (String) json.get("email");
            String senha = (String) json.get("senha");
            
            // Optional<Funcio> = rep.findByEmail(email);
            Optional<Funcionario> funcionarioo = rep.findByEmail(email);
            if (funcionarioo.isPresent()) {               
            Boolean valid = false;
                Funcionario Corpofuncionario = funcionarioo.get();

                valid = encoder.matches(senha, Corpofuncionario.getSenha());
                if (valid) {
                return new ResponseEntity<>(Corpofuncionario.getCpf() , HttpStatus.OK);
                } else {
                return new ResponseEntity<>("Funcionario Com login ou senha errados" , HttpStatus.NON_AUTHORITATIVE_INFORMATION);
                }
    }
  return new ResponseEntity<>("Funcionario Não Encontrado", HttpStatus.NON_AUTHORITATIVE_INFORMATION);

}

}

