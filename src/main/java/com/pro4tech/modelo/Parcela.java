package com.pro4tech.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Parcela {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_parcela;

    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_titulo", referencedColumnName = "id_titulo")
    private Titulo titulo;

    @OneToOne(cascade = CascadeType.ALL)
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


    public Long getId_parcela() {
        return this.id_parcela;
    }

    public void setId_parcela(Long id_parcela) {
        this.id_parcela = id_parcela;
    }

    public Long getId_titulo() {
        return this.titulo.getId_titulo();
    }

    public void setId_titulo(Long id_titulo) {
        this.titulo.setId_titulo(id_titulo);
    }

    public String getcpf_cliente() {
        return this.cliente.getCpf();
    }

    public void setcpf_cliente(String cpf) {
        this.cliente.setCpf(cpf);
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

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValor_pago() {
        return this.valor_pago;
    }

    public void setValor_pago(Double valor_pago) {
        this.valor_pago = valor_pago;
    }

}
