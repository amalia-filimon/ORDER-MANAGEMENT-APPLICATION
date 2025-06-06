package businessLogic;
import dataAccess.ProductDAO;
import model.Product;

import java.util.List;

/**
 * In aceasta clasa sunt create metode care apeleaza toate metodele care efectueaza operatii asupra tabelului "product" din baza de date, cum ar fi: insert, delete, edit, view, getStock, updateStock, getPrice
 */
public class ProductBLL {

    /**
     *
     * @param product reprezinta parametrul cu care se apeleaza metoda "insert" din clasa "ProductDAO"
     * @see ProductDAO
     */
    public void insertProduct(Product product){
        ProductDAO.insert(product);
    }

    /**
     *
     * @param idProduct reprezinta identificatorul unic cu care se apeleaza metoda "delete" din clasa "ProductDAO"
     * @see ProductDAO
     */
    public void deleteProduct(int idProduct){
        ProductDAO.delete(idProduct);
    }

    /**
     *
     * @param id reprezinta identificatorul unic cu care se apeleaza metoda "edit" din clasa "ProductDAO"
     * @param stock reprezinta stocul disponibil cu care se apeleaza metoda "edit" din clasa "ProductDAO"
     * @see ProductDAO
     */
    public void editProduct(int id, int stock){
        ProductDAO.edit(id, stock);
    }

    /**
     *
     * @return lista de clienti returnata de metoda "view" din clasa "ProductDAO"
     * @see ProductDAO
     */
    public List<Product> viewProducts(){
        return ProductDAO.view();
    }

    /**
     *
     * @param name reprezinta numele cu care este apelata metoda "getStock" din clasa "ProductDAO"
     * @return o valoare intreaga care reprezinta stocul disponibil dintr-un produs
     * @see ProductDAO
     */
    public int getStock(String name){
        return ProductDAO.getStock(name);
    }

    /**
     *
     * @param newStock reprezinta noul stoc cu care se apeleaza metoda "updateStock" din clasa "ProductDAO"
     * @param name reprezinta numele produsului cu care se apeleaza metoda "updateStock" din clasa "ProductDAO"
     * @see ProductDAO
     */
    public void updateStock(int newStock, String name){
        ProductDAO.updateStock(newStock, name);
    }

    /**
     *
     * @param name reprezinta numele cu care este apelata metoda "getPrice" din clasa "ProductDAO"
     * @return o valoare intreaga care reprezinta pretul unui produs
     * @see ProductDAO
     */
    public int getPrice(String name){
        return ProductDAO.getPrice(name);
    }
}
