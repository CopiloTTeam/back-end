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
	private Long cpf_funcionario;

	@Column()
	private String cpf_cliente;

	@Column
	private String data_geracao;

	@Column
	private String valor;

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

	public Long getCpf_funcionario() {
		return this.cpf_funcionario;
	}

	public void setCpf_funcionario(Long cpf_funcionario) {
		this.cpf_funcionario = cpf_funcionario;
	}

	public String getData_geracao() {
		return this.data_geracao;
	}

	public void setData_geracao(String data_geracao) {
		this.data_geracao = data_geracao;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
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

	public String getNome_produto() {
		return this.nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public String getCpf_cliente() {
		return this.cpf_cliente;
	}
	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}


}
