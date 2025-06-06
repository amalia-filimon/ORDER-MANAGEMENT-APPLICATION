package model;

/**
 * Aceasta clasa reprezinta tabelul "client" din baza de date cu atributele specifice: id, nume, adresa, email
 */
public class Client {
    private int idClient;
    private String name;
    private String address;
    private String email;

    /**
     * Constructorul creeaza obiecte noi utilizand toate atributele clasei Client
     *
     * @param idClient reprezinta identificatorul unic al unui client
     * @param name reprezinta numele unui client
     * @param address reprezinta adresa la care locuieste clientul
     * @param email reprezinta adresa de email al clientului
     */
    public Client(int idClient, String name, String address, String email) {
        this.idClient = idClient;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    /**
     * @return id-ul clientului
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     *
     * @return numele clientului
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return adresa clientului
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return emailul clientului
     */
    public String getEmail() {
        return email;
    }
}