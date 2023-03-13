package com.pro4tech.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pro4tech.modelo.Cliente;
import com.pro4tech.repositorio.RepositorioCliente;


@Controller
public class ControleCliente {
    
    @Autowired
    private RepositorioCliente repositorio;

    @GetMapping("/cadastrar/cliente")
    public String cadastroCliente(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cliente/cadastrarCliente";
    }

    @PostMapping("/cadastrar/cliente")
    public String cadastrarCliente(@ModelAttribute Cliente cliente){
        repositorio.save(cliente);
        return "redirect:/listarClientes";
    }

    @GetMapping("/listar/clientes")
    public String listarClientes(Model model){
        model.addAttribute("clientes", repositorio.findAll());
        return "cliente/listarClientes";
    }

    @GetMapping("/atualizar/cliente/{id}")
    public String atualizarCliente(@PathVariable("id") long id, Model model){
        Cliente cliente = repositorio.findById(id).get();
        model.addAttribute("cliente", cliente);
        return "cliente/atualizarCliente";
    }

    @PostMapping("/atualizar/cliente/{id}")
    public String atualizarCliente(@PathVariable("id") long id, @ModelAttribute Cliente cliente){
        Cliente clienteAtualizado = repositorio.findById(cliente.getId()).get();
        clienteAtualizado.setNome(cliente.getNome());
        clienteAtualizado.setCpf(cliente.getCpf());
        clienteAtualizado.setCep(cliente.getCep());
        repositorio.save(clienteAtualizado);
        return "redirect:/listar/clientes";
    }

    @GetMapping("/deletar/cliente/{id}")
    public String deletarCliente(@PathVariable("id") long id){
        Cliente cliente = repositorio.findById(id).get();
        repositorio.delete(cliente);
        return "redirect:/listar/clientes";
    }

}