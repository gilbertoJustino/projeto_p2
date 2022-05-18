package Projeto;

import java.util.Date;

public class ProgramaDeTV {
	private long id = System.currentTimeMillis();
	private String nome;
	private Tipo tipo;
	private Date diaDaSemana;
	private Canal canal;
	
	public Date getDiaDaSemana() {
		return diaDaSemana;
	}
	public void setDiaDaSemana(Date diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}
	public ProgramaDeTV(String nome, Tipo tipo) {
		this.nome = nome;
		this.tipo = tipo;
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
	
	

}
