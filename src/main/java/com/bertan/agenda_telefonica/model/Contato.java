package com.bertan.agenda_telefonica.model;

import jakarta.persistence.*;

@Entity
@Table(name = "agenda-telefonica")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;

    public Contato() {}

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
}
