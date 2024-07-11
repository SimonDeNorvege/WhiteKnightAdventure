package Sprite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Représente un ensemble de sprites pour un personnage ou un objet dans un jeu.
 * Cette classe gère le chargement et le stockage des images des sprites.
 */
public class Sprite {

    /** Le chemin du fichier des sprites. */
    private String filePath;

    /** Liste des images de frames. */
    private ArrayList<BufferedImage> frameList;

    /** Image utilisée en cas d'erreur lors du chargement des frames. */
    private BufferedImage error;

    /** La taille (longueur) des frames. */
    private int length;

    /** La largeur des frames dans l'image. */
    private int width;

    /**
     * Constructeur de la classe Sprite.
     *
     * @param filePath le chemin du fichier contenant les images de sprites
     * @param length   la taille (longueur) de chaque frame
     * @param width    la largeur des frames dans l'image
     */
    public Sprite(String filePath, int length, int width) {
        this.frameList = new ArrayList<BufferedImage>();
        this.filePath = filePath;
        this.length = length;
        this.width = width;
        this.error = loadFrame("error.png");

        buildSprite();
    }

    /**
     * Construit le sprite en chargeant et découpant l'image source en frames individuels.
     */
    private void buildSprite() {
        try {
            // Charger l'image des sprites
            BufferedImage sourceImage = loadFrame(this.filePath);
            if (sourceImage == null) {
                // Si l'image est null, utiliser l'image d'erreur pour le cas d'échec
                frameList.add(error);
            } else {
                // Découper l'image en frames individuels et les ajouter à la liste
                frameList.addAll(SpriteBuilder.spriteCut(sourceImage, width, length));
                frameList.add(sourceImage);
            }
        } catch (Exception e) {
            // En cas d'exception lors du chargement ou de la découpe, ajouter l'image d'erreur
            frameList.add(error);
            e.printStackTrace();
        }
    }

    /**
     * Charge l'image du sprite, peut échouer, dans ce cas, chargera une image d'erreur.
     *
     * @param filePath le chemin du fichier de l'image
     * @return l'image du sprite, ou null en cas d'échec
     */
    public static BufferedImage loadFrame(String filePath) {
        BufferedImage sourceImage = null;

        try {
            sourceImage = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement de l'image " + filePath);
            return null;

        }
        catch (NullPointerException f)
        {
            System.out.println("Mauvais chemin de l'image " + filePath);
            return null;
        }
        return sourceImage;
    }

    /**
     * Obtient la liste des images de frames.
     *
     * @return la liste des images de frames
     */
    public ArrayList<BufferedImage> getFrameList() {
        return frameList;
    }

    /**
     * Obtient la largeur des frames dans l'image.
     *
     * @return la largeur des frames
     */
    public int getWidth() {
        return width;
    }

    /**
     * Obtient la longueur de chaque frame.
     *
     * @return la longueur des frames
     */
    public int getLength() {
        return length;
    }
}
