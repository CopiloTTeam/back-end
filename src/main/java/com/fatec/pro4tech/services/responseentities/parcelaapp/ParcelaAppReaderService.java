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
		List<Parcela> parcelaList = parcelas.orElse(null);
		if (parcelaList == null) {
			return new ResponseEntity<List<Parcela>>(parcelaList, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Parcela>>(parcelaList, HttpStatus.FOUND);
		}
	}
	

}
