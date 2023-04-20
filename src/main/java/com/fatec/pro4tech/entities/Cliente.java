package com.fatec.pro4tech.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Clientes")
@Data
@Getter
@Setter
public class Cliente {

    @Id
    @Column(unique = true, nullable = false)
    private String cpf;
    
    @Column
    private String nome;

    @Column
    private String cep;

    @Column
    private String logradouro;

    @Column
    private String bairro;

    @Column
    private String cidade;

    @Column
    private String estado;

    @Column(nullable = false)
    private String email;

    @OneToMany(orphanRemoval = true, mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Parcela> parcelas;

    @OneToMany(orphanRemoval = true, mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Titulo> titulo;

}
