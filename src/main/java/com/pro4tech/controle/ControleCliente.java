package com.pro4tech.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pro4tech.modelo.Cliente;
import com.pro4tech.repositorio.RepositorioCliente;


@RestController
public class ControleCliente {
    
    @Autowired
    private RepositorioCliente repositorio;

    @GetMapping("/listar/cliente")
    public List<Cliente> listarClientes(){
        return repositorio.findAll();
        
    }
    @PostMapping("/cadastrar/cliente")
    public void cadastrarFuncionario(@RequestBody Cliente cliente){
        repositorio.save(cliente);
    }

    @PutMapping("/atualizar/cliente/{id_cliente}")
    public Cliente atualizarCliente(@PathVariable("id_cliente") long id_cliente, @RequestBody Cliente cliente){
        Cliente clienteAtualizado = repositorio.findById(cliente.getId_cliente()).get();
        clienteAtualizado.setNome(cliente.getNome());
        clienteAtualizado.setCpf(cliente.getCpf());
        clienteAtualizado.setCep(cliente.getCep());
        clienteAtualizado.setLogradouro(cliente.getLogradouro());
        clienteAtualizado.setBairro(cliente.getBairro());
        clienteAtualizado.setCidade(cliente.getCidade());
        clienteAtualizado.setEstado(cliente.getEstado());
        clienteAtualizado.setEmail(cliente.getEmail());
        return repositorio.save(clienteAtualizado);
    }

    @DeleteMapping("/deletar/cliente/{id_cliente}")
    public void deletarCliente(@PathVariable("id_cliente") long id_cliente){
        repositorio.delete(repositorio.findById(id_cliente).get());
    }

}