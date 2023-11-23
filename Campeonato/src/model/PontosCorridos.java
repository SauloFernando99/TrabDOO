package model;

import java.time.LocalDate;
import java.util.*;

public class PontosCorridos extends Campeonato{
    private List<Rodada> tabela;
    private Integer quantidadeTime;
    private ArrayList<Time> times = new ArrayList<>();

    public PontosCorridos(Integer idCampeonato, LocalDate dataInicio, LocalDate dataFim, String modalidade,
                          String premiacao, String patrocinio, Boolean concluido,
                          List<Time> times, List<Rodada> tabela, Integer quantidadeTime) {
        super(idCampeonato, dataInicio, dataFim, modalidade, premiacao, patrocinio, concluido, times);
        this.tabela = tabela;
        if(quantidadeTime %2 == 0) {
            this.setQuantidadeTime(quantidadeTime);
        }
        else{
            throw new IllegalArgumentException("A quantidade de times deve ser um número par.");
        }
    }

    public void addRodada(Rodada rodada){tabela.add(rodada);}

    public void addTime(Time time){times.add(time);}

    public void mostrarTimes(List<Time> listaTimes){
        System.out.println("Times: ");
        for (Time time : listaTimes) {
            System.out.println("Nome do Time: " + time.getNome() + " ");
        }
    }
    public static boolean verificaQtdTimes(List<Time> listaTimes, Integer quantidadeTimes) {
        if (listaTimes.size() == quantidadeTimes) {
            System.out.println("A quantidade de times na lista é igual a " + quantidadeTimes);
            return true;
        } else {
            System.out.println("A quantidade de times na lista não é igual a " + quantidadeTimes);
            return false;
        }
    }

    public int getNumeroRodadas() {
        System.out.println(tabela.size());
        return tabela.size();
    }

    public int calcularMaximoRodadasSemRepeticao() {
        int quantidadeTimes = times.size();
        return quantidadeTimes - 1;
    }

    public void mostrarTabelaFinalECampeao() {
        if (tabela.isEmpty()) {
            System.out.println("Ainda não foram geradas rodadas.");
            return;
        }
        int maximoRodadas = calcularMaximoRodadasSemRepeticao();

        if (tabela.size() >= maximoRodadas) {
            Rodada ultimaRodada = tabela.get(maximoRodadas - 1);

            if (todasPartidasFinalizadasNaRodada(ultimaRodada)) {
                System.out.println("Tabela de Pontos Corridos:");
                imprimirTabela();
                // Encontre o campeão
                Time campeao = encontrarCampeao();
                if (campeao != null) {
                    System.out.println("O campeão do campeonato é: " + campeao.getNome());
                } else {
                    System.out.println("Não foi possível determinar o campeão.");
                }
            } else {
                System.out.println("A última rodada possível ainda não está finalizada.");
            }
        } else {
            System.out.println("Ainda não foi possível gerar a última rodada possível.");
        }
    }

    private Time encontrarCampeao() {
        if (times.isEmpty()) {
            return null;
        }

        // Ordenar a lista de times pelo número de pontos (descendente)
        times.sort(Comparator.comparing(Time::getPontos).reversed());

        Time campeao = times.get(0);
        for (Time time : times) {
            // Comparar por pontos, vitórias e saldo de gols
            if (time.getPontos().equals(campeao.getPontos())) {
                if (time.getVitorias().equals(campeao.getVitorias())) {
                    if (time.getSaldoGols() > campeao.getSaldoGols()) {
                        campeao = time;
                    }
                } else if (time.getVitorias() > campeao.getVitorias()) {
                    campeao = time;
                }
            } else {
                campeao = time;
            }
        }
        return campeao;
    }



    public void gerarRodada() {
        // Certifique-se de que a quantidade de times adicionados na lista seja igual a declarada na criação do campeonato
        if (verificaQtdTimes(this.getTimes(), this.getQuantidadeTime())) {
            // Verificar se a última rodada foi finalizada
            if (!tabela.isEmpty()) {
                Rodada ultimaRodada = tabela.get(tabela.size() - 1);
                if (!todasPartidasFinalizadasNaRodada(ultimaRodada)) {
                    System.out.println("A última rodada ainda não foi finalizada. Não é possível criar uma nova rodada.");
                    return;
                }
            }
            // Criar uma rodada
            Rodada rodada = new Rodada(tabela.size() + 1, LocalDate.now(), new ArrayList<>());

            // Copiar a lista de times para não modificar a original
            List<Time> timesCopia = new ArrayList<>(times);

            // Adicionar cada partida à rodada
            for (int i = 0; i < (quantidadeTime / 2); i++) {
                Collections.shuffle(timesCopia); // Embaralhar a lista para garantir partidas aleatórias

                Time time1 = timesCopia.get(0);
                Time time2 = timesCopia.get(1);

                // Verificar se os times são diferentes e não se enfrentaram anteriormente
                while (time1.equals(time2) || timesJaSeEnfrentaram(time1, time2)) {
                    Collections.shuffle(timesCopia);
                    time1 = timesCopia.get(0);
                    time2 = timesCopia.get(1);
                }

                // Criar a partida e adicioná-la à rodada
                Partida partida = new Partida(time1, time2);
                rodada.getPartidas().add(partida);

                // Remover os times utilizados da cópia
                timesCopia.remove(time1);
                timesCopia.remove(time2);
            }

            // Adicionar a rodada à tabela
            tabela.add(rodada);
        }
    }

