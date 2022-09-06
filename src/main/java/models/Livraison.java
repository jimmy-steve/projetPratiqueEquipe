package models;

/**
 * Classe POJO de LIvraison
 * @author Gabriel Gagnon
 * @since 9 Aôut 2022
 */
public class Livraison {
    private int noLivraison;
    private String dateLivraison;
    /**
     * Une livraison possèdent un détail de livraison
     */
    private DetailLivraison detailLivraison;

    /**
     * constructeur vide de livraison
     */
    public Livraison() {
    }

    /**
     * le constructeur avec paramèetre de Livraison
     *
     * @param noLivraison
     * @param dateLivraison
     */
    public Livraison(int noLivraison, String dateLivraison) {
        this.noLivraison = noLivraison;
        this.dateLivraison = dateLivraison;
    }

    /**
     * Constructeur avec paramètre et l'objet detail livraison
     * @param noLivraison
     * @param dateLivraison
     * @param detailLivraison
     */
    public Livraison(int noLivraison, String dateLivraison, DetailLivraison detailLivraison) {
        this.noLivraison = noLivraison;
        this.dateLivraison = dateLivraison;
        this.detailLivraison = detailLivraison;
    }

    public DetailLivraison getDetailLivraison() {
        return detailLivraison;
    }

    public void setDetailLivraison(DetailLivraison detailLivraison) {
        this.detailLivraison = detailLivraison;
    }

    public int getNoLivraison() {
        return noLivraison;
    }

    public void setNoLivraison(int noLivraison) {
        this.noLivraison = noLivraison;
    }

    public String getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    /**
     *  Le Tostring de lIVRAISON
     * @return
     */
    @Override
    public String toString() {
        return "Livraison{" +
                "noLivraison=" + noLivraison +
                ", dateLivraison='" + dateLivraison + '\'' +
                ", detailLivraison=" + detailLivraison +
                '}';
    }
}
