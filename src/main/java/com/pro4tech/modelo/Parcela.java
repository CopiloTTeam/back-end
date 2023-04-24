package com.pro4tech.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Parcela {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_parcela;

    @Column
    private Long id_titulo;

    @Column
    private String cpf;
    
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


    public Long getId_parcela() {
        return this.id_parcela;
    }

    public void setId_parcela(Long id_parcela) {
        this.id_parcela = id_parcela;
    }

    public Long getId_titulo() {
        return this.id_titulo;
    }

    public void setId_titulo(Long id_titulo) {
        this.id_titulo = id_titulo;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_vencimento() {
        return this.data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public String getData_pagamento() {
        return this.data_pagamento;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public String getData_credito() {
        return this.data_credito;
    }

    public void setData_credito(String data_credito) {
        this.data_credito = data_credito;
    }

    public Boolean isStatus() {
        return this.status;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor_pago() {
        return this.valor_pago;
    }

    public void setValor_pago(String valor_pago) {
        this.valor_pago = valor_pago;
    }

}
