package CaixaPreta;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;


public class MenuGrafico {
    JButton[] butao = new JButton[10];
    JFrame f;
    JPanel p;
    String[] labels = {"Calculo Primo", "Calculo Euler", "Calculo Fribonacii",
    "Soldadinho",  "Criar Arquivo Tabuada",  "Ler Arquivo Tabuada", 
    "Registrar arquivo binário", "Ler Registro binário", "Sair"};
    public static String[] dados = {"","","","",""};
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuGrafico();
            }
        });
    }
    // public void createAndShowGUI() {
    public MenuGrafico() {
        f = new JFrame("Menu");
        p = new JPanel();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(400,400);
        p.setBackground(Color.CYAN);
        f.setLocation(500, 100);
        f.setVisible(true);
        p.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1,1,1,1);
        for (int i = 0; i < 9; i++) {
            butao[i] = new JButton(labels[i]);
            butao[i].setPreferredSize(new Dimension(250,25));
        }
        butao[0].addActionListener( new ActionListener() {
            public void actionPerformed (ActionEvent evt) {
                f.setVisible(false);
                int num = (int)RecursaoPriEulSold.num();
                JOptionPane.showMessageDialog(null, "O numero " + num +
                " " + RecursaoPriEulSold.Primo(num, 2),
                "Primo", JOptionPane.PLAIN_MESSAGE);
                f.setVisible(true);
            }
        });
        butao[1].addActionListener(evt -> {
            f.setVisible(false);
            float num = RecursaoPriEulSold.num();
            JOptionPane.showMessageDialog(null, "O numero de Euler para " + num +
            " numeros é " + RecursaoPriEulSold.Euler(num),
            "Euler", JOptionPane.PLAIN_MESSAGE);
            f.setVisible(true);
        });
        butao[2].addActionListener(evt -> {
            f.setVisible(false);
            int num = (int)RecursaoPriEulSold.num();
            int resulInt = RecursaoPriEulSold.Fribonacci(num);
            JOptionPane.showMessageDialog(null, "O Termo " + num +
            " da sequência Fribonacci é " + resulInt,
            "Fribonacci", JOptionPane.PLAIN_MESSAGE);
            int a = 1, b = 1, c[] = new int[num];
            String res = "1 1 ";
            for (int i = 0; b <= resulInt; i++) {
                c[i] = a + b;
                a = b;
                b = c[i];
            }
            for (int i = 0; i < num-2; i++) {
                res += c[i];
                res += " ";
            }
            JOptionPane.showMessageDialog(null, "Sequência: "
            + res, "Fribonacci", JOptionPane.PLAIN_MESSAGE);
            f.setVisible(true);
        });
        butao[3].addActionListener(evt -> {
            f.setVisible(false);
            int num = (int)RecursaoPriEulSold.num();
            int[] sold = RecursaoPriEulSold.Soldadinho(num, num, 1);
            String result = "";
            JOptionPane.showMessageDialog(null, RecursaoPriEulSold.cnvSoldR(sold,1,1,result),
            "Soldadinho", JOptionPane.INFORMATION_MESSAGE);
            f.setVisible(true);
        });
        butao[4].addActionListener(evt -> {
            f.setVisible(false);
            try {
                ArquivoTabuada.main(null);
            } catch (IOException e) {
                System.out.print("opa");
            }
            f.setVisible(true);
        });
        butao[5].addActionListener(evt -> {
            f.setVisible(false);
            try {
                LeituraArqTabuada.main(null);
            } catch (IOException e) {
                System.out.print("opa");
            }
            f.setVisible(true);
        });
        butao[6].addActionListener(evt -> {
            f.setVisible(false);
            try {
                RegistroArqBin2.main(null);
            } catch (IOException e) {
                System.out.print("opa");
            }
            f.setVisible(true);
        });
        butao[7].addActionListener(evt -> {
            f.setVisible(false);
            try {
                LeiRegisArqBin.main(null);
            } catch (IOException e) {
            }
            f.setVisible(true);
        });
        butao[8].addActionListener(evt -> {
            f.dispose();
        });
        JLabel titulo = new JLabel("Deseja fazer o que?", JLabel.CENTER);
        gbc.gridy = 0;
        p.add(titulo, gbc);
        int j = 0;
        for (int i = 1; i <= 9; i++, j++) {
            gbc.gridy = i;
            p.add(butao[j], gbc);
        }
        // p.add(butao, gbc);
        f.add(p);
    }
}