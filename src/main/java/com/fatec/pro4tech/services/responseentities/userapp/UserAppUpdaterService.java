package com.fatec.pro4tech.services.responseentities.userapp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fatec.pro4tech.entities.Funcionario;
import com.fatec.pro4tech.repository.RepositorioFuncionario;

@Service
public class UserAppUpdaterService {
	@Autowired
	private RepositorioFuncionario repository;

	public ResponseEntity<Funcionario> update(Funcionario updateUser) {
		try {
			Optional<Funcionario> currentUser = repository.findByCpf(updateUser.getCpf());
			// de um log no console para ver se o usuario esta sendo encontrado
			// System.out.println("Found user1232131: " + currentUser.getNome);
			 
			Funcionario target = currentUser.orElse(null);
			System.out.println(target.getNome()); 

			// if (target.getNome() != updateUser.getNome()) {
			target.setNome(updateUser.getNome());
			// }
			// if (target.getEmail() != updateUser.getEmail()) {
			target.setEmail(updateUser.getEmail());
			// }
			// if (target.getCredential() != updateUser.getCredential()) {
			// 	if (target.getCredential().getUserName() != updateUser.getCredential().getUserName()) {
			// 		target.getCredential().setUserName(updateUser.getCredential().getUserName());
			// 	}
			// 	if (target.getCredential().getPassword() != updateUser.getCredential().getPassword()) {
			// 		target.getCredential().setPassword(updateUser.getCredential().getPassword());
			// 	}
			// 	if (target.getCredential().getRole() != updateUser.getCredential().getRole()) {
			// 		target.getCredential().setRole(updateUser.getCredential().getRole());
			// 	}
			// 	target.setRegistration(new Date(System.currentTimeMillis()));
			// }
			repository.save(updateUser);
			return new ResponseEntity<>(target, HttpStatus.ACCEPTED);
		} catch (InvalidDataAccessApiUsageException e) {
			MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
			header.add(e.getCause().getMessage(), e.getLocalizedMessage());
			return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
		}
	}
}
