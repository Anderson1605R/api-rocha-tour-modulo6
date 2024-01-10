package br.com.rochadev.api.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity(name = "tb_pacotes")
public class PacoteModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  private String destino;

  @NotNull
  private double preco;

  @NotNull
  private String urlImg;

  @NotNull

  private LocalDate dataIda;

  @NotNull

  private LocalDate dataVolta;

  public long getId() {
    return id;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public String getUrlImg() {
    return urlImg;
  }

  public void setUrlImg(String urlImg) {
    this.urlImg = urlImg;
  }

  public LocalDate getDataIda() {
    return dataIda;
  }

  public void setDataIda(LocalDate dataIda) {
    this.dataIda = dataIda;
  }

  public LocalDate getDataVolta() {
    return dataVolta;
  }

  public void setDataVolta(LocalDate dataVolta) {
    this.dataVolta = dataVolta;
  }

}
