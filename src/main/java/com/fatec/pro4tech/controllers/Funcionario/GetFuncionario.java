package com.fatec.pro4tech.controllers.Funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.pro4tech.entities.Funcionario;
import com.fatec.pro4tech.services.responseentities.userapp.UserAppReaderService;

@CrossOrigin
@RestController
public class GetFuncionario {
    @Autowired
	private UserAppReaderService userReader;

	@GetMapping("/user/{cpf}")
	@PreAuthorize("hasAnyAuthority('Administrador','Comercial', 'Financeiro')")
	public ResponseEntity<Funcionario> getUser(@PathVariable String cpf) {
		return userReader.getUser(cpf);
	}
}
