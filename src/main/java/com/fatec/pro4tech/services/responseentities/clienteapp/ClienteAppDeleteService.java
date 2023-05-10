package com.fatec.pro4tech.services.responseentities.clienteapp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fatec.pro4tech.entities.Cliente;
import com.fatec.pro4tech.repository.RepositorioCliente;

@Service
public class ClienteAppDeleteService {
    @Autowired
	private RepositorioCliente repository;

	public ResponseEntity<?> delete(Cliente cliente) {
		try {
			Optional<Cliente> currentUser = repository.findByCpf(cliente.getCpf());
			Cliente target = currentUser.orElse(null);
			repository.delete(target);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (InvalidDataAccessApiUsageException e) {
			MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
			header.add(e.getCause().getMessage(), e.getLocalizedMessage());
			return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
		}
	}
}
