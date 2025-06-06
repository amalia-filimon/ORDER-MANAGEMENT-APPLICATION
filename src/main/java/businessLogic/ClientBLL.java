package businessLogic;

import dataAccess.ClientDAO;
import model.Client;

import java.util.List;

/**
 * In aceasta clasa sunt create metode care apeleaza toate metodele care efectueaza operatii asupra tabelului "client" din baza de date, cum ar fi: insert, delete, edit, view
 */
public class ClientBLL {

    /**
     *
     * @param client reprezinta parametrul cu care se apeleaza metoda "insert" din clasa "ClientDAO"
     * @see ClientDAO
     */
    public void insertClient(Client client){
        ClientDAO.insert(client);
    }

    /**
     *
     * @param idClient reprezinta identificatorul unic al clientului cu care se apeleaza metoda "delete" din clasa "ClientDAO"
     * @see ClientDAO
     */
    public void deleteClient(int idClient){
        ClientDAO.delete(idClient);
    }

    /**
     *
     * @param id reprezinta identificatorul unic cu care se apeleaza metoda "edit" din clasa "ClientDAO"
     * @param email reprezinta emailul cu care se apeleaza metoda "edit" din clasa "ClientDAO"
     * @see ClientDAO
     */
    public void editClient(int id, String email){
        ClientDAO.edit(id, email);
    }

    /**
     *
     * @return lista de clienti returnata de metoda "view" din clasa "ClientDAO"
     * @see ClientDAO
     */
    public List<Client> viewClients() {
         return ClientDAO.view();
    }
}
