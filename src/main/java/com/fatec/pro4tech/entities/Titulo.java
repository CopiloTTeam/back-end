package com.fatec.pro4tech.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Titulo {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_titulo;

	@Column
	private Integer parcelas;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cpf_funcionario", nullable = false, referencedColumnName = "cpf")
	private Funcionario funcionario;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cpf_cliente", nullable = false, referencedColumnName = "cpf")
	private Cliente cliente;

	@Column
	private String data_geracao;

	@Column
	private Float valor;

	@Column
	private String codigo_barra;

	@Column
	private String qr_code;

	@Column
	private String numero_boleto;

	@Column
	private String nome_produto;

	@OneToMany(orphanRemoval = true, mappedBy = "titulo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Parcela> parcela;
}
