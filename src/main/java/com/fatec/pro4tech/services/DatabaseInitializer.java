package com.fatec.pro4tech.services;

import org.springframework.stereotype.Service;

import com.fatec.pro4tech.entities.CredentialApp;
import com.fatec.pro4tech.entities.Funcionario;
import com.fatec.pro4tech.repository.RepositorioFuncionario;
import com.fatec.pro4tech.security.roles.roles;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class DatabaseInitializer {
    @Autowired
	private RepositorioFuncionario repository;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public void initializeDatabase() {

        List<Funcionario> temFuncionario = repository.findAll();
        if (temFuncionario.isEmpty()){
            Funcionario root = new Funcionario();
            root.setCpf("39936747828");
            root.setNome("Guilherme Duarte Cenzi Dias");
            root.setRegistration(Calendar.getInstance().getTime());
    
            CredentialApp credencial = new CredentialApp();
            String password = encoder.encode("102030@@");
            credencial.setPassword(password);
            credencial.setUserName("admin@copilotteam.com");
            credencial.getRoles().add(roles.Administrador);
            root.setCredential(credencial);
    
            repository.save(root);
        }

		
	}
}
