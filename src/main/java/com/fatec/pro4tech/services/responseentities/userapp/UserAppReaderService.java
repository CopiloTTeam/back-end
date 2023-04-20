package com.fatec.pro4tech.services.responseentities.userapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.pro4tech.entities.Funcionario;
import com.fatec.pro4tech.repository.RepositorioFuncionario;

@Service
public class UserAppReaderService {
    @Autowired
	private RepositorioFuncionario repository;

	public ResponseEntity<Funcionario> getUser(String cpf) {
		Optional<Funcionario> currentUser = repository.findByCpf(cpf);
		Funcionario user = currentUser.orElse(null);
		if (user == null) {
			return new ResponseEntity<Funcionario>(user, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Funcionario>(user, HttpStatus.FOUND);
		}
	}

	public ResponseEntity<List<Funcionario>> getUsers() {
		List<Funcionario> users = repository.findAll();
		List<Funcionario> rootUsers = new ArrayList<>();
		for (Funcionario user : users) {
			if (user.getCredential() != null) {
				rootUsers.add(user);
			}
		}
		users.removeAll(rootUsers);
		return new ResponseEntity<List<Funcionario>>(users, HttpStatus.FOUND);
	}

	public ResponseEntity<List<Funcionario>> getRootUsers() {
		List<Funcionario> users = repository.findAll();
		List<Funcionario> rootUsers = new ArrayList<>();
		for (Funcionario user : users) {
			if (user.getCredential() != null) {
				rootUsers.add(user);
			}
		}
		return new ResponseEntity<List<Funcionario>>(rootUsers, HttpStatus.FOUND);
	}
}
