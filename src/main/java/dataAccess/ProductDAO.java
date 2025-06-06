package dataAccess;

import connection.ConnectionFactory;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Aceasta clasa permite inserarea, stergerea, modificarea unui produs, respectiv selectarea tuturor produselor din baza de date, a stocului si a pretului disponibil pentru un anumit produs si, de asemenea, permite modificarea stocului pentru un produs anume
 */
public class ProductDAO {
    protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO product (idProduct, name, price, stock)" + " VALUES(?, ?, ?, ?)";
    private static final String deleteStatementString = "DELETE FROM product WHERE idProduct = ?";
    private static final String editStatementString = "UPDATE product SET stock = ? WHERE idProduct = ?";
    private static final String viewAllStatementString = "SELECT * FROM product";
    private static final String getStockStatementString = "SELECT * FROM product WHERE name = ?";
    private static final String updateStockStatementString = "UPDATE product SET stock = ? WHERE name = ?";
    private static final String getPriceStatementString = "SELECT price FROM product WHERE name = ?";

    /**
     * Aceasta este metoda care insereaza un produs dat, ca parametru, in baza de date
     *
     * @param product este caracterizat prin id, nume, pret si stoc si reprezinta noul produs care se va insera in baza de date
     */
    public static void insert(Product product) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, product.getIdProduct());
            insertStatement.setString(2, product.getName());
            insertStatement.setInt(3, product.getPrice());
            insertStatement.setInt(4, product.getStock());
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Aceasta metoda sterge un produs din baza de date in functie de id - ul pe care il primeste
     *
     * @param idProduct este identificatorul unic al produsului care se vrea a fi sters din baza de date
     */
    public static void delete(int idProduct) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setInt(1, idProduct);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO: delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Aceasta metoda stocul dintr - un anumit produs identificat prin id
     *
     * @param id reprezinta identificatorul unic al produsului al carui stoc se va modifica
     * @param stock reprezinta noul stock cu care se va actualiza baza de date
     */
    public static void edit(int id, int stock){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement editStatement = null;
        try{
            editStatement = dbConnection.prepareStatement(editStatementString, Statement.RETURN_GENERATED_KEYS);
            editStatement.setInt(1, stock);
            editStatement.setInt(2, id);
            editStatement.executeUpdate();
        }catch(SQLException e){
            LOGGER.log(Level.WARNING, "ProductDAO: edit " + e.getMessage());
        }finally{
            ConnectionFactory.close(editStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Aceasta metoda selecteaza toate produsele existente in baza de date si le pune intr - o lista de produse
     *
     * @return Acea lista de produse creata atunci cand se returneaza toate produsele din baza de date
     */
    public static List<Product> view(){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement viewStatement = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<>();
        try{
            viewStatement = dbConnection.prepareStatement(viewAllStatementString);
            rs = viewStatement.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("idProduct");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");

                Product p = new Product(id, name, price, stock);
                products.add(p);
            }
        }catch(SQLException e){
            LOGGER.log(Level.WARNING, "ProductDAO: view " + e.getMessage());
        }finally{

            ConnectionFactory.close(rs);
            ConnectionFactory.close(viewStatement);
            ConnectionFactory.close(dbConnection);
        }
        return products;
    }

    /**
     * Aceasta metoda selecteaza stocul disponibil pentru un produs cu un anumit nume dat ca parametru metodei
     *
     * @param name reprezinta numele produsului caruia i se va selecta stocul din baza de date
     * @return un numar intreg reprezentand stocul produsului identificat prin parametrul "name"
     */
    public static int getStock(String name){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement getStockStatement = null;
        ResultSet rs = null;
        int stock = 0;
        try{
            getStockStatement = dbConnection.prepareStatement(getStockStatementString, Statement.RETURN_GENERATED_KEYS);
            getStockStatement.setString(1, name);
            rs = getStockStatement.executeQuery();
            rs.next();

            stock = rs.getInt("stock");

        }catch(SQLException e){
            LOGGER.log(Level.WARNING, "ProductDAO: getStock " + e.getMessage());
        }finally{
            ConnectionFactory.close(rs);
            ConnectionFactory.close(getStockStatement);
            ConnectionFactory.close(dbConnection);
        }

        return stock;
    }

    /**
     * Aceasta metoda modifica stocul unui produs identificat prin nume(este folosita atunci cand se creeaza o noua comanda, iar stocul produsului comandat trebuie decrementat cu valoarea cantitatii comandate)
     *
     * @param newStock reprezinta noul stoc cu care se actualizeaza baza de date
     * @param name reprezinta identificatorul produsului al carui stoc se va actualiza
     */
    public static void updateStock(int newStock, String name){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStockStatement = null;
        try{
            updateStockStatement = dbConnection.prepareStatement(updateStockStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStockStatement.setInt(1, newStock);
            updateStockStatement.setString(2, name);
            updateStockStatement.executeUpdate();
        }catch(SQLException e){
            LOGGER.log(Level.WARNING, "ProductDAO: updateStock " + e.getMessage());
        }finally{
            ConnectionFactory.close(updateStockStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Aceasta metoda selecteaza pretul unui produs identificat prin nume
     *
     * @param name reprezinta identificatorul produsului al carui pret va fi returnat
     * @return pretul produsului identificat prin parametrul "name"
     */
    public static int getPrice(String name){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement getPriceStatement = null;
        ResultSet rs = null;
        int price = 0;
        try{
            getPriceStatement = dbConnection.prepareStatement(getPriceStatementString, Statement.RETURN_GENERATED_KEYS);
            getPriceStatement.setString(1, name);
            rs = getPriceStatement.executeQuery();
            rs.next();

            price = rs.getInt("price");

        }catch(SQLException e){
            LOGGER.log(Level.WARNING, "ProductDAO: getPrice " + e.getMessage());
        }finally{
            ConnectionFactory.close(rs);
            ConnectionFactory.close(getPriceStatement);
            ConnectionFactory.close(dbConnection);
        }

        return price;
    }
}
