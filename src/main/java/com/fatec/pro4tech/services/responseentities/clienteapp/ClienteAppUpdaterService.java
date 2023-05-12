package com.fatec.pro4tech.services.responseentities.clienteapp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fatec.pro4tech.entities.Cliente;
import com.fatec.pro4tech.entities.Contato;
import com.fatec.pro4tech.entities.Endereco;
import com.fatec.pro4tech.models.ClienteModel;
import com.fatec.pro4tech.repository.RepositorioCliente;

@Service
public class ClienteAppUpdaterService {
    @Autowired
	private RepositorioCliente repository;

	public ResponseEntity<Cliente> update(ClienteModel updateUser) {
		try {
            System.out.println("User" + updateUser);
			Optional<Cliente> currentUser = repository.findByCpf(updateUser.cpf());
            System.out.println("User");
			Cliente target = currentUser.orElse(null);

            if (target == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

          
            target.setNome(updateUser.nome());
        
        
            target.setCpf(updateUser.cpf());
            
			Contato contato = new Contato();
           
            contato.setTelefone(updateUser.telefone());
        
        
            contato.setEmail(updateUser.email());
            
            target.setContato(contato);
            
            Endereco endereco = new Endereco();
          
            endereco.setCep(updateUser.cep());
        
        
            endereco.setCidade(updateUser.cidade());
        
        
            endereco.setBairro(updateUser.bairro());
        
        
            endereco.setEstado(updateUser.estado());
        
        
            endereco.setLogradouro(updateUser.logradouro());
        
        
            endereco.setComplemento(updateUser.complemento());
            
            target.setEndereco(endereco);
            repository.save(target);
            
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (InvalidDataAccessApiUsageException e) {
			MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
			header.add(e.getCause().getMessage(), e.getLocalizedMessage());
			return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
		}
	}
}
