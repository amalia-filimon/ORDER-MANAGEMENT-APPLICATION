package dataAccess;

import connection.ConnectionFactory;
import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Aceasta clasa permite inserarea, steargerea, modificarea unui client din baza de date, respectiv selectarea tuturor clientilor existenti
 */
public class ClientDAO {
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO client (idClient, name, address, email)" + " VALUES(?, ?, ?, ?)";
    private static final String deleteStatementString = "DELETE FROM client WHERE idClient = ?";
    private static final String editStatementString = "UPDATE client SET email = ? WHERE idClient = ?";
    private static final String viewAllStatementString = "SELECT * FROM client";

    /**
     * Aceasta metoda insereaza un client in baza de date
     *
     * @param client caracterizat prin id, nume, adresa si email reprezinta clientul care se va insera in baza de date
     */
    public static void insert(Client client) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, client.getIdClient());
            insertStatement.setString(2, client.getName());
            insertStatement.setString(3, client.getAddress());
            insertStatement.setString(4, client.getEmail());
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO: insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Aceasta metoda sterge un client din baza de date
     *
     * @param idClient este un atribut unic pentru fiecare client, iar cu ajutorul lui se determina clientul care se vrea a fi sters din baza de date
     */
    public static void delete(int idClient) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setInt(1, idClient);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO: delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Aceasta metoda modifica email - ul unui client existent in baza de date
     *
     * @param id este parametrul prin care se identifica clientul al carui email se vrea a fi modificat
     * @param email reprezinta noul email cu care se inlocuieste cel vechi
     */
    public static void edit(int id, String email){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement editStatement = null;
        try{
            editStatement = dbConnection.prepareStatement(editStatementString, Statement.RETURN_GENERATED_KEYS);
            editStatement.setString(1, email);
            editStatement.setInt(2, id);
            editStatement.executeUpdate();
        }catch(SQLException e){
            LOGGER.log(Level.WARNING, "ClientDAO: edit " + e.getMessage());
        }finally{
            ConnectionFactory.close(editStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * Aceasta metoda selecteaza toti clientii existenti in baza de date si ii pune intr - o lista de clienti
     *
     * @return lista de clienti care contine toti clientii din baza de date
     */
    public static List<Client> view(){
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement viewStatement = null;
        ResultSet rs = null;
        List<Client> clients = new ArrayList<>();
        try{
            viewStatement = dbConnection.prepareStatement(viewAllStatementString);
            rs = viewStatement.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("idClient");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");

                Client c = new Client(id, name, address, email);
                clients.add(c);
            }
        }catch(SQLException e){
            LOGGER.log(Level.WARNING, "ClientDAO: view " + e.getMessage());
        }finally{

            ConnectionFactory.close(rs);
            ConnectionFactory.close(viewStatement);
            ConnectionFactory.close(dbConnection);
        }
        return clients;
    }

}
