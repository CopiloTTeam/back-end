package com.fatec.pro4tech.services.responseentities.clienteapp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fatec.pro4tech.entities.Cliente;
import com.fatec.pro4tech.repository.RepositorioCliente;

import org.springframework.dao.InvalidDataAccessApiUsageException;

@Service
public class ClienteAppDeleteService {
	@Autowired
	private RepositorioCliente repository;

	public ResponseEntity<Cliente> delete(String cpf) {
		try {
			Optional<Cliente> clienteOptional = repository.findById(cpf);
			if (clienteOptional.isPresent()) {
				Cliente cliente = clienteOptional.get();
				repository.delete(cliente);
				return new ResponseEntity<>(cliente, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.err.println("Erro durante a exclusão do cliente: " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
