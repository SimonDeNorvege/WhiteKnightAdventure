package Sprite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe utilitaire pour créer et manipuler des sprites.
 */
public final class SpriteBuilder {

    static int spriteSize = 32;
    static boolean error = false;

    // Constructeur privé pour empêcher l'instanciation
    private SpriteBuilder() {
        throw new UnsupportedOperationException("Cette classe ne peut pas être instanciée.");
    }


    public static ArrayList<BufferedImage> createSprite(String filePath, int width, int length) {
        return null;

        // Charger et découper les sprites à partir du dossier

    }

    /**
     * Assigne une image source découpée à une liste de sprites.
     *
     * @param list   la liste de sprites à laquelle ajouter les sprites découpés
     * @param srcImg l'image source à découper
     */
    public static void assignSprite(ArrayListNavigator<BufferedImage> list, BufferedImage srcImg) {
        if (srcImg == null) {
            try {
                list.addElement(ImageIO.read(new File("/error.png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            ArrayList<BufferedImage> sprites = spriteCut(srcImg, spriteSize, spriteSize);
            for (BufferedImage s : sprites) {
                list.addElement(s);
            }
        }
    }



    /**
     * Découpe l'image source en une liste de sprites individuels.
     *
     * @param imgSrc    l'image source
     * @param rowSize   le nombre de lignes de sprites
     * @param spriteSize la taille de chaque sprite
     * @return une liste d'images découpées
     */
    public static ArrayList<BufferedImage> spriteCut(BufferedImage imgSrc, int rowSize, int spriteSize) {
        ArrayList<BufferedImage> sprites = new ArrayList<>();

        int columns = imgSrc.getWidth() / spriteSize;
        int rows = rowSize;

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                BufferedImage sprite = imgSrc.getSubimage(x * spriteSize, y * spriteSize, spriteSize, spriteSize);
                sprites.add(sprite);
            }
        }

        return sprites;
    }
}
