package com.pro4tech.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pro4tech.modelo.Funcionario;

@Repository
public interface RepositorioFuncionario extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByEmailAndSenha(String email, String senha);

    Optional<Funcionario> findByEmail(String email);

    @Query("SELECT f FROM Funcionario f WHERE f.email = :email")
    Funcionario findByEmaill(@Param("email") String email);

    Optional<Funcionario> findByCpfAndIdNot(String cpf, Long id);

    Optional<Funcionario> findByCpf(String cpf);

}