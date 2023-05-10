// package com.fatec.pro4tech.services.responseentities.userapp;

// import java.util.Optional;
// import java.util.Date;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.dao.InvalidDataAccessApiUsageException;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;
// import org.springframework.util.LinkedMultiValueMap;
// import org.springframework.util.MultiValueMap;

// import com.fatec.pro4tech.entities.Titulo;
// import com.fatec.pro4tech.repository.RepositorioTitulo;

// @Service
// public class TituloAppUpdaterService {
// 	@Autowired
// 	private RepositorioTitulo repository;

// 	public ResponseEntity<Titulo> update(Titulo updateUser) {
// 		try {
// 			Optional<Titulo> currentUser = repository.findById(updateUser.get ());
// 			Titulo target = currentUser.orElse(null);
// 			if (target.getNome() != updateUser.getNome()) {
// 				target.setNome(updateUser.getNome());
// 			}
// 			if (target.getEmail() != updateUser.getEmail()) {
// 				target.setEmail(updateUser.getEmail());
// 			}
// 			if (target.getCredential() != updateUser.getCredential()) {
// 				if (target.getCredential().getUserName() != updateUser.getCredential().getUserName()) {
// 					target.getCredential().setUserName(updateUser.getCredential().getUserName());
// 				}
// 				if (target.getCredential().getPassword() != updateUser.getCredential().getPassword()) {
// 					target.getCredential().setPassword(updateUser.getCredential().getPassword());
// 				}
// 				if (target.getCredential().getRoles() != updateUser.getCredential().getRoles()) {
// 					target.getCredential().getRoles().clear();
// 					target.getCredential().setRoles(updateUser.getCredential().getRoles());
// 				}
// 				target.setRegistration(new Date(System.currentTimeMillis()));
// 			}
// 			repository.save(updateUser);
// 			return new ResponseEntity<>(target, HttpStatus.ACCEPTED);
// 		} catch (InvalidDataAccessApiUsageException e) {
// 			MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
// 			header.add(e.getCause().getMessage(), e.getLocalizedMessage());
// 			return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
// 		}
// 	}
// }
