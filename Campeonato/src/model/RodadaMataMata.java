package model;

import java.util.ArrayList;
import java.util.List;

public class RodadaMataMata {

    private String fase;
    private List<Partida> rodadaMataMata;

    public RodadaMataMata(String fase, List<Partida> rodadaMataMata) {
        this.setFase(fase);
        this.rodadaMataMata = rodadaMataMata;
    }

    public RodadaMataMata() {
        this.rodadaMataMata = new ArrayList<>();
    }

    public void adicionarPartida(Partida partida) {
        if (rodadaMataMata != null) {
            this.rodadaMataMata.add(partida);
        }
    }

    public List<Time> obterVencedores() {
        List<Time> vencedores = new ArrayList<>();

        for (Partida partida : rodadaMataMata) {
            Time vencedor = partida.getVencedor();
            if (vencedor != null) {
                vencedores.add(vencedor);
            } else {
                return null;
            }
        }

        return vencedores;
    }

    public void definirFase() {
        int numPartidas = rodadaMataMata.size();

        switch (numPartidas) {
            case 1:
                setFase("Final");
                break;
            case 2:
                setFase("Semifinal");
                break;
            case 4:
                setFase("Quartas de Final");
                break;
            case 8:
                setFase("Oitavas de Final");
                break;
            default:
                if (numPartidas > 8) {
                    setFase(numPartidas + " avos de Final");
                } else {
                    setFase("Rodada Desconhecida");
                }
                break;
        }
    }

    public boolean todasPartidasFinalizadas() {
        if (rodadaMataMata != null) {
            for (Partida partida : rodadaMataMata) {
                if (!partida.getFinalizada()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void imprimirRodadaMataMata() {
        if (rodadaMataMata != null) {
            for (Partida partida : rodadaMataMata) {
                partida.imprimirPartida();
                System.out.println("=======================");
            }
        }
    }

    public List<Partida> getRodadaMataMata() {
        return rodadaMataMata;
    }

    public void setRodadaMataMata(List<Partida> rodadaMataMata) {
        this.rodadaMataMata = rodadaMataMata;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }
}
