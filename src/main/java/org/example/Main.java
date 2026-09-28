package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Main {
    static void main() {
        Image imagenjeje = HerramientasImagen.abrirImagen();
        new JFrameImagen(imagenjeje);

        BufferedImage bimagenjeje = HerramientasImagen.toBufferedImage(imagenjeje);
        Color verde = new Color(60, 149, 14);
        Color azul = new Color(0, 85, 184);
        Color rojo = new Color(216, 0, 0);
        Color blanco = new Color(255, 255, 255);
        Color cafe = new Color(99, 67, 13);

        for(int j = 0; j<200; j++){
            for(int k = 0; k<200; k++){
                bimagenjeje.setRGB(j, k, verde.getRGB());
            }
        }

        Image imagen2 = HerramientasImagen.toImage(bimagenjeje);
        new JFrameImagen(imagen2);

        int altura = bimagenjeje.getHeight();
        int ancho = bimagenjeje.getWidth();
//////////////////////
        bimagenjeje = HerramientasImagen.toBufferedImage(imagenjeje);
        for(int i = 0; i<ancho; i++){
            for(int j = 0; j<altura; j++){
                Color aux = new Color(bimagenjeje.getRGB(i, j));
                int r = aux.getRed();
                Color col = new Color(r, 0, 0);
                bimagenjeje.setRGB(i, j, col.getRGB());
            }
        }

        Image imagen5 = HerramientasImagen.toImage(bimagenjeje);
        new JFrameImagen(imagen5);
//////////////////////
        bimagenjeje = HerramientasImagen.toBufferedImage(imagenjeje);
        for(int i = 0; i<ancho; i++){
            for(int j = 0; j<altura; j++){
                Color aux = new Color(bimagenjeje.getRGB(i, j));
                int r = aux.getRed();
                Color col = new Color(r, 0, 0);
                bimagenjeje.setRGB(i, j, col.getRGB());
            }
        }

        Image imagen6 = HerramientasImagen.toImage(bimagenjeje);
        new JFrameImagen(imagen6);
/// ///////////////////

        bimagenjeje = HerramientasImagen.toBufferedImage(imagenjeje);
        for(int j = 0; j<200; j++){
            for(int k = 0; k<altura; k++){
                bimagenjeje.setRGB(j, k, azul.getRGB());
            }
        }

        for(int j = ancho-200; j<ancho; j++){
            for(int k = 0; k<altura; k++){
                bimagenjeje.setRGB(j, k, rojo.getRGB());
            }
        }

        Image imagen3 = HerramientasImagen.toImage(bimagenjeje);
        new JFrameImagen(imagen3);
/// /////////////
        for(int j = 0; j<200; j++){
            for(int k = 0; k<altura; k++){
                bimagenjeje.setRGB(j, k, verde.getRGB());
            }
        }

        for(int j = ancho-200; j<ancho; j++){
            for(int k = 0; k<altura; k++){
                bimagenjeje.setRGB(j, k, rojo.getRGB());
            }
        }

        for(int j = 200; j<ancho-200; j++){
            for(int k = 0; k<altura; k++){
                bimagenjeje.setRGB(j, k, blanco.getRGB());
            }
        }

        int i0 = ancho/2;
        int j0 = altura/2;

        for(int i = 0; i<ancho; i++){
            for(int j = 0; j<altura; j++){
                double r = sqrt((pow((i-i0), 2) + pow((j-j0), 2)));
                if (r <= 70){
                    bimagenjeje.setRGB(i, j, cafe.getRGB());
                }
            }
        }

        Image imagen4 = HerramientasImagen.toImage(bimagenjeje);
        new JFrameImagen(imagen4);
    }
}
