package com.fatec.pro4tech.models;

import java.sql.Date;

public record TituloModel(
    String id, 
    String cliente_cpf , 
    String funcionario_cpf,
    Date data_geracao,
    String data_credito , 
    String numero_boleto, 
    String qr_code , 
    String nome_produto,
    String valor,
    String codigo_barra , 
    String data_vencimento , 
    String data_pagamento ,  
    Boolean status , 
    String valor_pago) { 

}