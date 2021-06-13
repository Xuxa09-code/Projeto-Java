// Lallier Pallu Cardoso de Faria 2°AUT
package CaixaPreta;
import java.io.*;
import javax.swing.*;
public class LeiRegisArqBin {
    static String Result = "", Result2 = "", Result3 = "";
    static int i = 0;
    public static void main(String[] args)throws IOException {
        String file = EscolhaPastaArq.menuArqs();
        Result = "";
        Result2 = "";
        Result3 = "";
        i = 0;
        leituraStream(file);
        if (RegistroArqBin2.cont < 3) {
            JOptionPane.showMessageDialog(null, Result + "Página 1",
            "LENDO SUAS INFORMACOES P. 1", JOptionPane.PLAIN_MESSAGE);
        } else if ((RegistroArqBin2.cont>=3) && (RegistroArqBin2.cont<=5)){
            JOptionPane.showMessageDialog(null, Result + "Página 1",
            "LENDO SUAS INFORMACOES P. 1", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, Result2 + "Página 2", 
            "LENDO SUAS INFORMACOES P. 2", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, Result + "Página 1",
            "LENDO SUAS INFORMACOES P. 1", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, Result2 + "Página 2", 
            "LENDO SUAS INFORMACOES P. 2", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, Result3 + "Página 2", 
            "LENDO SUAS INFORMACOES P. 3", JOptionPane.PLAIN_MESSAGE);
        }
    }
    static String registString(String[] dadosRegis) {
        String Result = "";
        Result += " nome...............................: "+ dadosRegis[0] +" \n";
        Result += " Sexo...............................: "+ dadosRegis[1] +" \n";
        Result += " email..............................: "+ dadosRegis[2] +" \n";
        Result += " telefone...........................: "+ dadosRegis[3] +" \n";
        Result += " curso..............................: "+ dadosRegis[4] +" \n";
        Result += " Cidade.............................: "+ dadosRegis[5] +" \n";
        Result += " Estado.............................: "+ dadosRegis[6] +" \n";
        Result += " Aprovacao..........................: "+ dadosRegis[7] +" \n";
        Result += "======================================================================\n";
        return Result;
    }
    static String leituraStream (String file) {
        String tel, curso, nomeMae, email, nome, aprov = "";
        try {
            FileInputStream arq = new FileInputStream(file);
            DataInputStream lerArq = new DataInputStream(arq);
            while ((nome = lerArq.readUTF()) != null) {
                nomeMae = lerArq.readUTF();
                email = lerArq.readUTF();
                tel = lerArq.readUTF();
                curso = lerArq.readUTF();
                String city = lerArq.readUTF();
                String estado = lerArq.readUTF();
                aprov = lerArq.readUTF();
                if (i < 3) {
                    Result += " nome...............................: "+ nome +" \n";
                    Result += " Sexo...............................: "+ nomeMae +" \n";
                    Result += " email..............................: "+ email +" \n";
                    Result += " telefone...........................: "+ tel +" \n";
                    Result += " curso..............................: "+ curso +" \n";
                    Result += " Cidade.............................: "+ city +" \n";
                    Result += " Estado.............................: "+ estado +" \n";
                    Result += " Aprovacao..........................: "+ aprov +" \n";
                    Result += "======================================================================\n";
                }else if ((i>=3) && (i<=5)){
                    Result2 += " nome...............................: "+ nome +" \n";
                    Result2 += " Sexo...............................: "+ nomeMae +" \n";
                    Result2 += " email..............................: "+ email +" \n";
                    Result2 += " telefone...........................: "+ tel +" \n";
                    Result2 += " curso..............................: "+ curso +" \n";
                    Result2 += " Cidade.............................: "+ city +" \n";
                    Result2 += " Estado.............................: "+ estado +" \n";
                    Result2 += " Aprovacao..........................: "+ aprov +" \n";
                    Result2 += "======================================================================\n";
                } else {
                    Result3 += " nome...............................: "+ nome +" \n";
                    Result3 += " Sexo...............................: "+ nomeMae +" \n";
                    Result3 += " email..............................: "+ email +" \n";
                    Result3 += " telefone...........................: "+ tel +" \n";
                    Result3 += " curso..............................: "+ curso +" \n";
                    Result3 += " Cidade.............................: "+ city +" \n";
                    Result3 += " Estado.............................: "+ estado +" \n";
                    Result3 += " Aprovacao..........................: "+ aprov +" \n";
                    Result3 += "======================================================================\n";
                }
                i++;
                RegistroArqBin2.cont = i;
            }
            arq.close();
        } catch (IOException e) {
            System.out.print("Error: " + e);
        }
        return Result;
    }
}