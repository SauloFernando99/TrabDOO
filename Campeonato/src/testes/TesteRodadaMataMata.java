package testes;

import model.Partida;
import model.RodadaMataMata;
import model.Time;

import java.util.ArrayList;
import java.util.List;

public class TesteRodadaMataMata {

    public static void main(String[] args) {
        // Criar instâncias de Time
        Time time1 = new Time(0, "IFSP", "Marcolinha", true);
        Time time2 = new Time(1, "USP", "Porco", true);
        Time time3 = new Time(2, "UFSCAR", "Porco", true);
        Time time4 = new Time(3, "UNIARA", "Porco", true);

        // Criar instâncias de Partida
        Partida partida1 = new Partida(1, 2, 1, time1, time2);
        Partida partida2 = new Partida(2, 3, 2, time3, time4);

        // Criar instância de RodadaMataMata
        RodadaMataMata rodada = new RodadaMataMata();
        rodada.adicionarPartida(partida1);
        rodada.adicionarPartida(partida2);

        // Imprimir informações da rodada
        System.out.println("Informações da Rodada Mata-Mata:");
        rodada.imprimirRodadaMataMata();

        // Obter vencedores
        List<Time> vencedores = rodada.obterVencedores();
        if (vencedores != null) {
            System.out.println("\nVencedores da Rodada:");
            for (Time vencedor : vencedores) {
                System.out.println(vencedor.getNome());
            }
        }

        // Testar a definição da fase
        rodada.definirFase();
        System.out.println("\nFase da Rodada: " + rodada.getFase());

    }
}

