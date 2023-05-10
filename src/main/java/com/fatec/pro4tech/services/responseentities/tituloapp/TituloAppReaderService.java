package com.fatec.pro4tech.services.responseentities.tituloapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.pro4tech.entities.Titulo;
import com.fatec.pro4tech.repository.RepositorioTitulo;

@Service
public class TituloAppReaderService {
    @Autowired
	private RepositorioTitulo repository;

	public ResponseEntity<Titulo> getUser(String id) { 
		Optional<Titulo> currentUser = repository.findById(id);
		Titulo user = currentUser.orElse(null);
		if (user == null) {
			return new ResponseEntity<Titulo>(user, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Titulo>(user, HttpStatus.FOUND);
		}
	}

	public ResponseEntity<List<Titulo>> getUsers() {
		List<Titulo> users = repository.findAll();
		List<Titulo> rootUsers = new ArrayList<>();
		// for (Titulo user : users) {
			// if (user.getCredential() != null) {
				// rootUsers.add(user);
			// }
		// }
		users.removeAll(rootUsers);
		return new ResponseEntity<List<Titulo>>(users, HttpStatus.FOUND);
	}

	public ResponseEntity<List<Titulo>> getRootUsers() {
		List<Titulo> rootUsers = new ArrayList<>();
		// for (Titulo user : users) {
			// if (user.getCredential() != null) {
				// rootUsers.add(user);
			// }
		// }
		return new ResponseEntity<List<Titulo>>(rootUsers, HttpStatus.FOUND);
	}


	public ResponseEntity<List<Titulo>> getAllUsers(){
		List<Titulo> users = repository.findAll();
		return new ResponseEntity<List<Titulo>> (users, HttpStatus.FOUND);
	}
}
