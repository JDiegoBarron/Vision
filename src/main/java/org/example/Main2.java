package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Main2 {
    static void main(){
        Image imagenjeje = HerramientasImagen.abrirImagen();
        BufferedImage bi = HerramientasImagen.toBufferedImage(imagenjeje);

        int[] cr = new int[256];
        int[] cg = new int[256];
        int[] cb = new int[256];

        for (int x = 0; x < bi.getWidth(); x++) {
            for (int y = 0; y < bi.getHeight(); y++) {
                Color aux = new Color(bi.getRGB(x, y));
                cr[aux.getRed()]++;
                cg[aux.getGreen()]++;
                cb[aux.getBlue()]++;
            }
        }

        for (int i = 0; i < 256; i++) {
            System.out.println(i + ": R=" + cr[i] + " G=" + cg[i] + " B=" + cb[i]);
        }

        BufferedImage histR = crearHistograma(cr, 0);
        BufferedImage histG = crearHistograma(cg, 1);
        BufferedImage histB = crearHistograma(cb, 2);

        new JFrameImagen(histR);
        new JFrameImagen(histG);
        new JFrameImagen(histB);
    }

    public static BufferedImage crearHistograma(int[] datos, int canal) {
        int ancho = 256; // una columna por cada valor de 0 a 255
        int alto = 200;

        BufferedImage img = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);

        // Fondo blanco
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                img.setRGB(x, y, Color.WHITE.getRGB());
            }
        }

        // 0 = rojo, 1 = verde, 2 = azul
        Color color;
        if (canal == 0) color = Color.RED;
        else if (canal == 1) color = Color.GREEN;
        else color = Color.BLUE;

        // Valor max para escalar las barras
        int max = 1;
        for (int v : datos) {
            if (v > max) max = v;
        }

        // de abajo hacia arriba
        for (int x = 0; x < ancho; x++) {
            int barra = (int) ((double) datos[x] / max * (alto - 1));
            for (int y = 0; y < barra; y++) {
                img.setRGB(x, alto - 1 - y, color.getRGB());
            }
        }

        return img;
    }
}
