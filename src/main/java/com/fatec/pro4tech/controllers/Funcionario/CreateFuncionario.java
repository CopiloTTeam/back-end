package com.fatec.pro4tech.controllers.Funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.pro4tech.entities.Funcionario;
import com.fatec.pro4tech.security.roles.roles;
// import com.fatec.pro4tech.entities.titulos;
import com.fatec.pro4tech.services.responseentities.userapp.UserAppWriterService;

import jakarta.annotation.security.PermitAll;

@CrossOrigin
@RestController
public class CreateFuncionario {
    @Autowired
	private UserAppWriterService userWriter;

	@PostMapping("/funcionarios/cadastrar")
	@PermitAll
	public ResponseEntity<?> saveUser(@RequestBody Funcionario user) {
		user.getCredential().setRole(roles.Sem_Cargo);
		return userWriter.save(user);
	}
}
