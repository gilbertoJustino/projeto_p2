package Projeto;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Percistencia persistencia = new Percistencia();
        CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral("central");
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("==============================");
            System.out.println(
                    "1 - Novo programa \n" +
                    "2 - Listar todos os programas  \n" +
                    "3 – Listar todos os programas de um mesmo tipo \n" +
                    "4 - Novo canal de televisão \n" +
                    "5 - Listar todos os canais de televisão  \n" +
                    "6 – Gera relação dos programas de um mesmo canal \n"+
                    "S - Sair");
            String op = input.nextLine();

            if(op.equals("1")){
                if(centralDeInformacoes.getTodosOsCanais().size() != 0){
                    System.out.println("Nome:");
                    String nome = input.nextLine();

                    System.out.println("Tipo:");
                    System.out.println("(0) SERIES_REGULARES");
                    System.out.println("(1) REALITY_SHOWS");
                    System.out.println("(2) PROGRAMAS_CONTINUOS");
                    int tipo =Integer.parseInt(input.nextLine());

                    List<Canal> canais = centralDeInformacoes.getTodosOsCanais();
                    centralDeInformacoes.listarCanais();
                    int canalOp = Integer.parseInt(input.nextLine());
                    ProgramaDeTV programaDeTV = new ProgramaDeTV(nome, Tipo.values()[tipo], canais.get(canalOp));

                    while (true){
                        System.out.println("Quais dias esse progama é exibido?");
                        System.out.println("1 - Domingo\n" +
                                "2 - Segunda  \n" +
                                "3 – Terça \n" +
                                "4 - Quarta \n" +
                                "5 - Quinta \n" +
                                "6 – Sexta \n"+
                                "7 - Sábado\n " +
                                "8 - Finalizar Cadastro");
                        int dia = Integer.parseInt(input.nextLine());

                        if(dia <= 7 && dia > 0){
                            programaDeTV.getDiaDaSemana()[dia-1] = new DiaDaSemana(dia-1);
                        }
                        else
                            break;
                    }

                    centralDeInformacoes.adicionarProgramaDeTV(programaDeTV);
                    persistencia.salvarCentral(centralDeInformacoes);
                }else {
                    System.out.println("Cadastre um canal!");
                }
            }
            else if(op == "2"){

                for(ProgramaDeTV programaDeTV : centralDeInformacoes.getTodososProgramas()){
                    System.out.println("==============================");
                    System.out.println("Nome:" + programaDeTV.getNome());
                    System.out.println("Tipo:" + programaDeTV.getTipo());
                }
            }
            else if(op == "3"){
                System.out.println("Listar por tipo:");
                System.out.println("(0) SERIES_REGULARES");
                System.out.println("(1) REALITY_SHOWS");
                System.out.println("(2) PROGRAMAS_CONTINUOS");
                int tipo = Integer.parseInt(input.nextLine());

                if(tipo < (Tipo.values().length)){
                    centralDeInformacoes.listarPorTipo(Tipo.values()[tipo]);
                }
            }
            else if(op == "4"){
                System.out.println("Nome:");
                String nome = input.nextLine();

                System.out.println("Tipo:");
                String tipo = input.nextLine();

                Canal canal = new Canal(nome, tipo);

                centralDeInformacoes.adicionarCanal(canal);
                persistencia.salvarCentral(centralDeInformacoes);
            }
            else if(op == "5"){
                for(Canal canal : centralDeInformacoes.getTodosOsCanais()){
                    System.out.println("==============================");
                    System.out.println("Nome:" + canal.getCanal());
                    System.out.println("Tipo:" + canal.getTipo());
                }
            }
            else if(op == "6"){
                centralDeInformacoes.listarCanais();
                int canalOp = Integer.parseInt(input.nextLine());

                GeradorDeRelatorios.obterProgramacaoDeUmCanal(centralDeInformacoes.getTodosOsCanais().get(canalOp));
            }
            else if (op.equals("7")){
                System.out.println("Enviando email");
                Mensageiro.enviarProgramacaoDeHoje("torgatesousa@gmail.com");
                System.out.println("Enviado...");
            }
            else {
                break;
            }
        }
    }
}