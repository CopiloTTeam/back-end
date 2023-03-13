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
        return "funcionario/cadastrarFuncionario";
    }

    @PostMapping("/cadastrar/funcionario")
    public String cadastrarFuncionario(@ModelAttribute Funcionario funcionario){
        repositorio.save(funcionario);
        return "redirect:/listar/funcionarios";
    }

    @GetMapping("/listar/funcionarios")
    public String listarFuncionarios(Model model){
        model.addAttribute("funcionarios", repositorio.findAll());
        return "funcionario/listarFuncionarios";
    }

    @GetMapping("/atualizar/funcionario/{id}")
    public String atualizarFuncionario(@PathVariable("id") long id, Model model){
        Funcionario funcionario = repositorio.findById(id).get();
        model.addAttribute("funcionario", funcionario);
        return "funcionario/atualizarFuncionario";
    }

    @PostMapping("/atualizar/funcionario/{id}")
    public String atualizarFuncionario(@PathVariable("id") long id, @ModelAttribute Funcionario funcionario){
        Funcionario funcionarioAtualizado = repositorio.findById(funcionario.getId()).get();
        funcionarioAtualizado.setNome(funcionario.getNome());
        funcionarioAtualizado.setCpf(funcionario.getCpf());
        funcionarioAtualizado.setCargo(funcionario.getCargo());
        repositorio.save(funcionarioAtualizado);
        return "redirect:/listar/funcionarios";
    }

    @GetMapping("/deletar/funcionario/{id}")
    public String deletarFuncionario(@PathVariable("id") long id){
        Funcionario funcionario = repositorio.findById(id).get();
        repositorio.delete(funcionario);
        return "redirect:/listar/funcionarios";
    }

}