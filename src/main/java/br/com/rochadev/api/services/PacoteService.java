package br.com.rochadev.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.rochadev.api.models.PacoteModel;
import br.com.rochadev.api.repositories.PacoteRepository;

@Service
public class PacoteService {
  private final PacoteRepository pacoteRepository;

  public PacoteService(PacoteRepository pacoteRepository) {
    this.pacoteRepository = pacoteRepository;
  }

  public List<PacoteModel> getAllPacotes() {
    return pacoteRepository.findAll();
  }

  public List<PacoteModel> getPacoteByDestino(String destino) {
    return pacoteRepository.findAllByDestino(destino);

  }

  public PacoteModel createPacote(PacoteModel newPacote) {
    PacoteModel pacote = new PacoteModel();
    pacote.setDestino(newPacote.getDestino());
    pacote.setPreco(newPacote.getPreco());
    pacote.setUrlImg(newPacote.getUrlImg());
    pacote.setDataIda(newPacote.getDataIda());
    pacote.setDataVolta(newPacote.getDataVolta());

    return pacoteRepository.save(pacote);
  }
}
