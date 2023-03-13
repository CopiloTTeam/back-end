package com.pro4tech.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pro4tech.modelo.Titulo;
import com.pro4tech.repositorio.RepositorioTitulo;


@Controller
public class ControleTitulo {
    
    @Autowired
    private RepositorioTitulo repositorio;

    @GetMapping("/cadastrar/titulo")
    public String cadastroTitulo(Model model){
        model.addAttribute("titulo", new Titulo());
        return "cadastrarTitulo";
    }

    @PostMapping("/cadastrar/titulo")
    public String cadastrarTitulo(@ModelAttribute Titulo titulo){
        repositorio.save(titulo);
        return "redirect:/";
    }

    @GetMapping("/listar/titulos")
    public String listarTitulos(Model model){
        model.addAttribute("titulos", repositorio.findAll());
        return "listarTitulos";
    }

    @GetMapping("/listar/titulo/{id}")
    public String listarTitulo(@PathVariable("id") long id, Model model){
        Titulo titulo = repositorio.findById(id).get();
        model.addAttribute("titulo", titulo);
        return "listarTitulo";
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