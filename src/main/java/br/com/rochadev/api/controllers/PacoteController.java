package br.com.rochadev.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rochadev.api.models.PacoteModel;
import br.com.rochadev.api.services.PacoteService;
import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/pacotes")
public class PacoteController {
  private final PacoteService service;

  public PacoteController(PacoteService service) {
    this.service = service;
  }

  @GetMapping

  public ResponseEntity<List<PacoteModel>> getAllPacotes() {
    var PacotesList = service.getAllPacotes();
    return ResponseEntity.ok().body(PacotesList);
  }

  @GetMapping("/{destino}")
  public ResponseEntity<List<PacoteModel>> getPacoteByDestino(@PathVariable("destino") String destino) {
    var pacote = service.getPacoteByDestino(destino);
    return ResponseEntity.ok().body(pacote);
  }

  @PostMapping
  public ResponseEntity<PacoteModel> createPacote(@Valid @RequestBody PacoteModel pacote) {
    var newPacote = service.createPacote(pacote);
    return ResponseEntity.status(HttpStatus.CREATED).body(newPacote);
  }

}
