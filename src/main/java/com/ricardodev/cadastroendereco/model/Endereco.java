
package com.ricardodev.cadastroendereco.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;
    private String bairro;
    private String logradouro;
    private String cep;
    private int numero;
    private String cidade;
    private  String uf;

}
