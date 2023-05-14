package com.fatec.pro4tech.controllers.Estatistica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.pro4tech.entities.Parcela;
import com.fatec.pro4tech.entities.Titulo;
import com.fatec.pro4tech.services.responseentities.estatisticaapp.EstatisticaAppReaderService;

@CrossOrigin
@RestController
public class SelectEstatistica {
    @Autowired
	private EstatisticaAppReaderService EstatisticaReader;

	@GetMapping("/estatistica/parcelas")
	@PreAuthorize("hasAnyAuthority('Administrador','Comercial', 'Financeiro')")
	public ResponseEntity<List<Parcela>> getParcelas() {
		return EstatisticaReader.getParcelas(); 
	}
}
