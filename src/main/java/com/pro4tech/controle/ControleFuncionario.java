package com.pro4tech.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pro4tech.modelo.Funcionario;
import com.pro4tech.repositorio.RepositorioFuncionario;

@RestController
public class ControleFuncionario {

    @Autowired
    private RepositorioFuncionario repositorio;
    @Autowired
    private PasswordEncoder encoder;


    @PostMapping("/cadastrar/funcionario")
    public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody Funcionario funcionario) {
        funcionario.setSenha(encoder.encode(funcionario.getSenha()));
        return ResponseEntity.ok(repositorio.save(funcionario));
    }
    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String email,
                                                @RequestParam String senha){
        Optional<Funcionario> Optfunc = repositorio.findByEmail(email);
        if (Optfunc.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
        Funcionario funcionario = Optfunc.get();
        boolean valid = encoder.matches((senha), funcionario.getSenha());
        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }

//     @GetMapping("/listar/funcionarios")
//     public String listarFuncionarios(Model model) {
//         model.addAttribute("funcionarios", repositorio.findAll());
//         return "funcionario/listarFuncionarios";
//     }
//     // Pega token, se valido
//     // retorna lista, cod 202
//     // se não cod 401 - usuário não autenticado

//     @GetMapping("/atualizar/funcionario/{id}")
//     public String atualizarFuncionario(@PathVariable("id") long id, Model model) {
//         Funcionario funcionario = repositorio.findById(id).get();
//         model.addAttribute("funcionario", funcionario);
//         return "funcionario/atualizarFuncionario";
//     }
//     // Pega token, se valido
//     // retorna lista, cod 202
//     // se não cod 401 - usuário não autenticado

//     @PostMapping("/atualizar/funcionario/{id}")
//     public String atualizarFuncionario(@PathVariable("id") long id, @ModelAttribute Funcionario funcionario) {
//         Funcionario funcionarioAtualizado = repositorio.findById(funcionario.getId()).get();
//         funcionarioAtualizado.setNome(funcionario.getNome());
//         funcionarioAtualizado.setCpf(funcionario.getCpf());
//         funcionarioAtualizado.setCargo(funcionario.getCargo());
//         funcionarioAtualizado.setEmail(funcionario.getEmail());
//         funcionarioAtualizado.setSenha(funcionario.getSenha());
//         repositorio.save(funcionarioAtualizado);
//         return "redirect:/listar/funcionarios";
//     }

//     // Pega token, se valido
//     // retorna atualiza, cod 201
//     // se não cod 401 - usuário não autenticado

//     @GetMapping("/deletar/funcionario/{id}")
//     public String deletarFuncionario(@PathVariable("id") long id) {
//         Funcionario funcionario = repositorio.findById(id).get();
//         repositorio.delete(funcionario);
//         return "redirect:/listar/funcionarios";
//     }
//     // Pega token, se valido
//     // retorna nada, cod 201
//     // se não cod 401 - usuário não autenticado
}