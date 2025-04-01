package com.bertan.agenda_telefonica.controller;

import com.bertan.agenda_telefonica.model.Contato;
import com.bertan.agenda_telefonica.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @PostMapping
    public Contato adicionarContato(@RequestBody Contato contato) {
        return contatoRepository.save(contato);
    }

    @GetMapping
    public List<Contato> listarContatos() {
        return contatoRepository.findAll();
    }
}
