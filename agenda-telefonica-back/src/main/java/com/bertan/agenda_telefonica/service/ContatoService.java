package com.bertan.agenda_telefonica.service;

import com.bertan.agenda_telefonica.repository.ContatoRepository;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

}
