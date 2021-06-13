// LALLIER PALLU CARDOSO DE FARIA
package CaixaPreta;
import javax.swing.*;

public class RecursaoPriEulSold {
    public static void main(String[] args) {
        RecursaoPriEulSold calcs = new RecursaoPriEulSold(); // Apelida de calcs;
        int num = Integer.parseInt( JOptionPane.showInputDialog(null,
                                    "Entre com o valor de n", "Priminho",
                                    JOptionPane.QUESTION_MESSAGE));
        String priOuNao = calcs.Primo(num,2);
        JOptionPane.showMessageDialog(null, priOuNao, "Priminho", JOptionPane.INFORMATION_MESSAGE);
        float euler = calcs.Euler(num);
        JOptionPane.showMessageDialog(null, euler, "Euler", JOptionPane.INFORMATION_MESSAGE);
        int[] sold = calcs.Soldadinho(num, num, 1);
        JOptionPane.showMessageDialog(null, "Numero de soldados: " +sold[1]+ "\nNumero de linhas: "
        +sold[0]+ "\nNumero ultima linha = " +sold[2], "Soldadinho", JOptionPane.INFORMATION_MESSAGE);
        String result = "";
        JOptionPane.showMessageDialog(null, calcs.cnvSoldR(sold,1,1,result), "Soldadinho", JOptionPane.INFORMATION_MESSAGE);
    }
    public static float num() {
        int num = Integer.parseInt( JOptionPane.showInputDialog(null,
                                    "Entre com o valor de n", "Numero Mágico",
                                    JOptionPane.QUESTION_MESSAGE));
        return num;
    }
    public static int Fribonacci(int a) {
        if (a<=2)
            return 1;
        else {
            return Fribonacci(a-1) + Fribonacci(a-2);
        }
    }
    public static String Primo(int num, int i) {
        if (i < num)
            if (num % i == 0)
                return "Não é primo";
            else 
                return Primo(num, i+1);
        else
            return "É primo";

    }
    public static int Fatorial(int num) {
        if (num == 0)
            return 1;
        else
            return num * Fatorial(num-1);
    }
    public static float Euler(float euler) {
        if (euler == 0)
            return 1;
        else
            return (float)1/Fatorial((int)euler) + Euler(euler-1);
    }
    public static int[] Soldadinho(int num, int cont, int linha) {
        if (linha <= cont) {
            return Soldadinho(num,  cont - linha, linha+1);
        } else {
            if (cont == 0) {
                cont = linha-1;
                linha--;
            } else
            if (cont < 0)
                cont = cont + linha-1;
            int result[] = {linha, num, cont};
            return result;
        }
    }
    public static String cnvSoldR (int[] nums, int i, int j, String result) {
        if ( i < nums[0] ){
            if (j <= i){
                result += "I";
                return cnvSoldR(nums, i, j+1, result);
            } else {
                result += "\n";
                return cnvSoldR(nums, i+1, j = 1, result);
            }
        } else {
            int k = nums[2];
            if (j <= k){
                result += "I";
                return cnvSoldR(nums, i, j+1, result);
            }
            result += "\nLinhas = ";
            result += nums[0];
            result += "\nSoldados = ";
            result += nums[1];
            result += "\nNumero ultima linha = ";
            result += nums[2];
            return result;
        }
    }
}