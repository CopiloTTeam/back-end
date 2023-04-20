package com.fatec.pro4tech.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@JoinColumn(name = "id_titulo", referencedColumnName = "id_titulo")
    private Titulo titulo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cpf_cliente", referencedColumnName = "cpf")
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
    private Double valor;

    @Column
    private Double valor_pago;
}
