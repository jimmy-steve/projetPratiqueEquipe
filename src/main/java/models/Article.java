package models;
/**
 * @author Francis Lafontaine
 * @since 04/aout/2022
 */
public class Article {
    private int noArticle;
    private String description;
    private double prixUnitaire;
    private int quantite;

    public Article() {
    }

    public Article(int noArticle, String description, double prixUnitaire, int quantite) {
        this.noArticle = noArticle;
        this.description = description;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
    }

    public int getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(int noArticle) {
        this.noArticle = noArticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Article{" +
                "noArticle=" + noArticle +
                ", description='" + description + '\'' +
                ", prixUnitaire=" + prixUnitaire +
                ", quantite=" + quantite +
                '}';
    }
}
