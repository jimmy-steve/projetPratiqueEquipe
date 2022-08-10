package dao;

import models.Client;
/**
 * Classe qui permet a tout les classes de transiger par cette classe pour enregistrer des données dans la base de donnée
 * @author Francis Lafontaine
 * @since 04/aout/2022
 */
public interface ICommon <T>{
    void saveDonnee(T objet);
    void selectDonnee(T objet);
    void selectDonnee(T objet, int i);
}
