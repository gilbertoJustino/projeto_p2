package Projeto;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.*;

public class Percistencia {

    private XStream xStream = new XStream(new DomDriver());
    private File arquivo = null;

    public void salvarCentral (CentralDeInformacoes ci) {

        arquivo = new File("central.xml");

        String xml = xStream.toXML(ci);

        try {
            arquivo.createNewFile();
            PrintWriter gravar = new PrintWriter(arquivo);
            gravar.print(xml);
            gravar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CentralDeInformacoes recuperarCentral(String nome) {

        arquivo = new File (nome+".xml");
        try {
            if(arquivo.exists()) {
                FileInputStream fis = new FileInputStream(arquivo);
                return (CentralDeInformacoes) xStream.fromXML(fis);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new CentralDeInformacoes();
    }
}