package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rodada {

    private Integer idRodada;
    private LocalDate data;
    private List<Partida> partidas = new ArrayList<>();
    private Boolean finalizada;

    public Rodada(Integer idRodada, LocalDate data, List<Partida> partidas) {

        this.idRodada = idRodada;
        this.data = data;
        this.partidas = partidas;
        this.setFinalizada(false);
    }

    public void adicionarPartida(Partida partida) {
        this.partidas.add(partida);
    }

    public Integer getIdRodada() {
        return idRodada;
    }

    public void setIdRodada(Integer idRodada) {
        this.idRodada = idRodada;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    public Boolean getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }
}
