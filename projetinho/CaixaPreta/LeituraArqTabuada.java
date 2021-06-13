package CaixaPreta;
import java.io.*;
import javax.swing.*;
public class LeituraArqTabuada {
    public static void main(String[] args)throws IOException {
        String file = EscolhaPastaArq.menuArqsTXT(), result = "";
        try {
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            
            String linha = lerArq.readLine(); // lê a primeira linha
            while (linha != null) {
                result += linha + "\n";
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            JOptionPane.showMessageDialog(null, result, "Conteúdo do Arquivo",
            JOptionPane.PLAIN_MESSAGE);
            arq.close();
        } catch (IOException var) {
            //System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
            System.out.printf("Erro na abertura do arquivo: %s.\n", var);
        }
    }
}
