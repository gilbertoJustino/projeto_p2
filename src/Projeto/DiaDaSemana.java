package Projeto;

public class DiaDaSemana {
    private int dia;

    DiaDaSemana(int dia){
        this.dia = dia;
    }
    public int getDia() {
        return dia;
    }

    public String toString(){
        switch (dia){
            case 1:
                return "Domingo";
            case 2:
                return "Segunda";
            case 3:
                return "Terça";
            case 4:
                return "Quarta";
            case 5:
                return "Quinta";
            case 6:
                return "Sexta";
            default:
                return "Sábado";
        }
    }
}