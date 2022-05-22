package Projeto;

import java.util.ArrayList;
import java.util.List;

public class CentralDeInformacoes {
    private ArrayList<ProgramaDeTV> todososProgramas = new ArrayList<>();
    private ArrayList<Canal> canais = new ArrayList<>();

    public boolean adicionarProgramaDeTV(ProgramaDeTV programa) {

        for (ProgramaDeTV programaDeTV: todososProgramas){
            if(programaDeTV.getId() == programa.getId()){
                return false;
            }
        }
        todososProgramas.add(programa);
        return true;
    }

    public List<ProgramaDeTV> getTodososProgramas() {
        return todososProgramas;
    }

    public List<Canal> getTodosOsCanais() {
        return canais;
    }

    public void setTodososProgramas(ArrayList<ProgramaDeTV> todososProgramas) {
        this.todososProgramas = todososProgramas;
    }

    public ProgramaDeTV recuperarProgramaDeTVPeloId(long id) {

        for (ProgramaDeTV programaDeTV : todososProgramas){
            if(programaDeTV.getId() == id){
                return programaDeTV;
            }
        }

        return null;
    }

    public void listarPorTipo(Tipo tipo){

        for(ProgramaDeTV programaDeTV : todososProgramas){
            if(programaDeTV.getTipo() == tipo){
                System.out.println("==============================");
                System.out.println("Nome:" + programaDeTV.getNome());
                System.out.println("Tipo:" + programaDeTV.getTipo());
            }
        }
    }

    public boolean adicionarCanal(Canal canal) {
        for (Canal canalAox : canais) {
            if (canal.equals(canalAox)) {
                return false;
            }
        }

        canais.add(canal);
        return true;
    }

    public void listarCanais(){
        for(int i = 0; i < canais.size(); i++){
            System.out.println("(" + i + ") " + canais.get(i).getCanal());
        }
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