package model;

/**
 * Aceasta clasa reprezinta tabelul "order" din baza de date cu atributele specifice: id, nume client, nume produs si cantitatea care se comanda dintr-un anumit produs
 */
public class Order {
    private int idOrder;
    private String clientName;
    private String productName;
    private int quantity;

    /**
     * Constructorul creeaza obiecte noi utilizand toate atributele clasei Order
     *
     * @param idOrder reprezinta identificatorul unic al comenzii
     * @param clientName reprezinta numele clientului care face comanda
     * @param productName reprezinta numele produsului comandat
     * @param quantity reprezinta cantitatea care se comanda din produsul selectat
     */
    public Order(int idOrder, String clientName, String productName, int quantity){
        this.idOrder = idOrder;
        this.clientName = clientName;
        this.productName = productName;
        this.quantity = quantity;
    }

    /**
     *
     * @return id-ul comenzii
     */
    public int getIdOrder() {
        return idOrder;
    }

    /**
     *
     * @return numele clientului care face comanda
     */
    public String getClientName() {
        return clientName;
    }

    /**
     *
     * @return numele produsului comandat
     */
    public String getProductName() {
        return productName;
    }

    /**
     *
     * @return cantitatea care se comanda din produsul selectat
     */
    public int getQuantity() {
        return quantity;
    }

}
