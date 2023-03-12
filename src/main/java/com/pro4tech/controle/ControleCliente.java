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

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/cadastrar/cliente")
    public String cadastroCliente(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cadastrarCliente";
    }

    @PostMapping("/cadastrar/cliente")
    public String cadastrarCliente(@ModelAttribute Cliente cliente){
        repositorio.save(cliente);
        return "redirect:/";
    }








    @GetMapping("/listar/clientes")
    public String listarClientes(Model model){
        model.addAttribute("clientes", repositorio.findAll());
        return "listarClientes";
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
