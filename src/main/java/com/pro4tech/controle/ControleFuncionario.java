package com.pro4tech.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.pro4tech.modelo.Funcionario;
import com.pro4tech.repositorio.RepositorioFuncionario;


@RestController
public class ControleFuncionario {
    
    @Autowired
    private RepositorioFuncionario repositorio;


    @PostMapping("/cadastrar/funcionario")
    public void cadastrarFuncionario(@RequestBody Funcionario funcionario){
        repositorio.save(funcionario);
    }

    @GetMapping("/listar/funcionario")
    public List<Funcionario> listarFuncionarios(Model model){
        return repositorio.findAll();
    }

    @PutMapping("/atualizar/funcionario/{id}")
    public Funcionario atualizarFuncionario(@PathVariable("id") long id, @RequestBody Funcionario funcionario){
        Funcionario funcionarioAtualizado = repositorio.findById(id).get();
        funcionarioAtualizado.setNome(funcionario.getNome());
        funcionarioAtualizado.setCpf(funcionario.getCpf());
        funcionarioAtualizado.setCargo(funcionario.getCargo());
        funcionarioAtualizado.setEmail(funcionario.getEmail());
        funcionarioAtualizado.setSenha(funcionario.getSenha());
        return repositorio.save(funcionarioAtualizado);
    }

    @DeleteMapping("/deletar/funcionario/{id}")
    public void deletarFuncionario(@PathVariable("id") long id){
        repositorio.delete(repositorio.findById(id).get());
    }

}