package model;

public class Time {
    private Integer idTime;
    private String nome;
    private String escudo;
    private Boolean isActive;
    private Integer pontos;
    private Integer vitorias;
    private Integer derrotas;
    private Integer empate;
    private Integer saldoGols;

    public Time(Integer idTime, String nome, String escudo, Boolean isActive) {
        this.idTime = idTime;
        this.nome = nome;
        this.escudo = escudo;
        this.isActive = isActive;
        this.pontos = 0;
        this.vitorias = 0;
        this.derrotas = 0;
        this.empate = 0;
        this.saldoGols = 0;
    }

    public Integer getIdTime() {
        return idTime;
    }

    public void setIdTime(Integer idTime) {
        this.idTime = idTime;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos+=pontos;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias++;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas++;
    }

    public Integer getEmpate() {
        return empate;
    }

    public void setEmpate(Integer empate) {
        this.empate++;
    }

    public Integer getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(Integer saldoGols) {
        this.saldoGols+=saldoGols;
    }

    public void mostrarDados(){
        System.out.println(getNome() + getEscudo() + getActive());
    }
}