    public boolean todasPartidasFinalizadasNaRodada(Rodada rodada) {
        List<Partida> partidas = rodada.getPartidas();

        for (Partida partida : partidas) {
            if (!partida.getFinalizada()) {
                return false; // Se encontrar uma partida não finalizada, retorna false
            }
        }

        return true; // Se todas as partidas estiverem finalizadas, retorna true
    }

    private boolean timesJaSeEnfrentaram(Time time1, Time time2) {
        for (Rodada rodada : tabela) {
            for (Partida partida : rodada.getPartidas()) {
                if ((partida.getTime1().equals(time1) && partida.getTime2().equals(time2)) ||
                        (partida.getTime1().equals(time2) && partida.getTime2().equals(time1))) {
                    return true; // Os times já se enfrentaram
                }
            }
        }
        return false; // Os times ainda não se enfrentaram
    }

    public void mostrarTimesNaRodadaAtual() {
        if (tabela.isEmpty()) {
            System.out.println("Ainda não foram geradas rodadas.");
            return;
        }

        Rodada ultimaRodada = tabela.get(tabela.size() - 1);
        List<Partida> partidas = ultimaRodada.getPartidas();

        System.out.println("Times na Rodada Atual:");

        for (Partida partida : partidas) {
            Time timeA = partida.getTime1();
            Time timeB = partida.getTime2();

            String resultadoPartida = (partida.getPlacar1() != null && partida.getPlacar2() != null)
                    ? " - Resultado: " + partida.getPlacar1() + " x " + partida.getPlacar2()
                    : "";

            System.out.println("Partida: " + timeA.getNome() + " vs " + timeB.getNome() + resultadoPartida);
        }
    }

    public void gerenciarPartidaDaUltimaRodada() {
        if (tabela.isEmpty()) {
            System.out.println("Ainda não foram geradas rodadas.");
            return;
        }
        Rodada ultimaRodada = tabela.get(tabela.size() - 1);
        List<Partida> partidas = ultimaRodada.getPartidas();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma partida para gerenciar:");

        for (int i = 0; i < partidas.size(); i++) {
            System.out.println((i + 1) + ". " + partidas.get(i).getTime1().getNome() + " vs " + partidas.get(i).getTime2().getNome());
        }

        int escolha = scanner.nextInt();

        if (escolha < 1 || escolha > partidas.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Partida partidaEscolhida = partidas.get(escolha - 1);
        if (partidaEscolhida.getFinalizada()) {
            System.out.println("A partida já foi finalizada. Não é possível atualizar o resultado.");
            return;
        }

        System.out.println("Informe o resultado da partida " + partidaEscolhida.getTime1().getNome() + " vs " + partidaEscolhida.getTime2().getNome() + ":");
        System.out.print("Gols do time " + partidaEscolhida.getTime1().getNome() + ": ");
        int golsTimeA = scanner.nextInt();

        System.out.print("Gols do time " + partidaEscolhida.getTime2().getNome() + ": ");
        int golsTimeB = scanner.nextInt();

        // Validar placares não negativos
        if (golsTimeA < 0 || golsTimeB < 0) {
            System.out.println("Os placares não podem ser negativos.");
            return;
        }

        // Registrar resultado usando o novo método
        partidaEscolhida.atualizarPartida(partidaEscolhida.getPIdPartida(), golsTimeA, golsTimeB);

        System.out.println("\nA partida já foi finalizada? (Digite 'sim' ou 'nao')");
        String finalizada = scanner.next().toLowerCase();

        if ("sim".equals(finalizada)) {
            partidaEscolhida.setFinalizada(true);
            partidaEscolhida.atualizarPontuacao(partidaEscolhida, golsTimeA, golsTimeB);
            System.out.println("Resultado da partida registrado com sucesso!");
        } else if ("nao".equals(finalizada)) {
            System.out.println("A pontuação só será registrada na tabela caso a partida tenha acabado!");
        }
    }


    public void imprimirTabela() {
        if (times.isEmpty()) {
            System.out.println("Ainda não há times cadastrados.");
            return;
        }

        // Ordenar a lista de times pelo número de pontos (descendente)
        times.sort(Comparator.comparing(Time::getPontos).reversed());

        System.out.println("Tabela de Pontos Corridos:");

        System.out.printf("%-20s %-8s %-8s %-8s %-12s %-8s%n",
                "Time", "Vitórias", "Empates", "Derrotas", "Saldo de Gols", "Pontos");

        for (Time time : times) {
            System.out.printf("%-20s %-8d %-8d %-8d %-12d %-8d%n",
                    time.getNome(), time.getVitorias(), time.getEmpate(), time.getDerrotas(),
                    time.getSaldoGols(), time.getPontos());
        }
    }

    public List<Rodada> getTabela() {
        return tabela;
    }

    public void setTabela(List<Rodada> tabela) {
        this.tabela = tabela;
    }

    public Integer getQuantidadeTime() {
        return quantidadeTime;
    }

    public void setQuantidadeTime(Integer quantidadeTime) {
        this.quantidadeTime = quantidadeTime;
    }

    @Override
    public ArrayList<Time> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<Time> times) {
        this.times = times;
    }
}
