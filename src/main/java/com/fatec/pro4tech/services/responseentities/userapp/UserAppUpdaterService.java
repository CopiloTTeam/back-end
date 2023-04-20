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
			Funcionario target = currentUser.orElse(null);
			target.setNome(updateUser.getNome());
			target.getCredential().setUserName(updateUser.getCredential().getUserName());
			target.getCredential().setPassword(updateUser.getCredential().getPassword());
			target.getCredential().setRoles(updateUser.getCredential().getRoles());
			repository.save(updateUser);
			return new ResponseEntity<>(target, HttpStatus.ACCEPTED);
		} catch (InvalidDataAccessApiUsageException e) {
			MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
			header.add(e.getCause().getMessage(), e.getLocalizedMessage());
			return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
		}
	}
}
