package com.pro4tech.repositorio;

import java.util.Optional;

// import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro4tech.modelo.Funcionario;


    
@Repository
public interface RepositorioFuncionario extends JpaRepository<Funcionario, Long>{

    Optional<Funcionario> findByEmailAndSenha(String email, String senha);
   
}