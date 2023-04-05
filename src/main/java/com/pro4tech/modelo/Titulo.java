package com.pro4tech.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Titulo {

	// public final String cpf = null;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_titulo;

	@Column
	private Integer parcelas;

	@Column()
	private Long id_funcionario;

	@Column()
	private String cpf;

	@Column
	private String data_geracao;

	@Column
	private Float valor;

	@Column
	private String codigo_barra;

	// @Column
	// private String qr_code;

	// @Column
	// private String numero_boleto;

	@Column
	private String nome_produto;


	public Long getId_titulo() {
		return this.id_titulo;
	}

	public void setId_titulo(Long id_titulo) {
		this.id_titulo = id_titulo;
	}

	public Long getId_funcionario() {
		return this.id_funcionario;
	}

	public void setId_funcionario(Long id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	// public Long getId() {
	// 	return this.id;
	// }

	// public void setId(Long id) {
	// 	this.id = id;
	// }

	public String getData_geracao() {
		return this.data_geracao;
	}

	public void setData_geracao(String data_geracao) {
		this.data_geracao = data_geracao;
	}

	public Float getValor() {
		return this.valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getCodigo_barra() {
		return this.codigo_barra;
	}

	public void setCodigo_barra(String codigo_barra) {
		this.codigo_barra = codigo_barra;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public Integer getParcelas() {
		return this.parcelas;
	}

	// public String getQr_code() {
	// 	return this.qr_code;
	// }

	// public void setQr_code(String qr_code) {
	// 	this.qr_code = qr_code;
	// }

	// public String getNumero_boleto() {
	// 	return this.numero_boleto;
	// }

	// public void setNumero_boleto(String numero_boleto) {
	// 	this.numero_boleto = numero_boleto;
	// }

	public String getNome_produto() {
		return this.nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


}
