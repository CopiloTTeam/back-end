package com.fatec.pro4tech.controllers.Titulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.pro4tech.entities.Titulo;
import com.fatec.pro4tech.services.responseentities.tituloapp.TituloAppDeleteService;
@CrossOrigin
@RestController
public class DeleteTitulo {
    @Autowired
	private TituloAppDeleteService deleter;
	
	@DeleteMapping("/deletar/titulo")
	@PreAuthorize("hasAnyAuthority('Administrador','Comercial', 'Financeiro')")
	public ResponseEntity<?> delete(@RequestBody Titulo user){
		return deleter.delete(user);
	}
}
