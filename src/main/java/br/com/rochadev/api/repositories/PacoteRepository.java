package br.com.rochadev.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rochadev.api.models.PacoteModel;
import java.util.List;

public interface PacoteRepository extends JpaRepository<PacoteModel, Long> {
  public List<PacoteModel> findAllByDestino(String destino);
}
