package com.fatec.pro4tech.services.responseentities.parcelaapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.pro4tech.entities.Parcela;
import com.fatec.pro4tech.repository.RepositorioParcela;

@Service
public class ParcelaAppReaderService {
    @Autowired
	private RepositorioParcela repository;

	// public ResponseEntity<Parcela> getUser(String id_parcela) {
	// 	Optional<Parcela> currentUser = repository.findById(id_parcela);
	// 	Parcela user = currentUser.orElse(null);
	// 	if (user == null) {
	// 		return new ResponseEntity<Parcela>(user, HttpStatus.NOT_FOUND);
	// 	} else {
	// 		return new ResponseEntity<Parcela>(user, HttpStatus.FOUND);
	// 	}
	// }

	public ResponseEntity<List<Parcela>> getUsers() {
		List<Parcela> users = repository.findAll();
		List<Parcela> rootUsers = new ArrayList<>();
		// for (Parcela user : users) {
		// 	if (user.getCredential() != null) {
		// 		rootUsers.add(user);
		// 	}
		// }
		users.removeAll(rootUsers);
		return new ResponseEntity<List<Parcela>>(users, HttpStatus.FOUND);
	}

	public ResponseEntity<List<Parcela>> getRootUsers() {
		List<Parcela> users = repository.findAll();
		List<Parcela> rootUsers = new ArrayList<>();
		// for (Parcela user : users) {
		// 	if (user.getCredential() != null) {
		// 		rootUsers.add(user);
		// 	}
		// }
		return new ResponseEntity<List<Parcela>>(rootUsers, HttpStatus.FOUND);
	}


	public ResponseEntity<List<Parcela>> getAllUsers(){
		List<Parcela> users = repository.findAll();
		return new ResponseEntity<List<Parcela>> (users, HttpStatus.FOUND);
	}
}
