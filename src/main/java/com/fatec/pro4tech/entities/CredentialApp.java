package com.fatec.pro4tech.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import com.fatec.pro4tech.security.roles.roles;


@Entity
@Data
public class CredentialApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false, unique = true)
	private String userName;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<roles> roles = new ArrayList<>();
}
