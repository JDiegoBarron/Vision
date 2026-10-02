package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.example.HerramientasImagen.crearHistograma;

public class Main2 {
    static void main(){
        Image imagenjeje = HerramientasImagen.abrirImagen();
        BufferedImage bi = HerramientasImagen.toBufferedImage(imagenjeje);

        BufferedImage histR = crearHistograma(bi, 0);
        BufferedImage histG = crearHistograma(bi, 1);
        BufferedImage histB = crearHistograma(bi, 2);

        new JFrameImagen(histR);
        new JFrameImagen(histG);
        new JFrameImagen(histB);
        new JFrameImagen(imagenjeje);
    }
}
