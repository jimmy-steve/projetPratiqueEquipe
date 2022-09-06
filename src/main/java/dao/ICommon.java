package dao;

import models.Client;
/**
 * Classe qui permet a tout les classes de transiger par cette classe pour enregistrer des données dans la base de donnée
 * @author Francis Lafontaine,Erick Solis Bedon, Gabriel Gagnon
 * @since 04/aout/2022
 */
public interface ICommon <T>{
    /**
     * Permet de sauvegarder des données
     * @param objet
     */
    void saveDonnee(T objet);

    /**
     * Pernet de sélectionnier des données
     * @param objet
     */
    void selectDonnee(T objet);

    /**
     * Permet de sélection des donnée avec un paramèetre int qui permet d'utilisé la méthode plusieurs fois
     * @param objet
     * @param i
     */
    void selectDonnee(T objet, int i);
}
