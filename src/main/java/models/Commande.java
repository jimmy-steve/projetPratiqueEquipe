package models;

public class Commande {

    private int noCommande;
    private String dateCommande;
    private int noClient;

    public Commande() {
    }

    public Commande(int noCommande, String dateCommande, int noClient) {
        this.noCommande = noCommande;
        this.dateCommande = dateCommande;
        this.noClient = noClient;
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

    @Override
    public String toString() {
        return "Commande{" +
                "noCommande=" + noCommande +
                ", dateCommande='" + dateCommande + '\'' +
                ", noClient=" + noClient +
                '}';
    }


}
