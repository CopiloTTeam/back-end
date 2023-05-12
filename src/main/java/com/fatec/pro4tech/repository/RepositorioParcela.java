package com.fatec.pro4tech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.pro4tech.entities.Parcela;
// import com.fatec.pro4tech.entities.Titulo;

public interface RepositorioParcela extends JpaRepository<Parcela, Long> {

   @Query("SELECT p FROM Parcela p WHERE p.titulo.id = ?1")
   Optional<List<Parcela>> findByTituloId(Long idTitulo);

// Optional<Titulo> findById(String id);

}