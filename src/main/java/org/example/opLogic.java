package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;

public class opLogic {
    static void main(){
        //Obtener imagenes
        BufferedImage bi1 = HerramientasImagen.toBufferedImage(HerramientasImagen.abrirImagen());
        BufferedImage bi2 = HerramientasImagen.toBufferedImage(HerramientasImagen.abrirImagen());
        //escalarlas
        BufferedImage b1s = HerramientasImagen.toBufferedImage(bi1.getScaledInstance(400, 400, 1));
        BufferedImage b2s = HerramientasImagen.toBufferedImage(bi2.getScaledInstance(400, 400, 1));

        new JFrameImagen(b1s);
        new JFrameImagen(b2s);
        //escala de grises
        BufferedImage gb1 = HerramientasImagen.RGB2GS(b1s);
        BufferedImage gb2 = HerramientasImagen.RGB2GS(b2s);

        new JFrameImagen(gb1);
        new JFrameImagen(gb2);
        //expansion lineal
        BufferedImage eb1 = HerramientasImagen.expansionLineal(gb1);
        BufferedImage eb2 = HerramientasImagen.expansionLineal(gb2);

        new JFrameImagen(eb1);
        new JFrameImagen(eb2);
        //umbral
        BufferedImage bin_b1 = HerramientasImagen.umbral(eb1, 80);
        BufferedImage bin_b2 = HerramientasImagen.umbral(eb2, 100);

        new JFrameImagen(bin_b1);
        new JFrameImagen(bin_b2);

        //logicas
        BufferedImage im_or = HerramientasImagen.or(bin_b1, bin_b2);
        new JFrameImagen(im_or);

        BufferedImage im_and = HerramientasImagen.and(bin_b1, bin_b2);
        new JFrameImagen(im_and);

        BufferedImage im_not = HerramientasImagen.not(bin_b1);
        new JFrameImagen(im_not);

        BufferedImage im_nand = HerramientasImagen.nand(bin_b1, bin_b2);
        new JFrameImagen(im_nand);

        BufferedImage im_nor = HerramientasImagen.nor(bin_b1, bin_b2);
        new JFrameImagen(im_nor);

        BufferedImage im_xor = HerramientasImagen.xor(bin_b1, bin_b2);
        new JFrameImagen(im_xor);
    }

}