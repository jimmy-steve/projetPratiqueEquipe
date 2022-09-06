package models;

import java.util.List;

/**
 * Classe POJO Commande
 * @author Erick Solis Bedon
 * @since 9 Aôut 2022
 */
public class Commande {
    private int noCommande;
    private String dateCommande;
    private int noClient;

    /**
     *
     * Pour faire un liens avec la classe Article
     * car une commande peut avoir plusieurs articles
     */
    private List<Article> listeArticles;
    /**
     * une commande peut possèder plusieurs ligne de commande
     */
    private List<LigneCommande> listeLigneCommandes;

    /**
     * Constructeur vide de commande
     */
    public Commande() {
    }

    /**
     * Constructeur avec paramètre de commande
     * @param noCommande
     * @param dateCommande
     * @param noClient
     */
    public Commande(int noCommande, String dateCommande, int noClient) {
        this.noCommande = noCommande;
        this.dateCommande = dateCommande;
        this.noClient = noClient;
    }

    /**
     * Constructeur avec paramètre de commande avec une liste d'article ainsi qu'une liste de ligne de commande
     * @param noCommande
     * @param dateCommande
     * @param noClient
     * @param listeArticles
     * @param listeLigneCommandes
     */
    public Commande(int noCommande, String dateCommande, int noClient, List<Article> listeArticles, List<LigneCommande> listeLigneCommandes) {
        this.noCommande = noCommande;
        this.dateCommande = dateCommande;
        this.noClient = noClient;
        this.listeArticles = listeArticles;
        this.listeLigneCommandes = listeLigneCommandes;
    }

    public List<LigneCommande> getListeLigneCommandes() {
        return listeLigneCommandes;
    }

    public void setListeLigneCommandes(List<LigneCommande> listeLigneCommandes) {
        this.listeLigneCommandes = listeLigneCommandes;
    }

    /**
     * Constructeur avec la liste d'article
     *
     * @param noCommande
     * @param dateCommande
     * @param noClient
     * @param listeArticles
     */
    public Commande(int noCommande, String dateCommande, int noClient, List<Article> listeArticles) {
        this.noCommande = noCommande;
        this.dateCommande = dateCommande;
        this.noClient = noClient;
        this.listeArticles = listeArticles;
    }

    public List<Article> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(List<Article> listeArticles) {
        this.listeArticles = listeArticles;
    }

    public int getNoCommande() {
        return noCommande;
    }

    public void setNoCommande(int noCommande) {
        this.noCommande = noCommande;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getNoClient() {
        return noClient;
    }

    public void setNoClient(int noClient) {
        this.noClient = noClient;
    }

    /**
     * Le ToString de Commande
     * @return
     */
    @Override
    public String toString() {
        return "Commande{" +
                "noCommande=" + noCommande +
                ", dateCommande='" + dateCommande + '\'' +
                ", noClient=" + noClient +
                ", listeArticles=" + listeArticles +
                ", listeLigneCommandes=" + listeLigneCommandes +
                '}';
    }
}
