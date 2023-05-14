package com.fatec.pro4tech.services.responseentities.parcelaapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fatec.pro4tech.entities.Parcela;
import com.fatec.pro4tech.entities.Titulo;
import com.fatec.pro4tech.repository.RepositorioParcela;

@Service
public class ParcelaAppReaderService {
    @Autowired
	private RepositorioParcela repository;

	public ResponseEntity<List<Parcela>> getParcelas(Titulo titulo) {
		Optional<List<Parcela>> parcelas = repository.findByTituloId(titulo.getId());
		if (parcelas.isPresent()) {
			return ResponseEntity.ok(parcelas.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	public ResponseEntity<Parcela> getParcela(Long id_parcela) {
		Optional<Parcela> parcela = repository.findById(id_parcela);
		if (parcela.isPresent()) {
			return ResponseEntity.ok(parcela.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
