import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Time time1 = new Time(0, "IFSP", "Marcolinha", true);
        Time time2 = new Time(1, "USP", "Porco", true);
        Time time3 = new Time(2, "UFSCAR", "Porco", true);
        Time time4 = new Time(3, "UNIARA", "Porco", true);
        Time time5 = new Time(4, "UNICEP", "Porco", true);
        Time time6 = new Time(5, "SLA", "Porco", true);

        List<Time> times = new ArrayList<>();
        times.add(time1);
        times.add(time2);
        times.add(time3);
        times.add(time4);

        MataMata mataMata = new MataMata(times);


        LocalDate dataInicio = LocalDate.of(2023, 11, 1);
        LocalDate dataFim = LocalDate.of(2023, 12, 1);
        String modalidade = "Futebol";
        String premiacao = "Prêmio em dinheiro";
        String patrocinio = "Empresa X";
        boolean concluido = false;

        //----------------------------------PONTOS CORRIDOS -------------------------------------//
        System.out.println('\n');
        List<Time> timesPontosCorridos = new ArrayList<>();
        List<Rodada> tabela = new ArrayList<>();
        PontosCorridos pontosCorridos = new PontosCorridos(0, dataInicio, dataFim, modalidade, premiacao, patrocinio, concluido, timesPontosCorridos, tabela, 6);
        Time time1PT = new Time(0, "Galacticos", "Marcola da academia", true);
        pontosCorridos.addTime(time1PT);
        pontosCorridos.addTime(time1);
        pontosCorridos.addTime(time2);
        pontosCorridos.addTime(time3);
        pontosCorridos.addTime(time4);
        pontosCorridos.addTime(time5);
        pontosCorridos.mostrarTimes(pontosCorridos.getTimes());
        PontosCorridos.verificaQtdTimes(pontosCorridos.getTimes(), pontosCorridos.getQuantidadeTime());
        pontosCorridos.gerarRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.imprimirTabela();
        pontosCorridos.gerarRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.imprimirTabela();
        pontosCorridos.gerarRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.imprimirTabela();
        pontosCorridos.gerarRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.imprimirTabela();
        pontosCorridos.gerarRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.gerenciarPartidaDaUltimaRodada();
        pontosCorridos.mostrarTimesNaRodadaAtual();
        pontosCorridos.imprimirTabela();
        pontosCorridos.mostrarTabelaFinalECampeao();
    }
}

