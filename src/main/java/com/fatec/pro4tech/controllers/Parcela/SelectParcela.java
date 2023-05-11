package com.fatec.pro4tech.controllers.Parcela;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.pro4tech.entities.Parcela;
import com.fatec.pro4tech.entities.Titulo;
import com.fatec.pro4tech.services.responseentities.parcelaapp.ParcelaAppReaderService;

@CrossOrigin
@RestController
public class SelectParcela {
    @Autowired
	private ParcelaAppReaderService ParcelaReader;

	@PostMapping("/listar/parcelas")
	@PreAuthorize("hasAnyAuthority('Administrador','Comercial', 'Financeiro')")
	public ResponseEntity<List<Parcela>> getUser(@RequestBody Titulo titulo) {
		return ParcelaReader.getParcelas(titulo);
	}

}
