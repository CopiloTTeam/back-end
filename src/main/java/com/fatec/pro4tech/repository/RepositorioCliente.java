package com.fatec.pro4tech.repository;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fatec.pro4tech.entities.Cliente;


    
public interface RepositorioCliente extends JpaRepository<Cliente, Long>{
   Cliente findByCpf(String cpf);
   
    @Query("DELETE FROM Cliente c WHERE c.cpf = :cpf")
    Cliente deleteByCpf(@Param("cpf") String cpf);

}