package com.bertan.agenda_telefonica.repository;

import com.bertan.agenda_telefonica.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    Contato findByNome(String nome);
    Contato findByTelefone(String telefone);
}

