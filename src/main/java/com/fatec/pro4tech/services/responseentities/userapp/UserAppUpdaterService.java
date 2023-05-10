package com.fatec.pro4tech.services.responseentities.userapp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fatec.pro4tech.entities.Funcionario;
import com.fatec.pro4tech.repository.RepositorioFuncionario;

@Service
public class UserAppUpdaterService {
	@Autowired
	private RepositorioFuncionario repository;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public ResponseEntity<Funcionario> update(Funcionario updateUser) {
		try {
			Optional<Funcionario> currentUser = repository.findByCpf(updateUser.getCpf());
			Funcionario target = currentUser.orElse(null);
			if(!(updateUser.getNome() == null)){
				if(!updateUser.getNome().isEmpty()){
					target.setNome(updateUser.getNome());
				}
			}
			if(updateUser.getEmail() != null ){
				if (!updateUser.getEmail().isEmpty()) {
					target.setEmail(updateUser.getEmail());
				}
			}
			if (!(updateUser.getCredential() == null)) {
				String password = updateUser.getCredential().getPassword();
				updateUser.getCredential().setPassword(encoder.encode(password));
				target.setCredential(updateUser.getCredential());
			}
			
			repository.save(target);
			return new ResponseEntity<>(target, HttpStatus.ACCEPTED);
		} catch (InvalidDataAccessApiUsageException e) {
			MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
			header.add(e.getCause().getMessage(), e.getLocalizedMessage());
			return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
		}
	}
}
