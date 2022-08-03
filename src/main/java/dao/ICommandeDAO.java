package dao;

import models.Commande;

public interface ICommandeDAO {

    Commande getCommandeById(int id);
    void saveCommande(Commande commande);
}
