package com.bertan.agenda_telefonica.repository;

import com.bertan.agenda_telefonica.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
    Contato findByNome(String nome);
    Contato findByTelefone(String telefone);
    boolean existsByNome(String nome);
    void deleteByNome(String nome);

    boolean existsById(UUID uuid);
    void deleteById(UUID uuid);
}

