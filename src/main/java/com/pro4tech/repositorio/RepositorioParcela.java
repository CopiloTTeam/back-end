package com.pro4tech.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro4tech.modelo.Parcela;

@Repository
public interface RepositorioParcela extends JpaRepository<Parcela, Long>{
    
}
