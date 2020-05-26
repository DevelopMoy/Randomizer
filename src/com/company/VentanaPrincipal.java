package com.company;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal (){
        super.setBounds(200,200,700,300);
        setLocationRelativeTo(null);
        super.setResizable(false);
        super.setTitle("Randomizer");
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add (new PanelPrincipal());
        super.setVisible(true);
    }
}
