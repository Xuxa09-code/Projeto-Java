package CaixaPreta;
import java.util.*;
import java.io.*;
import javax.swing.*;
public class ArquivoTabuada {
    public static void main(String[] args)throws IOException {
        int i, n;
        float r;
        String name = "";
        boolean tfn = RegistroArqBin2.plusOrNew();
        if (tfn) {
            name = EscolhaPastaArq.nameNewArq(".txt");
        } else {
            name = EscolhaPastaArq.menuArqsTXT();
        }
        r = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o número para a tabuada:", 
        "Tabuada", JOptionPane.PLAIN_MESSAGE));
        FileWriter arq = new FileWriter(name);
        //e é a unidade onde será gravado o arquivo, altere para unidade que vc tenha na sua maq. tipo c
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.printf("+--Resultado--+%n");
        for (i=1; i<=10; i++)
            gravarArq.printf("| %2d * %.2f = %2.2f |%n", i, r, (i*r));
        gravarArq.printf("+-------------+%n");
        arq.close();
        JOptionPane.showMessageDialog(null, "Tabuada do "+ r +
        " foi gravada com sucesso em " + name);
    }
}