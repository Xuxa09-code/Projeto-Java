// Lallier Pallu Cardoso de Faria 2°AUT
package CaixaPreta;

import javax.swing.*;
import java.io.*;
// import java.lang.reflect.Array;
public class RegistroArqBin2 {
    static String[] dadosReg = new String[10];
    static String regis = "", regis2 = "", regis3 = "";
    static int cont = 0;
    public static void main(String[] args)throws IOException {
        boolean tfn = plusOrNew();
        if (tfn) {
            criacaoStream(EscolhaPastaArq.nameNewArq(".dat"), false);
        } else {
            boolean ftEditarResetar = false;
            String nameDirFile = EscolhaPastaArq.menuArqs();
            Object[] opop = {"Adicionar Campos","Zerar Campos"};
            int numOp = JOptionPane.showOptionDialog(null, null, "Deseja:", 
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opop, opop[0]);
            if (numOp == 0) {
                ftEditarResetar = true;
                LeiRegisArqBin.leituraStream(nameDirFile);
                regis = LeiRegisArqBin.Result;
                regis2 = LeiRegisArqBin.Result2;
                regis3 = LeiRegisArqBin.Result3;
            }
            criacaoStream(nameDirFile, ftEditarResetar);
        }
        // JOptionPane.showMessageDialog(null, EscolhaPastaArq.file);
    }
    static boolean plusOrNew() {
        Object[] ops = {"Escrever em um arquivo novo", "Editar registro velho"};
        int op = 0;
        op = JOptionPane.showOptionDialog(null, "Deseja:", "Opções de edição", 
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]);
        if (op == 1)
            return false;
        else { // == 0
            return true;
        }
    }
    static void criacaoStream(String file, boolean tfn) {
        int idade, i = 0, contNS = 0;
        String[] dados = {"Nome: ", "Sexo: ", "Email: ", "Telefone: ",
                          "Curso: ", "Cidade: ", "Estado: ", "Aprovação: "};
        for (int j = 0; j < 10; j++) {
            dadosReg[j] = "null";
        }
        try {
            FileOutputStream arq = new FileOutputStream(file, tfn);
            DataOutputStream gravarArq = new DataOutputStream(arq);
            for ( i = cont; ( i < 9) && (contNS == 0); i++ ) {
                Object[] opsMF = {"Masculino", "Feminino", "Outro"};
                Object[] opsSN = {"Sim", "Não"};
                dadosReg[0] = JOptionPane.showInputDialog(null, dados[0], "Registro " + (int)(i+1),
                    JOptionPane.QUESTION_MESSAGE);
                int aux = JOptionPane.showOptionDialog(null, "Informe seu sexo",
                "Registro " + (int)(i+1), JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opsMF, opsMF[0]);
                if (aux == 0)
                    dadosReg[1] = "Masculino";
                else if (aux == 1)
                    dadosReg[1] = "Feminino";
                else
                    dadosReg[1] = "Outro";
                for (int j = 2; j < 7; j++) {
                    dadosReg[j] = JOptionPane.showInputDialog(null, dados[j], "Registro " + (int)(i+1),
                    JOptionPane.QUESTION_MESSAGE);
                }
                aux = JOptionPane.showOptionDialog(null, "Voce Foi Aprovado?",
                "Registro " + (int)(i+1), JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opsSN, opsSN[0]);
                if(aux == 0)
                    dadosReg[7] = "Sim";
                else
                    dadosReg[7] = "Não";
                for (int k = 0; k < dados.length; k++) {
                    gravarArq.writeUTF(dadosReg[k]);
                }
                imprimePags(regis, regis2, regis3, i);
                contNS = continuaOuNao();
            }
            System.out.printf("Arquivo gravado com sucesso!!!\n");
            cont = i;
            if (cont >= 9) {
                JOptionPane.showMessageDialog(null, 
                "Arquivo está lotado!!!");
            }
            arq.close();
        } catch (IOException e) {
            System.out.printf("Erro na execucao: %s", e);
        }
    }
    public static void imprimePags(String regis1, String regis2, String regis3, int i) {
        if (i < 3) {
            regis += LeiRegisArqBin.registString(dadosReg);
            JOptionPane.showMessageDialog(null, regis + "Página 1",
            "Como os registros se encontram P. 1", JOptionPane.PLAIN_MESSAGE);
        }else if ((i>=3) && (i<=5)){
            System.out.print("obj\n\n\n");
            regis2 += LeiRegisArqBin.registString(dadosReg);
            JOptionPane.showMessageDialog(null, regis + "Página 1",
            "Como os registros se encontram P. 1", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, regis2 + "Página 2", 
            "Como os registros se encontram P. 2", JOptionPane.PLAIN_MESSAGE);
        } else {
            regis3 += LeiRegisArqBin.registString(dadosReg);
            JOptionPane.showMessageDialog(null, regis + "Página 1",
            "Como os registros se encontram P. 1", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, regis2 + "Página 2", 
            "Como os registros se encontram P. 2", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, regis3 + "Página 3", 
            "Como os registros se encontram P. 3", JOptionPane.PLAIN_MESSAGE);
        }
    }
    public static int continuaOuNao() {
        int contNS = 3;
        Object[] ops = {"Sim", "Não"};
        while ((contNS != 0) && (contNS != 1)) {
            contNS = JOptionPane.showOptionDialog(null, "Deseja continuar editando Registro",
            "Continuar", JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]);
        }
        return contNS;
    }
}