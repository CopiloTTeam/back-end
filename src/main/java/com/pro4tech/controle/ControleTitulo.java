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
        return "titulo/cadastrarTitulo";
    }

    @PostMapping("/cadastrar/titulo")
    public String cadastrarTitulo(@ModelAttribute Titulo titulo){
        repositorio.save(titulo);
        return "redirect:/listarTitulos";
    }

    @GetMapping("/listar/titulos")
    public String listarTitulos(Model model){
        model.addAttribute("titulos", repositorio.findAll());
        return "titulo/listarTitulos";
    }

    @GetMapping("/atualizar/titulo/{id}")
    public String atualizarTitulo(@PathVariable("id") long id, Model model){
        Titulo titulo = repositorio.findById(id).get();
        model.addAttribute("titulo", titulo);
        return "titulo/atualizarTitulo";
    }

    // @PostMapping("/atualizar/titulo/{id}")
    // public String atualizarTitulo(@PathVariable("id") long id, @ModelAttribute Titulo titulo){
    //     Titulo tituloAtualizado = repositorio.findById(titulo.getId()).get();
    //     tituloAtualizado.setNome(titulo.getNome());
    //     tituloAtualizado.setCpf(titulo.getCpf());
    //     tituloAtualizado.setCep(titulo.getCep());
    //     repositorio.save(tituloAtualizado);
    //     return "redirect:/listar/titulos";
    // }

    @GetMapping("/deletar/titulo/{id}")
    public String deletarTitulo(@PathVariable("id") long id){
        Titulo titulo = repositorio.findById(id).get();
        repositorio.delete(titulo);
        return "redirect:/listar/titulos";
    }

}