package com.fatec.pro4tech.services.responseentities.clienteapp;

// import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fatec.pro4tech.entities.Cliente;
import com.fatec.pro4tech.entities.Contato;
import com.fatec.pro4tech.entities.Endereco;
import com.fatec.pro4tech.models.ClienteModel;
import com.fatec.pro4tech.repository.RepositorioCliente;
// import com.fatec.pro4tech.services.credentials.CredentialAppValidatorService;

@Service
public class ClienteAppWriterService {
    @Autowired
	private RepositorioCliente repository;

	public ResponseEntity<?> save(ClienteModel cliente) {
		try {
			Cliente cli = new Cliente();
            
            cli.setCpf(cliente.cpf());
            cli.setNome(cliente.nome());
			cli.setDataNascimento(cliente.dataNascimento());
            Contato contato = new Contato();
            contato.setTelefone(cliente.telefone());
            contato.setEmail(cliente.email());
            // contato.setCliente(cli);
            cli.setContato(contato);
            Endereco endereco = new Endereco();

            endereco.setCep(cliente.cep());
            endereco.setCidade(cliente.cidade());
			endereco.setBairro(cliente.bairro());
			endereco.setEstado(cliente.estado());
			endereco.setLogradouro(cliente.logradouro());
			endereco.setComplemento(cliente.complemento());
			endereco.setRua(cliente.rua());
			// endereco.setCliente(cli);
			cli.setEndereco(endereco);

			System.out.println("Cliente: " + cli);
			repository.save(cli);
            // repositoryCliente.save(cli);

			// repository.save(cliente);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (DataIntegrityViolationException e) {
			MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
			header.add(e.getCause().getMessage(), e.getLocalizedMessage());
			return new ResponseEntity<>(header, HttpStatus.BAD_REQUEST);
		}
	}
}