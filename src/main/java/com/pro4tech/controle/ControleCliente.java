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
    //vai embora

    @PostMapping("/cadastrar/cliente")
    public String cadastrarCliente(@ModelAttribute Cliente cliente){
        repositorio.save(cliente);
        return "redirect:/listar/clientes";
    }
    //pega token, se estiver valido
    //recebe informações e cadastra, codigo 201 - ok
    //se não codigo 401 - usuário não autenticado

    @GetMapping("/listar/clientes")
    public String listarClientes(Model model){
        model.addAttribute("clientes", repositorio.findAll());
        return "cliente/listarClientes";
    }

    //pega token se estiver valido
    //codigo 202 e retorna json com dados
    //se não codigo 401 - usuário não autenticado

    @GetMapping("/atualizar/cliente/{id_cliente}")
    public String atualizarCliente(@PathVariable("id_cliente") long id_cliente, Model model){
        Cliente cliente = repositorio.findById(id_cliente).get();
        model.addAttribute("cliente", cliente);
        return "cliente/atualizarCliente";
    }

    //pega token se estiver valido
    //codigo 202 e retorna json com dados
    //se não codigo 401 - usuário não autenticado

    @PostMapping("/atualizar/cliente/{id_cliente}")
    public String atualizarCliente(@PathVariable("id_cliente") long id_cliente, @ModelAttribute Cliente cliente){
        Cliente clienteAtualizado = repositorio.findById(cliente.getId_cliente()).get();
        clienteAtualizado.setNome(cliente.getNome());
        clienteAtualizado.setCpf(cliente.getCpf());
        clienteAtualizado.setCep(cliente.getCep());
        clienteAtualizado.setLogradouro(cliente.getLogradouro());
        clienteAtualizado.setBairro(cliente.getBairro());
        clienteAtualizado.setCidade(cliente.getCidade());
        clienteAtualizado.setEstado(cliente.getEstado());
        clienteAtualizado.setEmail(cliente.getEmail());
        repositorio.save(clienteAtualizado);
        return "redirect:/listar/clientes";
    }
    //pega token,se valido
    //codigo 202 - retorn json de cadastrado ou 400 e return de json com erro
    //se não codigo 401 - usuasrio não autenticado

    @GetMapping("/deletar/cliente/{id_cliente}")
    public String deletarCliente(@PathVariable("id_cliente") long id_cliente){
        Cliente cliente = repositorio.findById(id_cliente).get();
        repositorio.delete(cliente);
        return "redirect:/listar/clientes";
    }

    //pega token, se valido
    ///cod 202 e retorna json vazio ou 400 e return de json com erro
    //se não cod 401 - usuário não autenticado

}