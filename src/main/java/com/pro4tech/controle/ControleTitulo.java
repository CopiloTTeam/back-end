package com.pro4tech.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pro4tech.modelo.Titulo;
import com.pro4tech.repositorio.RepositorioTitulo;


@RestController
public class ControleTitulo {
    
    @Autowired
    private RepositorioTitulo repositorio;

    @GetMapping("/listar/titulo")
    public List<Titulo> cadastroTitulo(){
        return repositorio.findAll();
    }

    @PostMapping("/cadastrar/titulo")
    public Titulo cadastrarTitulo(@RequestBody Titulo titulo){
        return repositorio.save(titulo);
    }

    @PutMapping("/atualizar/titulo/{id_titulo}")
    public Titulo atualizarTitulo(@PathVariable("id_titulo") long id_titulo, @ModelAttribute Titulo titulo){
        Titulo tituloAtualizado = repositorio.findById(id_titulo).get();
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
        return repositorio.save(tituloAtualizado);
    }

    @DeleteMapping("/deletar/titulo/{id}")
    public void deletarTitulo(@PathVariable("id") long id){
        repositorio.delete(repositorio.findById(id).get());
    }

}