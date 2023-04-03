package com.pro4tech.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Titulo {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_titulo;

	@Column
	private Integer parcelas;

	@Column()
	private Long id_funcionario;

	@Column()
	private Long id_cliente;

	@Column
	private String data_geracao;

	@Column
	private String data_vencimento;

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


	public Long getId_titulo() {
		return this.id_titulo;
	}

	public void setId_titulo(Long id_titulo) {
		this.id_titulo = id_titulo;
	}

	public Integer getParcelas() {
		return this.parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public Long getId_funcionario() {
		return this.id_funcionario;
	}

	public void setId_funcionario(Long id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public Long getId_cliente() {
		return this.id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getData_geracao() {
		return this.data_geracao;
	}

	public void setData_geracao(String data_geracao) {
		this.data_geracao = data_geracao;
	}

	public String getData_vencimento() {
		return this.data_vencimento;
	}

	public void setData_vencimento(String data_vencimento) {
		this.data_vencimento = data_vencimento;
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

	public String getQr_code() {
		return this.qr_code;
	}

	public void setQr_code(String qr_code) {
		this.qr_code = qr_code;
	}

	public String getNumero_boleto() {
		return this.numero_boleto;
	}

	public void setNumero_boleto(String numero_boleto) {
		this.numero_boleto = numero_boleto;
	}

	public String getNome_produto() {
		return this.nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}


}
