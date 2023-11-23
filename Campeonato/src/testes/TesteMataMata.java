package testes;

import model.MataMata;
import model.Partida;
import model.RodadaMataMata;
import model.Time;

import java.time.LocalDate;
import java.util.List;

public class TesteMataMata {

    public static void main(String[] args) {
        // Criar instâncias de Time
        Time time1 = new Time(0, "IFSP", "Marcolinha", true);
        Time time2 = new Time(1, "USP", "Porco", true);
        Time time3 = new Time(2, "UFSCAR", "Porco", true);
        Time time4 = new Time(3, "UNIARA", "Porco", true);

        // Criar instância de MataMata
        MataMata mataMata = new MataMata(1, LocalDate.now(), LocalDate.now().plusDays(10),
                "Futebol", "Troféu", "Patrocinador", false, List.of(time1, time2, time3, time4));

        //Sortear times
        mataMata.sortearTimes();

        // Iniciar o mata-mata
        mataMata.iniciarMataMata(mataMata.getTimes());

        // Simular resultados e avançar para a próxima rodada
        simularResultados(mataMata);

        // Avançar para a próxima rodada
        mataMata.proximaRodada();

        // Simular resultados e avançar para a próxima rodada
        simularResultados(mataMata);

        // Imprimir novo chaveamento
        mataMata.imprimirChaveamentoMataMata();

        // Encerrar o mata-mata
        mataMata.encerrarMataMata();
    }

    private static void simularResultados(MataMata mataMata) {
        if (mataMata.getChaveamento().isEmpty()) {
            System.out.println("Não há rodada para simular resultados.");
            return;
        }

        RodadaMataMata ultimaRodada = mataMata.getChaveamento().get(mataMata.getChaveamento().size() - 1);

        // Simular resultados
        for (Partida partida : ultimaRodada.getRodadaMataMata()) {
            // Simular resultados da partida
            int golsTime1 = 1;
            int golsTime2 = 2;

            partida.registrarResultado(golsTime1, golsTime2);
            partida.finalizarPartida();
        }
    }
}
