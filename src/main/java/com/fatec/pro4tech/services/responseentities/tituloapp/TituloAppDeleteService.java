package com.fatec.pro4tech.services.responseentities.tituloapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.pro4tech.repository.RepositorioTitulo;

@Service
public class TituloAppDeleteService {
    @Autowired
	private RepositorioTitulo repository;

	// public ResponseEntity<?> delete(Titulo user) {
	// 	// try {
	// 	// 	Optional<Titulo> currentUser = repository.findById(user.getId_titulo());
	// 	// 	Titulo target = currentUser.orElse(null);
	// 	// 	repository.delete(target);
	// 	// 	return new ResponseEntity<>(HttpStatus.OK);
	// 	// }catch (InvalidDataAccessApiUsageException e) {
	// 	// 	MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
	// 	// 	header.add(e.getCause().getMessage(), e.getLocalizedMessage());
	// 	// 	return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
	// 	// }
	// }
}
