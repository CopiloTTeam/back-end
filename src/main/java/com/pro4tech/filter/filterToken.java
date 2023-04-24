package com.pro4tech.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pro4tech.repositorio.RepositorioFuncionario;
import com.pro4tech.services.tokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class filterToken extends OncePerRequestFilter{
    @Autowired
    private tokenService servicoToken;

    @Autowired
    private RepositorioFuncionario repositorioUsuario;
	    
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		 String token;

	        var authorizationHeader = request.getHeader("Authorization");

	        if(authorizationHeader != null) {
	            token = authorizationHeader.replace("Bearer ", "");
	            var subject = this.servicoToken.getSubject(token);

	            var usuario = this.repositorioUsuario.findByEmaill(subject);

	            var authentication = new UsernamePasswordAuthenticationToken(usuario,
	                    null, usuario.getAuthorities());

	            SecurityContextHolder.getContext().setAuthentication(authentication);
	        }

	        filterChain.doFilter(request, response);
	}
}
