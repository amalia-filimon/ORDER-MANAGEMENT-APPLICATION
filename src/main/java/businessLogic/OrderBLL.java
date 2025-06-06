package businessLogic;

import dataAccess.OrderDAO;
import model.Order;

/**
 * In aceasta clasa este creata metoda care apeleaza metoda de inserare in tabelului "order" din baza de date
 */
public class OrderBLL {

    /**
     *
     * @param order reprezinta parametrul cu care se apeleaza metoda "insert" din clasa "OrderDAO"
     * @see OrderDAO
     */
    public void insert(Order order){
        OrderDAO.insert(order);
    }
}
