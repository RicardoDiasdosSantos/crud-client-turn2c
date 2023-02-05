package com.ricardodev.cadastroendereco.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cliente", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}) })
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
}
