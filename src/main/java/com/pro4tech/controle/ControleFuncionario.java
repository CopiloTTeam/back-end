package com.pro4tech.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro4tech.modelo.Funcionario;
import com.pro4tech.repositorio.RepositorioFuncionario;

@RestController
public class ControleFuncionario {
    
    @Autowired
    private RepositorioFuncionario repositorio;

    @PostMapping("/cadastrar/funcionario")
    public String cadastrarFuncionario(@RequestBody Funcionario funcionario){
        String mensagem = "Funcionario " + funcionario.getNome() + " cadastrado com sucesso!";
        repositorio.save(funcionario);
        return mensagem;
    }

    @GetMapping("/listar/funcionarios")
    public Iterable<Funcionario> listarFuncionarios(){
        return repositorio.findAll();
    }

    @GetMapping("/listar/funcionario")
    public Funcionario listarFuncionario(@RequestBody Funcionario funcionario){
        return repositorio.findById(funcionario.getId()).get();
    }

    @PatchMapping("/atualizar/funcionario")
    public String atualizarFuncionario(@RequestBody Funcionario funcionario){
        String mensagem = "Funcionario " + funcionario.getNome() + " atualizado com sucesso!";
        repositorio.save(funcionario);
        return mensagem;
    }

    @PostMapping("/deletar/funcionario")
    public String deletarFuncionario(@RequestBody Funcionario funcionario){
        String mensagem = "Funcionario " + funcionario.getNome() + " deletado com sucesso!";
        repositorio.delete(funcionario);
        return mensagem;
    }

}
