package Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe fournit des fonctionnalités de navigation sur une ArrayList.
 * Elle permet d'ajouter des éléments, d'obtenir l'élément actuel, de passer à l'élément suivant,
 * de vérifier s'il y a un élément suivant, et de réinitialiser la navigation.
 *
 * @param <T> le type des éléments dans ce navigateur
 */
public class ArrayListNavigator<T> {
    private List<T> list;
    private int currentIndex;

    /**
     * Construit un ArrayListNavigator vide.
     */
    public ArrayListNavigator() {
        this.list = new ArrayList<>();
        this.currentIndex = 0;
    }

    /**
     * Ajoute un élément à la liste.
     *
     * @param element l'élément à ajouter
     */
    public void addElement(T element) {
        list.add(element);
    }

    /**
     * Vérifie s'il y a un élément suivant dans la liste.
     *
     * @return true s'il y a un élément suivant, false sinon
     */
    public boolean hasNext() {
        return currentIndex < list.size() - 1;
    }

    /**
     * Obtient l'élément actuel dans la liste.
     *
     * @return l'élément actuel, ou null si la liste est vide
     */
    public T getCurrentElement() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(currentIndex);
    }

    /**
     * Passe à l'élément suivant dans la liste et le retourne.
     *
     * @return l'élément suivant, ou null s'il n'y a pas d'élément suivant
     */
    public T getNextElement() {
        if (hasNext()) {
            currentIndex++;
            return list.get(currentIndex);
        }
        return null;
    }

    /**
     * Réinitialise l'index à 0.
     */
    public void reset() {
        currentIndex = 0;
    }

    /**
     * Retourne la taille de la liste.
     *
     * @return la taille de la liste
     */
    public int size() {
        return list.size();
    }
}
