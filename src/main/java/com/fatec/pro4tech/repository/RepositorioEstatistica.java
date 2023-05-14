package com.fatec.pro4tech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.pro4tech.entities.Parcela;

public interface RepositorioEstatistica extends JpaRepository<Parcela, Long> {

   @Query("SELECT * FROM Parcela p where p.data_vencimento< '2023-06-31'")
   Optional<List<Parcela>> findByTituloId(Long idTitulo);
}