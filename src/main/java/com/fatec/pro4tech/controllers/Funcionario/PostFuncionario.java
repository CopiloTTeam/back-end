package com.fatec.pro4tech.controllers.Funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.pro4tech.entities.Funcionario;
import com.fatec.pro4tech.services.responseentities.userapp.UserAppWriterService;

import jakarta.annotation.security.PermitAll;

@CrossOrigin
@RestController
public class PostFuncionario {
    @Autowired
	private UserAppWriterService userWriter;

	@PostMapping("/user/save")
	@PermitAll
	public ResponseEntity<?> saveUser(@RequestBody Funcionario user) {
		System.out.println(user);
		return userWriter.save(user);
	}
}
