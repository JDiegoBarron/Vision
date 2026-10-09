package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author working
 */
public class HerramientasImagen {

    public static Image abrirImagen (){

        try {
            // definir los filtros para lectura
            FileNameExtensionFilter filtro =
                    new FileNameExtensionFilter("Imagenes","jpg","jpeg","png","bmp");
            // crear un selector de archivos
            JFileChooser selector = new JFileChooser();
            // agregar el filtro al selector
            selector.addChoosableFileFilter(filtro);
            // especificar que solo se puedan abrir archivos
            selector.setFileSelectionMode(JFileChooser.FILES_ONLY);

            //ejecutar el selector de imagenes

            int res = selector.showOpenDialog(null);

            if (res == 1 ){

                return null;

            }

            File archivo = selector.getSelectedFile();

            BufferedImage bi = ImageIO.read(archivo);

            return toImage(bi);
        } catch (IOException ex) {
            Logger.getLogger(HerramientasImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static Image toImage (BufferedImage bi){
        return bi.getScaledInstance(bi.getWidth(),bi.getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    public static BufferedImage toBufferedImage (Image imagen){
        // imagen es un objeto de tipo BufferedImage
//        if (imagen instanceof BufferedImage){
//          return (BufferedImage)imagen;
//        }
        BufferedImage bi =
                new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_RGB);

        Graphics2D nueva = bi.createGraphics();
        nueva.drawImage(imagen, 0, 0,null);
        nueva.dispose();

        return bi;
    }
    public static Image copiarImagen(Image i){
        BufferedImage bi = toBufferedImage(i);
        return bi.getScaledInstance(bi.getWidth(),bi.getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    public static BufferedImage RGB2GS(BufferedImage im) {
        // Crear una nueva BufferedImage con el mismo tamaño pero en tipo escala de grises
        BufferedImage grayImage = new BufferedImage(
                im.getWidth(),
                im.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY
        );

        // Dibujar la imagen original sobre la nueva imagen en grises
        Graphics g = grayImage.getGraphics();
        g.drawImage(im, 0, 0, null);
        g.dispose();

        return grayImage;
    }

    public static BufferedImage crearHistograma(BufferedImage imagen, int canal) {
        int[] datos = new int[256];

        for (int x = 0; x < imagen.getWidth(); x++) {
            for (int y = 0; y < imagen.getHeight(); y++) {
                Color colorPixel = new Color(imagen.getRGB(x, y));

                if (canal == 0) {
                    datos[colorPixel.getRed()]++;
                } else if (canal == 1) {
                    datos[colorPixel.getGreen()]++;
                } else {
                    datos[colorPixel.getBlue()]++;
                }
            }
        }

        int ancho = 256;
        int alto = 200;

        BufferedImage imgHistograma = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                imgHistograma.setRGB(x, y, Color.WHITE.getRGB());
            }
        }

        Color colorBarra;
        if (canal == 0) colorBarra = Color.RED;
        else if (canal == 1) colorBarra = Color.GREEN;
        else colorBarra = Color.BLUE;

        int max = 1;
        for (int v : datos) {
            if (v > max) max = v;
        }

        for (int x = 0; x < ancho; x++) {
            int alturaBarra = (int) ((double) datos[x] / max * (alto - 1));
            for (int y = 0; y < alturaBarra; y++) {
                imgHistograma.setRGB(x, alto - 1 - y, colorBarra.getRGB());
            }
        }

        return imgHistograma;
    }

    public static BufferedImage expansionLineal(BufferedImage bi) {
        int w = bi.getWidth();
        int h = bi.getHeight();

        int min = 255;
        int max = 0;

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                //[Alpha][Rojo][Verde][Azul]
                //al desplazar 16 bits, 2 bytes
                //[Nada][Nada][Alpha][Rojo]
                //Despues de la mascara 0xFF = 255 = 0000 1111
                //[Nada][Nada][Nada][Rojo}
                int valor = (bi.getRGB(x, y) >> 16) & 0xFF;

                if (valor < min) min = valor;
                if (valor > max) max = valor;
            }
        }

        // Si la imagen es totalmente plana (min == max) no se puede expandir
        if (max == min) {
            return bi;
        }

        BufferedImage resultado = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                int valorOriginal = (bi.getRGB(x, y) >> 16) & 0xFF;

                // Mapeo lineal al rango [0, 255]
                int nuevoValor = (int) (((double) (valorOriginal - min) / (max - min)) * 255);

                // Reconstruir el color en formato ARGB de 32 bits
                int pixelGris = (0xFF << 24) | (nuevoValor << 16) | (nuevoValor << 8) | nuevoValor;
                resultado.setRGB(x, y, pixelGris);
            }
        }

        return resultado;
    }

    public static BufferedImage umbral(BufferedImage bi, int u) {
        int w = bi.getWidth();
        int h = bi.getHeight();

        BufferedImage im = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                Color colorPixel = new Color(bi.getRGB(x, y));
                int valorGris = colorPixel.getRed();

                if (valorGris < u) {
                    im.setRGB(x, y, Color.BLACK.getRGB());
                } else {
                    im.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }
        return im;
    }
}