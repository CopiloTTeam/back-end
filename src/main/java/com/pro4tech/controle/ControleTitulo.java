package com.pro4tech.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro4tech.modelo.Titulo;
import com.pro4tech.repositorio.RepositorioTitulo;

@RestController
public class ControleTitulo {
    
    @Autowired
    private RepositorioTitulo repositorio;

    @PostMapping("/cadastrar/titulo")
    public String cadastrarTitulo(@RequestBody Titulo titulo){
        String mensagem = "Titulo " + titulo.getId_titulo() + " cadastrado com sucesso!";
        repositorio.save(titulo);
        return mensagem;
    }

    @GetMapping("/listar/titulos")
    public Iterable<Titulo> listarTitulos(){
        return repositorio.findAll();
    }

    @GetMapping("/listar/titulo")
    public Titulo listarTitulo(@RequestBody Titulo titulo){
        return repositorio.findById(titulo.getId_titulo()).get();
    }

    @PatchMapping("/atualizar/titulo")
    public String atualizarTitulo(@RequestBody Titulo titulo){
        String mensagem = "Titulo " + titulo.getId_titulo() + " atualizado com sucesso!";
        repositorio.save(titulo);
        return mensagem;
    }

    @PostMapping("/deletar/titulo")
    public String deletarTitulo(@RequestBody Titulo titulo){
        String mensagem = "Titulo " + titulo.getId_titulo() + " deletado com sucesso!";
        repositorio.delete(titulo);
        return mensagem;
    }

}