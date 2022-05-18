package Projeto;

public class Canal {
	private String canal;
	private String tipo;
	
	public Canal() {		
	}
	public Canal(String canal, String tipo) {
		this.canal = canal;
		this.tipo = tipo;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public String getCanal() {
		return canal;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String toString() {
		return canal;
	}
	public boolean equals(Canal canal) {
		if (canal.getCanal().equals(canal)) {
			return true;
		}
		return false;
	}
	
	

}
