package model;

/**
 * Aceasta clasa reprezinta tabelul "product" din baza de date cu atributele specifice: id, nume, pret si stocul disponibil
 */
public class Product {
    private int idProduct;
    private String name;
    private int price;
    private int stock;

    /**
     * Constructorul creeaza obiecte noi utilizand toate atributele clasei Product
     *
     * @param idProduct reprezinta identificatorul unic al unui produs
     * @param name reprezinta numele produsului
     * @param price reprezinta pretul produsului
     * @param stock reprezinta stocul disponibil pentru produs
     */
    public Product(int idProduct, String name, int price, int stock){
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     *
     * @return id-ul produsului
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     *
     * @return numele produsului
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return pretul produsului
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @return stocul disponibil pentru produs
     */
    public int getStock() {
        return stock;
    }
}
