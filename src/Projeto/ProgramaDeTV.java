package Projeto;

import java.util.Date;

public class ProgramaDeTV {
    private long id = System.currentTimeMillis();
    private String nome;
    private Tipo tipo;
    private DiaDaSemana[] diasDaSemana = new DiaDaSemana[7];
    private Canal canal;

    public ProgramaDeTV(String nome, Tipo tipo, Canal canal) {
        this.nome = nome;
        this.tipo = tipo;
        this.canal = canal;
    }
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public String toString() {
        return nome;
    }

    public DiaDaSemana[] getDiaDaSemana() {
        return diasDaSemana;
    }

    public void setDiaDaSemana(DiaDaSemana[] diaDaSemana) {
        this.diasDaSemana = diaDaSemana;
    }

    public Canal getCanal() {
        Date date = new Date();

        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }
}