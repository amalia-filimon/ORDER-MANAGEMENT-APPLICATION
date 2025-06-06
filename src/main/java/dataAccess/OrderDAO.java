package dataAccess;

import connection.ConnectionFactory;
import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Aceasta clasa permite inserarea unei noi comenzi in baza de date
 */
public class OrderDAO {
    protected static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO warehouse.order (idOrder, clientName, productName, quantity)" + " VALUES(?, ?, ?, ?)";

    /**
     * Aceasta este metoda care insereaza o noua comanda in baza de date
     *
     * @param order este caracterizat prin id propriu, id - ul clientului, id - ul produsului si cantitatea si reprezinta noua comanda care se va insera in baza de date
     */
    public static void insert(Order order) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, order.getIdOrder());
            insertStatement.setString(2, order.getClientName());
            insertStatement.setString(3, order.getProductName());
            insertStatement.setInt(4, order.getQuantity());
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO: insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }
}
