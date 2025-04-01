package com.bertan.agenda_telefonica.service;

import com.bertan.agenda_telefonica.model.Contato;
import com.bertan.agenda_telefonica.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }
    public List<Contato> listarContatos() {
        return contatoRepository.findAll();
    }
    public void adicionarContato(Contato contato) {
        contatoRepository.save(contato);
    }
    public boolean removerContato(String nome) {
        Contato contato = contatoRepository.findByNome(nome);
        if (contato != null) {
            contatoRepository.delete(contato);
            return true;
        }
        return false;
    }

}
