package com.pro4tech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pro4tech.repositorio.RepositorioFuncionario;

@Service
public class authService implements UserDetailsService {
    @Autowired
	private RepositorioFuncionario repositorioUsuario;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repositorioUsuario.findByEmaill(username);
	}
}
