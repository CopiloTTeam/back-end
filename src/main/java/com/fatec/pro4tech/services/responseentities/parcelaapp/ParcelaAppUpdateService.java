package com.fatec.pro4tech.services.responseentities.parcelaapp;
import java.util.Optional;

import com.fatec.pro4tech.models.TituloModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fatec.pro4tech.entities.Parcela;
import com.fatec.pro4tech.repository.RepositorioParcela;


@Service

public class ParcelaAppUpdateService {
    @Autowired
	private RepositorioParcela repository;

	public ResponseEntity<Parcela> update(TituloModel updateTitulo , Long id_parcela) {
		try {
			Optional<Parcela> currentUser = repository.findByid_parcela(id_parcela);
			Parcela target = currentUser.orElse(null);
            
            if (target == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
           if (updateTitulo.codigo_barra() != null){
               target.setCodigo_barra(updateTitulo.codigo_barra());
           } else {
               target.setCodigo_barra(target.getCodigo_barra());
           }
           if(updateTitulo.data_vencimento() != null){
               target.setData_vencimento(updateTitulo.data_vencimento());
           } else {
               target.setData_vencimento(target.getData_vencimento());
           }

           if(updateTitulo.data_pagamento() != null){
                target.setData_pagamento(updateTitulo.data_pagamento());
            } else {
            target.setData_pagamento(target.getData_pagamento());
            }
            if(updateTitulo.valor() != null){
                target.setValor(updateTitulo.valor());
            } else {
                target.setValor(target.getValor());
            }
            if(updateTitulo.status() != null){
                target.setStatus(updateTitulo.status());
            } else {
                target.setStatus(target.getStatus());
            }
            if(updateTitulo.valor_pago() != null){
                target.setValor_pago(updateTitulo.valor_pago());
            } else {
                target.setValor_pago(target.getValor_pago());
            }
            if (updateTitulo.data_credito() != null){
                target.setData_credito(updateTitulo.data_credito());
            } else {
                target.setData_credito(target.getData_credito());
            }
            if (updateTitulo.numero_boleto() != null){
                target.setNumero_boleto(updateTitulo.numero_boleto());
            } else {
                target.setNumero_boleto(target.getNumero_boleto());
            }
            if(updateTitulo.qr_code() != null){
                target.setQr_code(updateTitulo.qr_code());
            } else {
                target.setQr_code(target.getQr_code());
            }
			repository.save(target);
			return new ResponseEntity<>( HttpStatus.ACCEPTED);
		} catch (InvalidDataAccessApiUsageException e) {
			MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
			header.add(e.getCause().getMessage(), e.getLocalizedMessage());
			return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
		}
	}
}
