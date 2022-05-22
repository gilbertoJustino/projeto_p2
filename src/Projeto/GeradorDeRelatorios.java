package Projeto;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class GeradorDeRelatorios {

    public static void obterProgramacaoDeUmCanal(Canal canal) {
        Percistencia persistencia = new Percistencia();
        CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral("central");

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("relatório.pdf"));
            document.open();

            document.add(new Paragraph("Canal " + canal.getCanal()));
            for(ProgramaDeTV programaDeTV: centralDeInformacoes.getTodososProgramas()){
                if(programaDeTV.getCanal().equals(canal)){
                    document.add(new Paragraph("Nome: " + programaDeTV.getNome()));
                }

            }

        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
    }
}