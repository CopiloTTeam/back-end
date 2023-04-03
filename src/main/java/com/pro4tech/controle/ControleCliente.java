package com.pro4tech.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pro4tech.modelo.Cliente;
import com.pro4tech.repositorio.RepositorioCliente;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class ControleCliente {

    @Autowired
    private RepositorioCliente repositorio;

    @GetMapping("/listar/cliente")
    public ResponseEntity<?> listarClientes() {
        try {
            List<Cliente> clientes = repositorio.findAll();
            if (clientes.isEmpty()) {
                return new ResponseEntity<>("Não há clientes cadastrados", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(clientes, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao listar clientes", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar/clientecpf/{cpf}")
    public ResponseEntity<?> listarClientePorCpf(@PathVariable("cpf") String cpf) {
        try {
            Optional<Cliente> cliente = repositorio.findByCpf(cpf);
            if (cliente.isPresent()) {
                return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cliente não encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao listar cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/cadastrar/cliente")
    public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cliente) {
        try {
            // Verifica se já existe algum cliente com o mesmo CPF cadastrado
            if (repositorio.findByCpf(cliente.getCpf()).isPresent()) {
                return new ResponseEntity<>("Já existe um cliente com o mesmo CPF cadastrado", HttpStatus.BAD_REQUEST);
            }
            var clienteCad = repositorio.save(cliente);
            return new ResponseEntity<>(clienteCad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao cadastrar cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/atualizar/cliente/{cpf}")
    public ResponseEntity<?> atualizarCliente(@PathVariable("cpf") String cpf,
            @RequestBody Cliente cliente) {
        try {
            Cliente clienteAtualizado = repositorio.findByCpf(cpf)
                    .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
            if (cliente.getNome() != null) {
                clienteAtualizado.setNome(cliente.getNome());
            }
            if (cliente.getCpf() != null) {
                if (repositorio.findByCpf(cliente.getCpf()).isPresent()) {
                    return new ResponseEntity<>("CPF já cadastrado", HttpStatus.BAD_REQUEST);
                }
                clienteAtualizado.setCpf(cliente.getCpf());
            }
            if (cliente.getCep() != null) {
                clienteAtualizado.setCep(cliente.getCep());
            }
            if (cliente.getLogradouro() != null) {
                clienteAtualizado.setLogradouro(cliente.getLogradouro());
            }
            if (cliente.getBairro() != null) {
                clienteAtualizado.setBairro(cliente.getBairro());
            }
            if (cliente.getCidade() != null) {
                clienteAtualizado.setCidade(cliente.getCidade());
            }
            if (cliente.getEstado() != null) {
                clienteAtualizado.setEstado(cliente.getEstado());
            }
            if (cliente.getEmail() != null) {
                clienteAtualizado.setEmail(cliente.getEmail());
            }
            Cliente clienteSalvo = repositorio.save(clienteAtualizado);
            return new ResponseEntity<>(clienteSalvo, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Cliente não encontrado", HttpStatus.NOT_FOUND);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Ocorreu um erro ao atualizar o cliente. Verifique se os dados estão corretos.",
                    HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletar/cliente/{cpf}")
    public ResponseEntity<?> deletarCliente(@PathVariable("cpf") String cpf) {
        try {
            repositorio.deletebyCpf(cpf);
            return new ResponseEntity<>("Cliente deletado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}