package com.pro4tech.services;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.pro4tech.modelo.Funcionario;

@Service
public class tokenService {

    public String gerarToken(Funcionario usuario) {
		return JWT.create().withIssuer("").withSubject(usuario.getUsername()).withClaim("id", usuario.getId_funcionario())
				.withExpiresAt(LocalDateTime.now().plusMinutes(2).toInstant(ZoneOffset.of("-03:00"))
        ).sign(Algorithm.HMAC256("chavesecreta"));
	}
	
	public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("chavesecreta"))
                .withIssuer("")
                .build().verify(token).getSubject();

    }
}
