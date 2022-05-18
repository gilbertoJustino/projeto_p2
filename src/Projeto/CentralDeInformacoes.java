package Projeto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Document;

public class CentralDeInformacoes {

	private List<ProgramaDeTV> todososProgramas = new ArrayList<>();
	private ArrayList<Canal> canais = new ArrayList<>();

	public List<ProgramaDeTV> getTodososProgramas() {
		return todososProgramas;
	}

	public void setTodososProgramas(List<ProgramaDeTV> todososProgramas) {
		this.todososProgramas = todososProgramas;
	}

	public boolean adicionarProgramaDeTV(ProgramaDeTV programa) {
		for (ProgramaDeTV programaDeTv : todososProgramas) {
			if (programaDeTv.getId() == programa.getId()) {
				return false;
			}
		}
		todososProgramas.add(programa);

		return true;
	}

	public ProgramaDeTV recuperarProgramaDeTVPeloId(long id) {
		for (ProgramaDeTV programaDeTv : todososProgramas) {
			if (programaDeTv.getId() == id) {
				return programaDeTv;
			}
		}
		return null;
	}

	public boolean adicionarCanal(Canal canal) {
		for (Canal todosCanais : canais) {
			if (canal.getCanal().equals(todosCanais.getCanal())) {
				return false;
			}
			canais.add(canal);
		}
		return true;
	}

	public Canal recuperarCanalPeloNome(String nome) {
		for (Canal canal : canais) {
			if (nome.equals(canal.getCanal())) {
				return canal;
			}
		}

		return null;

	}
	
}
