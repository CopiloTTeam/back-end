package com.fatec.pro4tech.controllers.Parcela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.pro4tech.entities.Parcela;
import com.fatec.pro4tech.models.TituloModel;
import com.fatec.pro4tech.services.responseentities.parcelaapp.ParcelaAppUpdateService;

@CrossOrigin
@RestController

public class UpdateParcela {
	@Autowired
	private ParcelaAppUpdateService userWriter;

	@PostMapping("/atualizar/parcela/{id}")
	@PreAuthorize("hasAnyAuthority('Administrador','Financeiro')")
	public ResponseEntity<?> saveUser(@RequestBody Parcela parcela, @PathVariable Long id) {
		return userWriter.update(parcela, id);
	}

}
