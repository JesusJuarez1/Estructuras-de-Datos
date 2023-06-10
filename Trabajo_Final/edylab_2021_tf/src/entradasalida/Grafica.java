package entradasalida;

import javax.swing.*;

public class Grafica extends JFrame {
    public Grafica(JPanel panel){
        this.setVisible(true);
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
    }
}
