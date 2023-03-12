package com.pro4tech.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro4tech.modelo.Cliente;
import com.pro4tech.repositorio.RepositorioCliente;

@RestController
public class ControleCliente {
    
    @Autowired
    private RepositorioCliente repositorio;

    @PostMapping("/cadastrar/cliente")
    public String cadastrarCliente(@RequestBody Cliente cliente){
        String mensagem = "Cliente " + cliente.getNome() + " cadastrado com sucesso!";
        repositorio.save(cliente);
        return mensagem;
    }

    @GetMapping("/listar/clientes")
    public Iterable<Cliente> listarClientes(){
        return repositorio.findAll();
    }

    @GetMapping("/listar/cliente")
    public Cliente listarCliente(@RequestBody Cliente cliente){
        return repositorio.findById(cliente.getId()).get();
    }

    @PatchMapping("/atualizar/cliente")
    public String atualizarCliente(@RequestBody Cliente cliente){
        String mensagem = "Cliente " + cliente.getNome() + " atualizado com sucesso!";
        repositorio.save(cliente);
        return mensagem;
    }

    @PostMapping("/deletar/cliente")
    public String deletarCliente(@RequestBody Cliente cliente){
        String mensagem = "Cliente " + cliente.getNome() + " deletado com sucesso!";
        repositorio.delete(cliente);
        return mensagem;
    }

}
