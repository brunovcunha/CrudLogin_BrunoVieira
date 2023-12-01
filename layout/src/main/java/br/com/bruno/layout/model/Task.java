package br.com.bruno.layout.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Task {

  public Task(Long id, String nome, String cargo, Date data_contratacao) {
    this.id = id;
    this.nome = nome;
    this.cargo = cargo;
    this.data_contratacao = data_contratacao;
  }

  public Task() {
  }

  private Long id;
  private String nome;
  private String cargo;

  @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private Date data_contratacao;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public String getCargo() {
    return cargo;
  }

  public void setData_contratacao(Date data_contratacao) {
    this.data_contratacao = data_contratacao;
  }

  public Date getData_contratacao() {
    return data_contratacao;
  }
}
