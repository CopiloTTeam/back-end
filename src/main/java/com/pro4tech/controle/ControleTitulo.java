package com.pro4tech.controle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pro4tech.modelo.Parcela;
import com.pro4tech.modelo.Titulo;
import com.pro4tech.repositorio.RepositorioParcela;
import com.pro4tech.repositorio.RepositorioTitulo;

@RestController
public class ControleTitulo {

    @Autowired
    private RepositorioTitulo repositorio;
    @Autowired
    private RepositorioParcela repositorioParcela;

    
    @GetMapping("/listar/titulo")
    public ResponseEntity<?> cadastroTitulo() {
        try {
            List<Titulo> titulos = repositorio.findAll();

            if (titulos.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(titulos);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar títulos: " + e.getMessage());
        }
    }

    @GetMapping("/listar/titulo/{id}")
    public ResponseEntity<?> buscarTituloPorId(@PathVariable Long id) {
        try {
            Optional<Titulo> tituloOpt = repositorio.findById(id);

            if (tituloOpt.isPresent()) {
                return ResponseEntity.ok(tituloOpt.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar título: " + e.getMessage());
        }
    }

    @PostMapping("/cadastrar/titulo")
    public ResponseEntity<?> cadastrarTitulo(@RequestBody Titulo titulo) {
        try {
            Date date = new Date();
            LocalDateTime data_hoje = LocalDateTime.from(date.toInstant().atZone(java.time.ZoneId.systemDefault()));
            titulo.setData_geracao(data_hoje.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            Titulo novoTitulo = repositorio.save(titulo);
            for (int parcelas = 1; parcelas <= 12; parcelas++) {
                LocalDateTime data_vencimento = LocalDateTime.from(data_hoje).plusDays(parcelas * 30);
                Parcela parcela = new Parcela();
                parcela.setId_titulo(novoTitulo.getId_titulo());
                parcela.setcpf_cliente(novoTitulo.getcpf_cliente());
                parcela.setData_vencimento(data_vencimento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                parcela.setData_pagamento(null);
                parcela.setData_credito(null);
                parcela.setStatus(false);
                parcela.setValor((double) (novoTitulo.getValor() / 12));
                parcela.setValor_pago(0.0);
                System.out.println(parcela);
                repositorioParcela.save(parcela);
            }
            return ResponseEntity.ok(novoTitulo);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar título: " + e.getMessage());
        }
    }

    @PutMapping("/atualizar/titulo/{id_titulo}")
    public ResponseEntity<?> atualizarTitulo(@PathVariable("id_titulo") long id_titulo, @RequestBody Titulo titulo) {
        try {
            Optional<Titulo> tituloOpt = repositorio.findById(id_titulo);

            if (tituloOpt.isPresent()) {
                Titulo tituloAtualizado = tituloOpt.get();

                if (titulo.getcpf_funcionario() != null) {
                    tituloAtualizado.setcpf_funcionario(titulo.getcpf_funcionario());
                }
                if (titulo.getcpf_cliente() != null) {
                    tituloAtualizado.setcpf_cliente(titulo.getcpf_cliente());
                }
                if (titulo.getData_geracao() != null) {
                    tituloAtualizado.setData_geracao(titulo.getData_geracao());
                }
                if (titulo.getValor() != null) {
                    tituloAtualizado.setValor(titulo.getValor());
                }
                if (titulo.getCodigo_barra() != null) {
                    tituloAtualizado.setCodigo_barra(titulo.getCodigo_barra());
                }
                if (titulo.getQr_code() != null) {
                    tituloAtualizado.setQr_code(titulo.getQr_code());
                }
                if (titulo.getNumero_boleto() != null) {
                    tituloAtualizado.setNumero_boleto(titulo.getNumero_boleto());
                }
                if (titulo.getNome_produto() != null) {
                    tituloAtualizado.setNome_produto(titulo.getNome_produto());
                }

                return ResponseEntity.ok(repositorio.save(tituloAtualizado));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar título: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletar/titulo/{id}")
    public ResponseEntity<String> deletarTitulo(@PathVariable("id") long id) {
        try {
            Optional<Titulo> titulo = repositorio.findById(id);
            if (titulo.isPresent()) {
                repositorio.delete(titulo.get());
                return ResponseEntity.ok("Título deletado com sucesso.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar título: " + e.getMessage());
        }
    }




    //DIRECT FUNCTIONS

}