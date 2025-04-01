package com.bertan.agenda_telefonica.controller;

import com.bertan.agenda_telefonica.model.Contato;
import com.bertan.agenda_telefonica.repository.ContatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{nome}")
    @Transactional
    public ResponseEntity<String> deleteContato(@PathVariable String nome) {
        if (contatoRepository.existsByNome(nome)) {
            contatoRepository.deleteByNome(nome);
            return ResponseEntity.ok("Contato " + nome + " removido com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato " + nome + " não encontrado.");
        }
    }
}
