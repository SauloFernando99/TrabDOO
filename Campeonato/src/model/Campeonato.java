package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Campeonato {

    private Integer idCampeonato;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String modalidade;
    private String premiacao;
    private String patrocinio;
    private Boolean concluido;
    private List<Time> times;

    public Campeonato(Integer idCampeonato, LocalDate dataInicio, LocalDate dataFim, String modalidade,
                      String premiacao, String patrocinio, Boolean concluido, List<Time> times) {
        this.idCampeonato = idCampeonato;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.modalidade = modalidade;
        this.premiacao = premiacao;
        this.patrocinio = patrocinio;
        this.concluido = concluido;
        this.times = times;
    }

    public Campeonato(List<Time> times) {
    }

    public Integer getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(Integer idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getPremiacao() {
        return premiacao;
    }

    public void setPremiacao(String premiacao) {
        this.premiacao = premiacao;
    }

    public String getPatrocinio() {
        return patrocinio;
    }

    public void setPatrocinio(String patrocinio) {
        this.patrocinio = patrocinio;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }
}
