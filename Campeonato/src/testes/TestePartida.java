package testes;

import model.Partida;
import model.Time;

public class TestePartida {

    public static void main(String[] args) {
        // Criar instâncias de Time
        Time time1 = new Time(0, "IFSP", "Marcolinha", true);
        Time time2 = new Time(1, "USP", "Porco", true);

        // Criar instâncias de Partida
        Partida partida1 = new Partida(1, 2, 1, time1, time2);
        Partida partida2 = new Partida(time1, time2);

        // Imprimir informações iniciais
        System.out.println("Informações da Partida 1:");
        partida1.imprimirPartida();
        System.out.println();

        System.out.println("Informações da Partida 2 (sem placar):");
        partida2.imprimirPartida();
        System.out.println();

        // Atualizar e registrar resultados
        partida2.atualizarPartida(2, 2, 1);
        partida2.registrarResultado(3, 2);

        // Imprimir informações atualizadas
        System.out.println("Informações da Partida 2 (após atualização e registro de resultado):");
        partida2.imprimirPartida();
        System.out.println();

        // Testar método getVencedor
        Time vencedorPartida2 = partida2.getVencedor();
        System.out.println("Vencedor da Partida 2: " + (vencedorPartida2 != null ? vencedorPartida2.getNome() : "Empate"));
    }
}
