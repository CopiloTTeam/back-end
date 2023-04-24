package com.pro4tech.controle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pro4tech.modelo.Parcela;
import com.pro4tech.repositorio.RepositorioParcela;


@RestController
public class ControleParcela {

    @Autowired
    private RepositorioParcela repositorio;

    @GetMapping("/listar/parcela")
    public ResponseEntity<?> listarParcelas() {
        try {
            List<Parcela> parcelas = repositorio.findAll();
            if (parcelas.isEmpty()) {
                return new ResponseEntity<>("Não há parcelas cadastradas", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(parcelas, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao listar parcelas", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar/parcela/{id}")
    public ResponseEntity<?> listarParcelaPorId(@PathVariable("id") Long id) {
        try {
            var parcela = repositorio.findById(id);
            if (parcela.isPresent()) {
                return new ResponseEntity<>(parcela.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Parcela não encontrada", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao listar parcela", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // crie um método para listar parcelas por id de titulo
    // @GetMapping("/listar/parcela/titulo/{id}")
    // public ResponseEntity<?> listarParcelaPorIdTitulo(@PathVariable("id") Long id) {
    //     try {
    //         var parcela = repositorio.findById(id);
    //         if (parcela.isPresent()) {
    //             return new ResponseEntity<>(parcela.get(), HttpStatus.OK);
    //         } else {
    //             return new ResponseEntity<>("Parcela não encontrada", HttpStatus.BAD_REQUEST);
    //         }
    //     } catch (Exception e) {
    //         return new ResponseEntity<>("Erro ao listar parcela", HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @PutMapping("/atualizar/parcela/{id_parcela}")
    public ResponseEntity<?> atualizarParcela(@PathVariable("id_parcela") long id_parcela,
            @RequestBody Parcela parcela) {
        try {
            var parcelaAtualizada = repositorio.findById(id_parcela);
            // return 
            if (parcelaAtualizada.isPresent()) {
                if (parcelaAtualizada.get().getStatus() == false) {
                    Date date = new Date();
                    LocalDateTime data_hoje = LocalDateTime
                            .from(date.toInstant().atZone(java.time.ZoneId.systemDefault()));
                    parcelaAtualizada.get().setStatus(true);
                    parcelaAtualizada.get().setValor_pago(parcela.getValor_pago());
                    parcelaAtualizada.get()
                            .setData_pagamento(data_hoje.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                    parcelaAtualizada.get()
                            .setData_credito(data_hoje.plusDays(2).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                } else {
                    parcelaAtualizada.get().setStatus(false);
                    parcelaAtualizada.get().setValor_pago("0,00");
                    parcelaAtualizada.get().setData_pagamento(null);
                    parcelaAtualizada.get().setData_credito(null);
                }
                repositorio.save(parcelaAtualizada.get());
                return new ResponseEntity<>(parcelaAtualizada.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Parcela não encontrada", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar parcela", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar/parcela/titulo/{id_titulo}")
    public ResponseEntity<?> listarParcelasPorTitulo(@PathVariable("id_titulo") Long id_titulo){
        try {
            var todas_parcelas = repositorio.findAll();
            if (todas_parcelas.isEmpty()) {
                return new ResponseEntity<>("Não há parcelas cadastradas", HttpStatus.BAD_REQUEST);
            } else {
                List<Parcela> parcelas = new ArrayList<>();
                for (int i = 0; i < todas_parcelas.size(); i++) {
                    if (todas_parcelas.get(i).getId_titulo() == id_titulo){
                        parcelas.add(todas_parcelas.get(i));
                    }
                }
                if (parcelas.isEmpty()) {
                    return new ResponseEntity<>("Não há parcelas cadastradas para este título", HttpStatus.BAD_REQUEST);
                }
                return new ResponseEntity<>(parcelas, HttpStatus.OK);
            }
    } catch (Exception e) {
        return new ResponseEntity<>("Erro ao listar parcelas", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

}