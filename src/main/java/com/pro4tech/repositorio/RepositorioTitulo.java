package com.pro4tech.repositorio;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pro4tech.modelo.Titulo;

import jakarta.validation.OverridesAttribute.List;


@Repository
public interface RepositorioTitulo extends JpaRepository<Titulo, Long>{

    // @Query("select * from pro4tech.titulo t inner join pro4tech.cliente c on c.id_cliente = t.id_cliente")
    // Titulo selectAllTitulos();
}