package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;

public class contraste {
    static void main() {
        Image imagenjeje = HerramientasImagen.abrirImagen();
        BufferedImage bi = HerramientasImagen.toBufferedImage(imagenjeje);
        BufferedImage bi_gs = HerramientasImagen.RGB2GS(bi);
        new JFrameImagen(bi_gs);
        new JFrameImagen(HerramientasImagen.crearHistograma(bi_gs, 0));

        Image im2 = HerramientasImagen.abrirImagen();
        BufferedImage bi2 = HerramientasImagen.toBufferedImage(im2);
        BufferedImage bi_gs_2 = HerramientasImagen.RGB2GS(bi2);
        new JFrameImagen(bi_gs_2);
        new JFrameImagen(HerramientasImagen.crearHistograma(bi_gs_2, 0));
    }
}
