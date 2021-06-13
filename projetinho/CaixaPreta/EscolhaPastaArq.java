package CaixaPreta;
import java.io.*;
import javax.swing.*;
public class EscolhaPastaArq {
    public static String dir = "";
    public static String barra = "//";
    public static String[] arqvs = new String[10];
    public static String file = "", dirAux = "", dirPai = "";
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, arqvs = imprimDirs(".DAT"), file, JOptionPane.INFORMATION_MESSAGE);
        // JOptionPane.showMessageDialog(null, file);
        veriDirExistOuNao(".DAT");
    }
    static String veriDirExistOuNao (String fim) {
        if (imprimDirs(fim)[0].length() == 0) {
            criacaoDir();
        }
        // System.out.print(System.getProperty("os.name"));
        barraVeri();
        return dir;
    }
    static String barraVeri () {
        String so = String.valueOf(System.getProperty("os.name"));
        if(so.equals("Linux"))
            barra = "//";
        else
            barra = "\\";
        return barra;
    }
    static String[] imprimDirs (String fim) {
        int i = 0;
        File fileI = new File(System.getProperty("user.dir"));
        File[] arquivos = fileI.listFiles();
        arqvs[i] = "";
        for (File nomes : arquivos) {
            if ((nomes.isDirectory()) && (!nomes.getName().equals(".vscode"))) {
                System.out.print(nomes.getName());
                arqvs[i] = dir = System.getProperty("user.dir") + barraVeri() + nomes.getName();
                dirPai = dir;
                File fileArq = new File(dir);
                File[] arq = fileArq.listFiles();
                System.out.print("       "+dir+"       ");
                for (File nameArq : arq) {
                    if (nameArq.isDirectory()) {
                        arqvs[i] = dir += barraVeri() + nameArq.getName();
                        dirAux = nameArq.getName();
                        File fileArq1 = new File(dir);
                        File[] arq1 = fileArq1.listFiles();
                        System.out.print("       "+dir+"       ");
                        for (File nameArq1 : arq1) {
                            if (nameArq1.isFile()) {
                                if (nameArq1.getName().toUpperCase().endsWith(fim)) {
                                    i++;
                                    arqvs[i] = nameArq1.getName();
                                }
                            }
                        }
                    }
                }
            }
        }
        return arqvs;
    }
    static String diretorioNovo () {
        String dir = "";
        dir = JOptionPane.showInputDialog(null, 
        "Entre com o nome do seu diretorio para por os arquivos binários: ",
        "Nominho", JOptionPane.QUESTION_MESSAGE);
        return dir;
    }
    static void criacaoDir () {
        if (dir.length() == 0)
            dir = diretorioNovo();
        File diret = new File(dir);
        diret.mkdirs();
    }
    /*----------------------------------- Arquivo ------------------------------------- */
    static String nameNewArq (String fim) {
        boolean entraSai = true;
        String nmArq = "", nomeRetorArq = "";
        while (entraSai) {
            entraSai = false;
            try {
                nmArq = JOptionPane.showInputDialog(null, "Entre com o nome do novo Arquivo: ",
                "Novo Arquivo", JOptionPane.QUESTION_MESSAGE);
                File fileA = new File(nmArq);
                if (! fileA.getName().toUpperCase().endsWith(fim)) {
                    nmArq += fim;
                }
                file = nomeRetorArq = veriDirExistOuNao(fim) + barra + nmArq;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, 
                "Olha, pesso que preste mais atenção na sua Resposta\nNão use espaço, dá errado!!!",
                "ERROR", JOptionPane.ERROR_MESSAGE);
                entraSai = true;
            }
        }
        return nomeRetorArq;
    }
    static String menuArqs () {
        Object[] arqs = EscolhaPastaArq.imprimDirs(".DAT");
        arqs[0] = null;
        String seleObject = (String)(JOptionPane.showInputDialog(
        null, "Escolha o Arquivo: ", 
        "Arquivos Existentes", JOptionPane.INFORMATION_MESSAGE, 
        null, arqs, arqs[0]));
        return veriDirExistOuNao(".DAT") + barra + seleObject;
    }
    static String menuArqsTXT () {
        Object[] arqs = EscolhaPastaArq.imprimDirs(".TXT");
        arqs[0] = null;
        String seleObject = (String)(JOptionPane.showInputDialog(
        null, "Escolha o Arquivo: ", 
        "Arquivos Existentes", JOptionPane.INFORMATION_MESSAGE, 
        null, arqs, arqs[0]));
        veriDirExistOuNao (".TXT");
        return veriDirExistOuNao(".TXT") + barra + seleObject;
    }
}