package com.fatec.pro4tech.services.responseentities.estatisticaapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.pro4tech.entities.Parcela;
import com.fatec.pro4tech.entities.Titulo;
import com.fatec.pro4tech.repository.RepositorioEstatistica;
import com.fatec.pro4tech.repository.RepositorioParcela;

@Service
public class EstatisticaAppReaderService {
    @Autowired
	private RepositorioEstatistica repository;

	public ResponseEntity<List<Parcela>> getParcelas() {
		List<Parcela> parcelas = repository.findAll();
		if (!parcelas.isEmpty()) {
			return ResponseEntity.ok(parcelas);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
