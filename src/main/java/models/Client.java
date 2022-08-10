package models;

/**
 * @author Francis Lafontaine
 * @since 04/aout/2022
 */
public class Client {
    private int noClient;
    private String nomClient;
    private String noTelephone;

    /**
     * Constructeur vide pour client
     */
    public Client() {
    }

    /**
     * constructeur avec paramèetre pour le client
     * @param noClient
     * @param nomClient
     * @param noTelephone
     */
    public Client(int noClient, String nomClient, String noTelephone) {
        this.noClient = noClient;
        this.nomClient = nomClient;
        this.noTelephone = noTelephone;
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
