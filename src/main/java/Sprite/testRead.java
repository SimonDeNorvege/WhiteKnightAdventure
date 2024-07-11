package Sprite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class testRead {


    // Autres parties de la classe

    /**
     * Charge l'image du sprite, peut échouer, dans ce cas, chargera une image d'erreur.
     *
     * @param filePath le chemin du fichier de l'image
     * @return l'image du sprite, ou null en cas d'échec
     */
    public static BufferedImage testImg(String filePath) {
        BufferedImage sourceImage = null;

        try {
            File imgFile = new File(filePath);
            if (!imgFile.exists()) {
                System.out.println("Le fichier n'existe pas : " + filePath);
                return null;
            }
            if (!imgFile.canRead()) {
                System.out.println("Impossible de lire le fichier : " + filePath);
                return null;
            }

            sourceImage = ImageIO.read(imgFile);
            if (sourceImage == null) {
                System.out.println("Le fichier n'est pas une image valide : " + filePath);
                return null;
            }
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement de l'image " + filePath);
            e.printStackTrace();
            return null;
        }

        return sourceImage;
    }

    // Autres parties de la classe
}
