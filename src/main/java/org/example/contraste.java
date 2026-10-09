package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;

public class contraste {
    static void main() {
        BufferedImage bi = HerramientasImagen.toBufferedImage(HerramientasImagen.abrirImagen());
        BufferedImage bi_gs = HerramientasImagen.RGB2GS(bi);

        new JFrameImagen(bi_gs);
        new JFrameImagen(HerramientasImagen.crearHistograma(bi_gs, 0));

        BufferedImage bi2 = HerramientasImagen.expansionLineal(bi_gs);
        new JFrameImagen(HerramientasImagen.toImage(bi2));
        new JFrameImagen(HerramientasImagen.crearHistograma(bi2, 0));

        new JFrameImagen(HerramientasImagen.toImage(HerramientasImagen.umbral(bi2, 100)));
    }

}
