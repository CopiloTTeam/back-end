package com.fatec.pro4tech.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.pro4tech.entities.Cliente;


    
public interface RepositorioCliente extends JpaRepository<Cliente, Long>{
   Optional<Cliente> findByCpf(String cpf);
   
void deleteByCpf(String cpf);

}