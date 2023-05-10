package com.fatec.pro4tech.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Parcela> parcelas;


}
