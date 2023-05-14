package com.fatec.pro4tech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.pro4tech.entities.Parcela;

public interface RepositorioParcela extends JpaRepository<Parcela, Long> {

   @Query("SELECT p FROM Parcela p WHERE p.titulo.id = ?1")
   Optional<List<Parcela>> findByTituloId(Long idTitulo);

<<<<<<< HEAD
   
   Optional<Parcela> findById(Long id_parcela);
   // @Query("SELECT p FROM Parcela p WHERE p.id_parcela = ?1")
   // Optional<Parcela> findOne(Long id_parcela);
}
=======
   // Optional<Parcela> findByid_parcela (Long id_parcela);


}
>>>>>>> ac97f5a7b62036e2e968882608174ab37a3333da
