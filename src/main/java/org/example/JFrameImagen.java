package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JFrameImagen extends JFrame {
    private JLabel etiqueta;

    public JFrameImagen (Image aux){
        etiqueta = new JLabel();
        ImageIcon ii = new ImageIcon(aux);
        etiqueta.setIcon(ii);
        add(etiqueta);


        setTitle("Imagen");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    public JFrameImagen (BufferedImage aux2){
        Image aux = HerramientasImagen.toImage(aux2);
        etiqueta = new JLabel();
        ImageIcon ii = new ImageIcon(aux);
        etiqueta.setIcon(ii);
        add(etiqueta);


        setTitle("Imagen");
        setSize(aux2.getWidth(), aux2.getHeight());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }
}
