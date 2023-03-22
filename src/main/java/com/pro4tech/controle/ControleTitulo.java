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
    public String cadastroTitulo(Model model) {
        model.addAttribute("titulo", new Titulo());
        return "titulo/cadastrarTitulo";
    }

    // vai embora

    @PostMapping("/cadastrar/titulo")
    public String cadastrarTitulo(@ModelAttribute Titulo titulo) {
        repositorio.save(titulo);
        return "redirect:/listar/titulos";
    }

    // Pega token, se valido
    // cadastra, cod 201
    // se não cod 401 - usuário não autenticado
    @GetMapping("/listar/titulos")
    public String listarTitulos(Model model) {
        model.addAttribute("titulos", repositorio.findAll());
        return "titulo/listarTitulos";
    }

    // pega token se estiver valido
    // codigo 202 e retorna json com dados
    // se não codigo 401 - usuário não autenticado
    @GetMapping("/atualizar/titulo/{id_titulo}")
    public String atualizarTitulo(@PathVariable("id_titulo") long id_titulo, Model model) {
        Titulo titulo = repositorio.findById(id_titulo).get();
        model.addAttribute("titulo", titulo);
        return "titulo/atualizarTitulo";
    }

    // pega token se estiver valido
    // codigo 202 e retorna json com dados
    // se não codigo 401 - usuário não autenticado
    @PostMapping("/atualizar/titulo/{id_titulo}")
    public String atualizarTitulo(@PathVariable("id_titulo") long id_titulo, @ModelAttribute Titulo titulo) {
        Titulo tituloAtualizado = repositorio.findById(titulo.getId_titulo()).get();
        tituloAtualizado.setParcelas(titulo.getParcelas());
        tituloAtualizado.setId_funcionario(titulo.getId_funcionario());
        tituloAtualizado.setId_cliente(titulo.getId_cliente());
        tituloAtualizado.setData_geracao(titulo.getData_geracao());
        tituloAtualizado.setData_vencimento(titulo.getData_vencimento());
        tituloAtualizado.setValor(titulo.getValor());
        tituloAtualizado.setCodigo_barra(titulo.getCodigo_barra());
        tituloAtualizado.setQr_code(titulo.getQr_code());
        tituloAtualizado.setNumero_boleto(titulo.getNumero_boleto());
        tituloAtualizado.setNome_produto(titulo.getNome_produto());
        repositorio.save(tituloAtualizado);
        return "redirect:/listar/titulos";
    }

    // pega token,se valido
    // codigo 202 - retorn json de cadastrado ou 400 e return de json com erro
    // se não codigo 401 - usuasrio não autenticado
    @GetMapping("/deletar/titulo/{id}")
    public String deletarTitulo(@PathVariable("id") long id) {
        Titulo titulo = repositorio.findById(id).get();
        repositorio.delete(titulo);
        return "redirect:/listar/titulos";
    }
    // pega token, se valido
    /// cod 202 e retorna json vazio ou 400 e return de json com erro
    // se não cod 401 - usuário não autenticado

}