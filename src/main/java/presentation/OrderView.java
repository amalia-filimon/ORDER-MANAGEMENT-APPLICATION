package presentation;

import dataAccess.ClientDAO;
import dataAccess.ProductDAO;
import model.Client;
import model.Product;
import start.Reflection;

import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Aceasta clasa creeaza interfata grafica cu utilizatorul destinata introducerii de date pentru o comanda, cum ar fi: id, idClient, idProdus, cantitate si selectarii operatiei de creare a unei noi comenzi printr-un buton specific
 */
public class OrderView extends JFrame {

    private JPanel contentPane;
    private JLabel title1;
    private JLabel idOrderLbl;
    private JLabel nameClientLbl;
    private JLabel nameProductLbl;
    private JLabel quantityLbl;
    private JTextField idOrderTextF;
    private JTextField quantityTextF;
    private JButton createOrderBtn;
    private JComboBox<Client> clientsCombo;
    private JComboBox<Product> productsCombo;

    /**
     * In acest constructor sunt initializate toate campurile din interfata grafica carora li se atribuie diverse valori cum ar fi coordonate pentru pozitia in fereastra, textul pentru o eticheta, fontul pentru un text dintr-o eticheta etc
     */
    public OrderView(){
        setTitle("Product orders");
        setBounds(200, 200, 450, 400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.CYAN);

        title1 = new JLabel("Enter order data:");
        title1.setFont(new Font("Tahoma", Font.ITALIC, 20));
        title1.setBounds(20, 20, 200, 20);
        contentPane.add(title1);

        idOrderLbl = new JLabel("ID Order:");
        idOrderLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        idOrderLbl.setBounds(100, 70, 100, 20);
        contentPane.add(idOrderLbl);

        idOrderTextF = new JTextField();
        idOrderTextF.setBounds(180, 70, 180, 20);
        contentPane.add(idOrderTextF);

        nameClientLbl = new JLabel("Client name:");
        nameClientLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        nameClientLbl.setBounds(80, 100, 100, 20);
        contentPane.add(nameClientLbl);

        List<Client> clients = ClientDAO.view();
        Reflection<Client> reflectionClient = new Reflection();
        int listSizeClient = reflectionClient.retrieveRows(clients).length;
        String[] nameClients = new String[listSizeClient];

        int i = 0;
        for(Client c : clients){
            nameClients[i] = c.getName();
            i++;
        }
        clientsCombo = new JComboBox(nameClients);
        clientsCombo.setBounds(180, 100, 180, 20);
        contentPane.add(clientsCombo);

        nameProductLbl = new JLabel("Product name:");
        nameProductLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        nameProductLbl.setBounds(70, 130, 100, 20);
        contentPane.add(nameProductLbl);

        List<Product> products = ProductDAO.view();
        Reflection<Product> reflectionProduct = new Reflection();
        int listSizeProduct = reflectionProduct.retrieveRows(products).length;
        String[] nameProducts = new String[listSizeProduct];

        int j = 0;
        for(Product p : products){
            nameProducts[j] = p.getName();
            j++;
        }
        productsCombo = new JComboBox(nameProducts);
        productsCombo.setBounds(180, 130, 180, 20);
        contentPane.add(productsCombo);

        quantityLbl = new JLabel("Quantity:");
        quantityLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        quantityLbl.setBounds(100, 160, 100, 20);
        contentPane.add(quantityLbl);

        quantityTextF = new JTextField();
        quantityTextF.setBounds(180, 160, 180, 20);
        contentPane.add(quantityTextF);

        createOrderBtn = new JButton("Create order");
        createOrderBtn.setBounds(150, 250, 150, 30);
        contentPane.add(createOrderBtn);

    }

    /**
     * Aceasta metoda adauga un ascultator pentru butonul care adauga o noua comanda in baza de date ("Create order")
     *
     * @param action reprezinta ascultatorul adaugat butonului
     */
    public void createOrderBtnAL(ActionListener action){
        this.createOrderBtn.addActionListener(action);
    }

    /**
     * Aceasta metoda extrage textul introdus de utilizator din textfield-ul corespunzator ID-ului unei comenzi
     *
     * @return un String care reprezinta ID-ul pentru o comanda introdus de utilizator
     */
    public String getIdOrder(){
        return this.idOrderTextF.getText();
    }

    /**
     * Aceasta metoda extrage textul introdus de utilizator din textfield-ul corespunzator cantitatii care se comanda dintr-un produs
     *
     * @return un String care reprezinta cantitatea comandata dintr-un produs introdusa de utilizator
     */
    public String getQuantity(){
        return this.quantityTextF.getText();
    }

    /**
     * Aceasta metoda extrage textul introdus de utilizator din comboBox-ul corespunzator numelui unui client existent in baza de date
     *
     * @return un String care reprezinta numele unui client existent in baza de date selectat de catre utilizator
     */
    public String getClientName(){
        return (String) this.clientsCombo.getSelectedItem();
    }

    /**
     * Aceasta metoda extrage textul introdus de utilizator din comboBox-ul corespunzator numelui unui produs existent in baza de date
     *
     * @return un String care reprezinta numele unui produs existent in baza de date selectat de catre utilizator
     */
    public String getProductName(){
        return (String) this.productsCombo.getSelectedItem();
    }

}
