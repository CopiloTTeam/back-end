package com.pro4tech.modelo;

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
import jakarta.persistence.OneToOne;

@Entity
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

	@OneToMany(mappedBy = "titulo", fetch = FetchType.EAGER)
	private List<Parcela> parcela;

	public Long getId_titulo() {
		return this.id_titulo;
	}

	public void setId_titulo(Long id_titulo) {
		this.id_titulo = id_titulo;
	}

	public String getcpf_cliente() {
		return this.cliente.getCpf();
	}

	public void setcpf_cliente(String cpf) {
		this.cliente.setCpf(cpf);
	}

	public String getcpf_funcionario() {
		return this.cliente.getCpf();
	}

	public void setcpf_funcionario(String cpf) {
		this.cliente.setCpf(cpf);
	}

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
