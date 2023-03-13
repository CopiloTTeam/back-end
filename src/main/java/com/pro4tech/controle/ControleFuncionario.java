package com.pro4tech.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pro4tech.modelo.Funcionario;
import com.pro4tech.repositorio.RepositorioFuncionario;


@Controller
public class ControleFuncionario {
    
    @Autowired
    private RepositorioFuncionario repositorio;

    @GetMapping("/cadastrar/funcionario")
    public String cadastroFuncionario(Model model){
        model.addAttribute("funcionario", new Funcionario());
        return "cadastrarFuncionario";
    }

    @PostMapping("/cadastrar/funcionario")
    public String cadastrarFuncionario(@ModelAttribute Funcionario funcionario){
        repositorio.save(funcionario);
        return "redirect:/";
    }

    @GetMapping("/listar/funcionarios")
    public String listarFuncionarios(Model model){
        model.addAttribute("funcionarios", repositorio.findAll());
        return "listarFuncionarios";
    }

    @GetMapping("/listar/funcionario/{id}")
    public String listarFuncionario(@PathVariable("id") long id, Model model){
        Funcionario funcionario = repositorio.findById(id).get();
        model.addAttribute("funcionario", funcionario);
        return "listarFuncionario";
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