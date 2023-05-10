package com.fatec.pro4tech.entities;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Titulos")
@Data
@Getter
@Setter
public class Titulo {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_titulo;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Funcionario funcionario;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Cliente cliente;

	@Column
	private LocalDateTime data_geracao; 

	@Column
	private String valor;

	@Column 
	private String nome_produto;
	
	@OneToOne(orphanRemoval = true, mappedBy = "titulo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Parcela parcela;

    public Object getCredential() {
        return null;
    }

    public String getId() {
        return null;
    }
}
