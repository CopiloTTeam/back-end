package com.pro4tech.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro4tech.modelo.Cliente;


    
@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, Long>{
    Optional<Cliente> findByCpf(String cpf);

    Optional<Cliente> deletebyCpf(String cpf);

}