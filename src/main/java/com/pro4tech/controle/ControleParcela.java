package com.pro4tech.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/listar/parcela/titulo/{id}")
    public ResponseEntity<?> listarParcelaPorIdTitulo(@PathVariable("id") Long id) {
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

}
