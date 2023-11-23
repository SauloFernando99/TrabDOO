package model;

import java.time.LocalDate;

public class Partida {

    private Integer idPartida;
    private LocalDate data;
    private Integer placar1;
    private Integer placar2;
    private Time time1;
    private Time time2;
    private Boolean finalizada;

    public Partida(Integer idPartida, Integer placar1, Integer placar2, Time time1, Time time2) {
        this.idPartida = idPartida;
        this.placar1 = placar1;
        this.placar2 = placar2;
        this.time1 = time1;
        this.time2 = time2;
        this.setFinalizada(false);
    }

    public Partida(Time time1, Time time2) {
        this.time1 = time1;
        this.time2 = time2;
        this.setFinalizada(false);
    }

    public void atualizarPartida(Integer idPartida, Integer placar1, Integer placar2){
        this.placar1 = placar1;
        this.placar2 = placar2;
    }
    public void registrarResultado(Integer golsTimeA, Integer golsTimeB) {
        this.placar1 = golsTimeA;
        this.placar2 = golsTimeB;
    }

    public Time getVencedor() {
        if (placar1 > placar2) {
            return time1;
        } else if (placar2 > placar1) {
            return time2;
        } else {
            return null;
        }
    }

    public void finalizarPartida() {
        if (finalizada) {
            System.out.println("A partida já foi finalizada.");
            return;
        }
        this.finalizada = true;
    }

    public void imprimirPartida() {
        System.out.println("ID da Partida: " + idPartida);
        System.out.println(time1.getNome() + " vs. " + time2.getNome());
        System.out.println("Placar: " + placar1 + " - " + placar2);
    }

    public void atualizarPontuacao(Partida partida, int golsTimeA, int golsTimeB) {
        Time timeA = partida.getTime1();
        Time timeB = partida.getTime2();

        if (golsTimeA > golsTimeB) {
            timeA.setPontos(+3);
            timeA.setVitorias(+1);
            timeA.setSaldoGols(+ (golsTimeA - golsTimeB));

            timeB.setDerrotas(+1);
            timeB.setSaldoGols(+(golsTimeB - golsTimeA));
        } else if (golsTimeA < golsTimeB) {
            timeB.setPontos(+3);
            timeB.setVitorias(+1);
            timeB.setSaldoGols(+(golsTimeB - golsTimeA));

            timeA.setDerrotas(+1);
            timeA.setSaldoGols(+(golsTimeA - golsTimeB));
        } else {
            timeA.setPontos(+1);
            timeA.setEmpate(+1);
            timeA.setSaldoGols(+(golsTimeA - golsTimeB));

            timeB.setPontos(+1);
            timeB.setEmpate(+1);
            timeB.setSaldoGols(+(golsTimeB - golsTimeA));
        }
    }


    public Integer getPIdPartida() {
        return idPartida;
    }

    public void setPIdPartida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public Integer getPlacar1() {
        return placar1;
    }

    public void setPlacar1(Integer placar1) {
        this.placar1 = placar1;
    }

    public Integer getPlacar2() {
        return placar2;
    }

    public void setPlacar2(Integer placar2) {
        this.placar2 = placar2;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    public Boolean getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }
}
