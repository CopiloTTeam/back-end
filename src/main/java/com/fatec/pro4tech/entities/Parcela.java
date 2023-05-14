package com.fatec.pro4tech.entities;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Parcelas")
@Data
@Getter
@Setter
@JsonIgnoreProperties
public class Parcela {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_parcela;

    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
    
    @Column
    private String data_vencimento;

    @Column
    private Date data_pagamento;

    @Column
    private Date data_credito;

    @Column
    private Boolean status;

    @Column
    private String valor;

    @Column
    private String valor_pago;

    @Column
	private String codigo_barra;

	@Column
	private String qr_code;

	@Column
	private String numero_boleto;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "tituloId")
    @JsonBackReference
    private Titulo titulo;
}
