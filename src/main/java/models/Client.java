package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Francis Lafontaine
 * @since 04/aout/2022
 */
public class Client {
    private int noClient;
    private String nomClient;
    private String noTelephone;
    /**
     *
     */
    public static Set<Client> listeClients ;

    /**
     * Pour faire la référence avec les commandes
     * on a une liste de commande car un client peut avoir plusieurs commandes
     */
    private List<Commande> listeCommandes;

    /**
     * Constructeur Avec les les liste de commande
     * @param noClient
     * @param nomClient
     * @param noTelephone
     * @param listeCommandes
     */
    public Client(int noClient, String nomClient, String noTelephone, List<Commande> listeCommandes) {
        this.noClient = noClient;
        this.nomClient = nomClient;
        this.noTelephone = noTelephone;
        this.listeCommandes = listeCommandes;
    }

    /**
     * Constructeur vide pour client
     */
    public Client() {
    }

    /**
     * constructeur avec paramètre pour le client
     * @param noClient
     * @param nomClient
     * @param noTelephone
     */
    public Client(int noClient, String nomClient, String noTelephone) {
        this.noClient = noClient;
        this.nomClient = nomClient;
        this.noTelephone = noTelephone;

    }
    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }

    public void setListeCommandes(List<Commande> listeCommandes) {
        this.listeCommandes = listeCommandes;
    }

    public int getNoClient() {
        return noClient;
    }

    public void setNoClient(int noClient) {
        this.noClient = noClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getNoTelephone() {
        return noTelephone;
    }

    public void setNoTelephone(String noTelephone) {
        this.noTelephone = noTelephone;
    }

    /**
     * Le toTsring pour le client
     * @return
     */
    @Override
    public String toString() {
        return "Client{" +
                "noClient=" + noClient +
                ", nomClient='" + nomClient + '\'' +
                ", noTelephone='" + noTelephone + '\'' +
                '}';
    }
}
