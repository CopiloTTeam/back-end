package com.fatec.pro4tech.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Parcela {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_parcela;

    @ManyToOne(cascade = CascadeType.ALL)
    private Titulo titulo;

    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;
    
    @Column
    private String data_vencimento;

    @Column
    private String data_pagamento;

    @Column
    private String data_credito;

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
}
