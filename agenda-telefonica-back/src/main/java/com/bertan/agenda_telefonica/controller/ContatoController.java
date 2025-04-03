package com.bertan.agenda_telefonica.controller;

import com.bertan.agenda_telefonica.model.Contato;
import com.bertan.agenda_telefonica.repository.ContatoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @PostMapping
    public Contato adicionarContato(@Valid @RequestBody Contato contato) {
        return contatoRepository.save(contato);
    }

    @GetMapping
    public List<Contato> listarContatos() {
        return contatoRepository.findAll();
    }

    @DeleteMapping("/{uuid}")
    @Transactional
    public ResponseEntity<String> deleteContato(@PathVariable UUID uuid) {
        if (contatoRepository.existsById(uuid)) {
            contatoRepository.deleteById(uuid);
            return ResponseEntity.ok("Contato com UUID " + uuid + " removido com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato com UUID " + uuid + " não encontrado.");
        }
    }
}
