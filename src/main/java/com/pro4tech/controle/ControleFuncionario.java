package com.pro4tech.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pro4tech.modelo.Funcionario;
import com.pro4tech.repositorio.RepositorioFuncionario;

@RestController
public class ControleFuncionario {

    private final PasswordEncoder encoder;

    public ControleFuncionario(PasswordEncoder encoder) {
        this.encoder = encoder;
    }
    @Autowired
    private RepositorioFuncionario repositorio;

    @PostMapping("/funcionarios/cadastrar")
    public ResponseEntity<?> cadastrarFuncionario(@RequestBody Funcionario funcionario) {
        try {
            // Verifica se já existe algum funcionário com o mesmo CPF cadastrado
            if (repositorio.findByCpf(funcionario.getCpf()).isPresent()) {
                return new ResponseEntity<>("Já existe um funcionário com o mesmo CPF cadastrado",
                        HttpStatus.BAD_REQUEST);
            }
            funcionario.setSenha(encoder.encode(funcionario.getSenha()));
            var funcionarioSalvo = repositorio.save(funcionario);
            return new ResponseEntity<>(funcionarioSalvo, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(
                    "Ocorreu um erro ao cadastrar o funcionário. Verifique se os dados estão corretos.",
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar/funcionario")
    public ResponseEntity<?> listarFuncionarios(Model model) {
        try {
            var consulta = repositorio.findAll();
            return new ResponseEntity<>(consulta, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocorreu um erro ao listar os funcionários: " + e.getMessage());
        }
    }

    @GetMapping("/listar/funcionario/{id}")
    public ResponseEntity<?> listarFuncionarioPorId(@PathVariable Long id) {
        try {
            var consulta = repositorio.findById(id);
            if (consulta.isPresent()) {
                return new ResponseEntity<>(consulta.get(), HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Funcionário não encontrado com o ID informado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocorreu um erro ao listar o funcionário: " + e.getMessage());
        }
    }

    @PutMapping("/atualizar/funcionario/{id}")
    public ResponseEntity<?> atualizarFuncionario(@PathVariable("id") long id, @RequestBody Funcionario funcionario) {
        try {
            var consulta = repositorio.findById(id);
            if (consulta.isPresent()) {
                Funcionario funcionarioAtualizado = consulta.get();
                if (funcionario.getCpf() != null) {
                    Optional<Funcionario> funcionarioComMesmoCpf = repositorio.findByCpfAndIdNot(funcionario.getCpf(),
                            id);
                    if (funcionarioComMesmoCpf.isPresent()) {
                        return ResponseEntity.status(HttpStatus.CONFLICT)
                                .body("Não é possível atualizar o funcionário devido a uma entrada duplicada.");
                    } else {
                        funcionarioAtualizado.setCpf(funcionario.getCpf());
                    }
                }
                if (funcionario.getNome() != null) {
                    funcionarioAtualizado.setNome(funcionario.getNome());
                }
                if (funcionario.getCargo() != null) {
                    funcionarioAtualizado.setCargo(funcionario.getCargo());
                }
                if (funcionario.getEmail() != null) {
                    funcionarioAtualizado.setEmail(funcionario.getEmail());
                }
                if (funcionario.getSenha() != null) {
                    funcionarioAtualizado.setSenha(encoder.encode(funcionario.getSenha()));
                }
                Funcionario funcionarioSalvo = repositorio.save(funcionarioAtualizado);
                return new ResponseEntity<>(funcionarioSalvo, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Funcionário não encontrado com o ID informado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocorreu um erro ao atualizar o funcionário: " + e.getMessage());
        }
    }

    @PutMapping("/atualizar/funcionarioc/{cpf}")
    public ResponseEntity<?> atualizarFuncionarioc(@PathVariable("cpf") String cpf, @RequestBody Funcionario funcionario) {
        try {
            var consulta = repositorio.findByCpf(cpf);
            if (consulta.isPresent()) {
                Funcionario funcionarioAtualizado = consulta.get();
                if (funcionario.getCpf() != null) {
                    Optional<Funcionario> funcionarioComMesmoCpf = repositorio.findByCpf(funcionario.getCpf());
                    if (funcionarioComMesmoCpf.isPresent()) {
                        return ResponseEntity.status(HttpStatus.CONFLICT)
                                .body("Não é possível atualizar o funcionário devido a uma entrada duplicada.");
                    } else {
                        funcionarioAtualizado.setCpf(funcionario.getCpf());
                    }
                }
                if (funcionario.getNome() != null) {
                    funcionarioAtualizado.setNome(funcionario.getNome());
                }
                if (funcionario.getCargo() != null) {
                    funcionarioAtualizado.setCargo(funcionario.getCargo());
                }
                if (funcionario.getEmail() != null) {
                    funcionarioAtualizado.setEmail(funcionario.getEmail());
                }
                if (funcionario.getSenha() != null) {
                    funcionarioAtualizado.setSenha(encoder.encode(funcionario.getSenha()));
                }
                Funcionario funcionarioSalvo = repositorio.save(funcionarioAtualizado);
                return new ResponseEntity<>(funcionarioSalvo, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Funcionário não encontrado com o ID informado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocorreu um erro ao atualizar o funcionário: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletar/funcionario/{cpf}")
    public ResponseEntity<String> deletarFuncionario(@PathVariable("cpf") String cpf) {
        try {
            var consulta = repositorio.findByCpf(cpf);
            if (consulta.isPresent()) {
                repositorio.delete(consulta.get());
                return ResponseEntity.ok("Funcionário deletado com sucesso.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Funcionário não encontrado com o ID informado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocorreu um erro ao deletar o funcionário: " + e.getMessage());
        }
    }

}