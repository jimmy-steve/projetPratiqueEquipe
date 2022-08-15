package models;

/**
 * Classe POJO Ligne commande
 * @author Erick Solis Bedon
 */
public class LigneCommande {
    private int noCommande;
    private int noArticle;
    private int quantite;

    /**
     * Constructeur vide pour ligne de commande
     */
    public LigneCommande() {
    }

    /**
     * Constructeur avec paramètre de Ligne de commande
     * @param noCommande
     * @param noArticle
     * @param quantite
     */
    public LigneCommande(int noCommande, int noArticle, int quantite) {
        this.noCommande = noCommande;
        this.noArticle = noArticle;
        this.quantite = quantite;
    }

    public int getNoCommande() {
        return noCommande;
    }

    public void setNoCommande(int noCommande) {
        this.noCommande = noCommande;
    }

    public int getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(int noArticle) {
        this.noArticle = noArticle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * Le To String de Ligne de commande
     * @return
     */
    @Override
    public String toString() {
        return "LigneCommande{" +
                "noCommande=" + noCommande +
                ", noArticle=" + noArticle +
                ", quantite=" + quantite +
                '}';
    }
}
