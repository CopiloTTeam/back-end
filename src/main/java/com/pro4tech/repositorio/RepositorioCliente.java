package com.pro4tech.repositorio;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pro4tech.modelo.Cliente;


    
@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, Long>{
    Optional<Cliente> findByCpf(String cpf);

    @Query("DELETE FROM Cliente c WHERE c.cpf = :cpf")
    Optional<Cliente> deleteByCpf(@Param("cpf") String cpf);

}