package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MataMata extends Campeonato {

    private List<RodadaMataMata> chaveamento;
    private Time campeao;

    public MataMata(
            Integer idCampeonato, LocalDate dataInicio, LocalDate dataFim,
            String modalidade, String premiacao, String patrocinio,
            Boolean concluido, List<Time> times
    ) {
        super(idCampeonato, dataInicio, dataFim, modalidade, premiacao, patrocinio, concluido, times);
        this.setChaveamento(new ArrayList<>());
        this.setCampeao(null);
    }

    public MataMata(List<Time> times) {
        super(times);
        this.setChaveamento(new ArrayList<>());
        this.setCampeao(null);
    }

    public void sortearTimes() {
        List<Time> timesEmbaralhados = new ArrayList<>(getTimes());
        Collections.shuffle(timesEmbaralhados);
        setTimes(timesEmbaralhados);
    }

    public void iniciarMataMata(List<Time> times) {
        if (!isPotenciaDeDois(times.size())) {
            System.out.println("A quantidade de times não é uma potência de 2. Não é possível gerar confrontos mata-mata.");
            return;
        }

        RodadaMataMata rodadaMataMata = new RodadaMataMata();

        List<Time> copiaTimes = new ArrayList<>(times);

        while (copiaTimes.size() >= 2) {
            Time time1 = copiaTimes.remove(0);
            Time time2 = copiaTimes.remove(0);

            Partida partida = new Partida(time1, time2);
            rodadaMataMata.adicionarPartida(partida);
        }
        rodadaMataMata.definirFase();
        this.getChaveamento().add(rodadaMataMata);
    }

    private boolean isPotenciaDeDois(int numero) {
        return (numero & (numero - 1)) == 0 && numero != 0;
    }

    public void proximaRodada() {
        if (getChaveamento().isEmpty()) {
            System.out.println("Não há rodada anterior para gerar a próxima.");
            return;
        }

        RodadaMataMata ultimaRodada = getChaveamento().get(getChaveamento().size() - 1);
        List<Partida> partidasUltimaRodada = ultimaRodada.getRodadaMataMata();

        if (!ultimaRodada.todasPartidasFinalizadas()) {
            System.out.println("Erro ao gerar a próxima rodada: nem todas as partidas estão finalizadas.");
            return;
        }

        List<Time> vencedoresUltimaRodada = new ArrayList<>();

        for (Partida partida : partidasUltimaRodada) {
            Time vencedor = partida.getVencedor();
            if (vencedor != null) {
                vencedoresUltimaRodada.add(vencedor);
            }
        }

        if (vencedoresUltimaRodada.size() % 2 != 0) {
            System.out.println("Erro ao gerar a próxima rodada: número ímpar de vencedores.");
            return;
        }

        iniciarMataMata(vencedoresUltimaRodada);
    }

    public void encerrarMataMata() {
        if (getChaveamento().isEmpty()) {
            System.out.println("Não há rodada para encerrar o mata-mata.");
            return;
        }

        RodadaMataMata ultimaRodada = getChaveamento().get(getChaveamento().size() - 1);

        if (ultimaRodada.getRodadaMataMata().size() != 1) {
            System.out.println("A última rodada não tem exatamente 1 partida. Não é possível encerrar o mata-mata.");
            return;
        }

        Partida finalPartida = ultimaRodada.getRodadaMataMata().get(0);
        Time vencedor = finalPartida.getVencedor();

        if (vencedor != null) {
            this.setCampeao(vencedor);
            System.out.println("Mata-mata encerrado. O campeão é: " + getCampeao().getNome());
            setConcluido(true);
        } else {
            System.out.println("Ainda não há um campeão, pois a partida final não foi concluída.");
        }
    }

    public void imprimirChaveamentoMataMata() {
        for (RodadaMataMata rodada : getChaveamento()) {
            rodada.definirFase();
            System.out.println("Fase: " + rodada.getFase());
            rodada.imprimirRodadaMataMata();
            System.out.println("=======================");
        }
    }

    public List<RodadaMataMata> getChaveamento() {
        return chaveamento;
    }

    public void setChaveamento(List<RodadaMataMata> chaveamento) {
        this.chaveamento = chaveamento;
    }

    public Time getCampeao() {
        return campeao;
    }

    public void setCampeao(Time campeao) {
        this.campeao = campeao;
    }

}
