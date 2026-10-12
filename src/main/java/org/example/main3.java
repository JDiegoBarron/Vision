package org.example;

import java.awt.image.BufferedImage;

public class main3 {
    static void main(){
        BufferedImage bi1 = HerramientasImagen.toBufferedImage(HerramientasImagen.abrirImagen());

        BufferedImage b1s = HerramientasImagen.toBufferedImage(bi1.getScaledInstance(400, 400, 1));

        BufferedImage b2 = HerramientasImagen.rotar(b1s, 30);
        new JFrameImagen(b2);

        BufferedImage b3 = HerramientasImagen.trasladar(b1s, 50, 50);
        new JFrameImagen(b3);
    }
}
