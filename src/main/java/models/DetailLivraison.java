package models;

/**
 * Clase POJO pur detail livraison
 * @author Gabriel Gagnon
 *  * @since 9 Aôut 2022
 */
public class DetailLivraison {
    private int noLivraison;
    private int noCommande;
    private int noArticle;
    private int quantiteLivree;

    /**
     * constructeur vide pour detail livraison
     */
    public DetailLivraison() {
    }

    /**
     * Constructeur avec paramèetre pour detail Livraison
     * @param noLivraison
     * @param noCommande
     * @param noArticle
     * @param quantiteLivree
     */
    public DetailLivraison(int noLivraison, int noCommande, int noArticle, int quantiteLivree) {
        this.noLivraison = noLivraison;
        this.noCommande = noCommande;
        this.noArticle = noArticle;
        this.quantiteLivree = quantiteLivree;
    }

    public int getNoLivraison() {
        return noLivraison;
    }

    public void setNoLivraison(int noLivraison) {
        this.noLivraison = noLivraison;
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

    public int getQuantiteLivree() {
        return quantiteLivree;
    }

    public void setQuantiteLivree(int quantiteLivree) {
        this.quantiteLivree = quantiteLivree;
    }

    /**
     * Le TOString de Detail Livraison
     * @return
     */
    @Override
    public String toString() {
        return "DetailLivraison{" +
                "noLivraison=" + noLivraison +
                ", noCommande=" + noCommande +
                ", noArticle=" + noArticle +
                ", quantiteLivree=" + quantiteLivree +
                '}';
    }
}
