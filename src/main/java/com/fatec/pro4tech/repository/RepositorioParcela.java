package com.fatec.pro4tech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.pro4tech.entities.Parcela;


public interface RepositorioParcela extends JpaRepository<Parcela, Long>{

    // Optional<Parcela> findById(String id_parcela);
}