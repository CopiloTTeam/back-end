package com.fatec.pro4tech.controllers.Parcela;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.pro4tech.entities.Parcela;
import com.fatec.pro4tech.entities.Titulo;
import com.fatec.pro4tech.services.responseentities.parcelaapp.ParcelaAppReaderService;

import jakarta.annotation.security.PermitAll;

@CrossOrigin
@RestController
public class SelectParcela {
    @Autowired
	private ParcelaAppReaderService ParcelaReader;

	@GetMapping("/listar/parcelas")
	@PreAuthorize("hasAnyAuthority('Administrador','Comercial', 'Financeiro')")
	public ResponseEntity<List<Parcela>> getParcelas(@PathVariable Titulo titulo) {
		return ParcelaReader.getParcelas(titulo); 
	}
	
	@GetMapping("/listar/parcela/{id}")
	@PermitAll
	public ResponseEntity<Parcela> getParcela(@PathVariable Long id) {
		return ParcelaReader.getParcela(id);
	}
}
