package com.pro4tech.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro4tech.repositorio.RepositorioCliente;
import com.pro4tech.repositorio.RepositorioTitulo;

@RestController
public class ControleGraficos {
    

    @Autowired
    private RepositorioCliente client;

    @Autowired
    private RepositorioTitulo title;


    @GetMapping("/home/titulosxclientes")
    public ResponseEntity<?> home()
    {
        try{
            // var titles = title.selectAllTitulos();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
}
