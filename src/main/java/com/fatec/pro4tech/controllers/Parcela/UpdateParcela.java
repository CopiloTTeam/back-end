package com.fatec.pro4tech.controllers.Parcela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.fatec.pro4tech.models.TituloModel;
import com.fatec.pro4tech.services.responseentities.parcelaapp.ParcelaAppUpdateService;


@CrossOrigin
@RestController

public class UpdateParcela {
    @Autowired
	private ParcelaAppUpdateService userWriter;

	@PreAuthorize("hasAnyAuthority('Administrador','Comercial', 'Financeiro')")
	@PutMapping("/atualizar/parcela/{id_parcela}")
	public ResponseEntity<?> saveUser(@RequestBody TituloModel updateTitulo , @PathVariable Long id_parcela) {
		return userWriter.update(updateTitulo, id_parcela);
	}
}
