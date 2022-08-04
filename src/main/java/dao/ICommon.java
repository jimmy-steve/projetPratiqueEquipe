package dao;

import models.Client;
/**
 * @author Francis Lafontaine
 * @since 04/aout/2022
 */
public interface ICommon <T>{
    void saveDonnee(T objet);
    void selectDonnee(T objet);
}
