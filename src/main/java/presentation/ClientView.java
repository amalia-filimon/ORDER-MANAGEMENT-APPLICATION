package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Aceasta clasa creeaza interfata grafica cu utilizatorul destinata introducerii de date pentru un client, cum ar fi: id, nume, adresa, email si selectarii unei operatii de inserare, modificare, stergere sau vizualizarea prin intermediul unor butoane specifice
 */
public class ClientView extends JFrame {
    private JPanel contentPane;
    private JLabel title1;
    private JLabel idLbl;
    private JLabel nameLbl;
    private JLabel addressLbl;
    private JLabel emailLBL;
    private JLabel title2;
    private JTextField idTextF;
    private JTextField nameTextF;
    private JTextField addressTextF;
    private JTextField emailTextF;
    private JButton addClientBtn;
    private JButton editClientBtn;
    private JButton deleteClientBtn;
    private JButton viewClientsBtn;

    /**
     * In acest constructor sunt initializate toate campurile din interfata grafica carora li se atribuie diverse valori cum ar fi coordonate pentru pozitia in fereastra, textul pentru o eticheta, fontul pentru un text dintr-o eticheta etc
     */
    public ClientView(){
        setTitle("Client operations");
        setBounds(200, 200, 500, 450);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.CYAN);

        title1 = new JLabel("Enter client data:");
        title1.setFont(new Font("Tahoma", Font.ITALIC, 20));
        title1.setBounds(20, 20, 200, 20);
        contentPane.add(title1);

        idLbl = new JLabel("ID:");
        idLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        idLbl.setBounds(130, 70, 60, 20);
        contentPane.add(idLbl);

        idTextF = new JTextField();
        idTextF.setBounds(180, 70, 180, 20);
        contentPane.add(idTextF);

        nameLbl = new JLabel("Name:");
        nameLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        nameLbl.setBounds(120, 100, 60, 20);
        contentPane.add(nameLbl);

        nameTextF = new JTextField();
        nameTextF.setBounds(180, 100, 180, 20);
        contentPane.add(nameTextF);

        addressLbl = new JLabel("Address:");
        addressLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        addressLbl.setBounds(110, 130, 60, 20);
        contentPane.add(addressLbl);

        addressTextF = new JTextField();
        addressTextF.setBounds(180, 130, 180, 20);
        contentPane.add(addressTextF);

        emailLBL = new JLabel("Email:");
        emailLBL.setFont(new Font("Tahoma", Font.ITALIC, 15));
        emailLBL.setBounds(120, 160, 60, 20);
        contentPane.add(emailLBL);

        emailTextF = new JTextField();
        emailTextF.setBounds(180, 160, 180, 20);
        contentPane.add(emailTextF);

        title2 = new JLabel("Select client operation:");
        title2.setFont(new Font("Tahoma", Font.ITALIC, 20));
        title2.setBounds(20, 230, 250, 30);
        contentPane.add(title2);

        addClientBtn = new JButton("Add new client");
        addClientBtn.setBounds(80, 280, 150, 30);
        contentPane.add(addClientBtn);

        deleteClientBtn = new JButton("Delete client");
        deleteClientBtn.setBounds(80, 330, 150, 30);
        contentPane.add(deleteClientBtn);

        editClientBtn = new JButton("Edit client");
        editClientBtn.setBounds(250, 280, 150, 30);
        contentPane.add(editClientBtn);

        viewClientsBtn = new JButton("View all clients");
        viewClientsBtn.setBounds(250, 330, 150, 30);
        contentPane.add(viewClientsBtn);
    }

    /**
     * Aceasta metoda adauga un ascultator pentru butonul care adauga un client in baza de date ("Add new client")
     *
     * @param action reprezinta ascultatorul adaugat butonului
     */
    public void addClientBtnAL(ActionListener action){
        this.addClientBtn.addActionListener(action);
    }

    /**
     * Aceasta metoda adauga un ascultator pentru butonul care sterge un client din baza de date ("Delete client")
     *
     * @param action reprezinta ascultatorul adaugat butonului
     */
    public void deleteClientBtnAL(ActionListener action){
        this.deleteClientBtn.addActionListener(action);
    }

    /**
     * Aceasta metoda adauga un ascultator butonului care modifica un client din baza de date ("Edit client")
     *
     * @param action reprezinta ascultatorul adaugat butonului
     */
    public void editClientBtn(ActionListener action){
        this.editClientBtn.addActionListener(action);
    }

    /**
     * Aceasta metoda adauga un ascultator butonului care afiseaza un tabel cu toti clientii din baza de date ("View all clients")
     *
     * @param action reprezinta ascultatorul adaugat butonului
     */
    public void viewClientsBtn(ActionListener action){
        this.viewClientsBtn.addActionListener(action);
    }

    /**
     * Aceasta metoda extrage textul introdus de utilizator din textfield-ul corespunzator ID-ului unui client
     *
     * @return un String care reprezinta ID-ul pentru un client introdus de utilizator
     */
    public String getClientID(){
        return this.idTextF.getText();
    }

    /**
     * Aceasta metoda extrage textul introdus de utilizator din textfield-ul corespunzator numelui unui client
     *
     * @return un String care reprezinta numele unui client introdus de utilizator
     */
    public String getClientName(){
        return this.nameTextF.getText();
    }

    /**
     * Aceasta metoda extrage textul introdus de utilizator din textfield-ul corespunzator adresei unui client
     *
     * @return un String care reprezinta adresa unui client introdus de utilizator
     */
    public String getClientAddress(){
        return this.addressTextF.getText();
    }

    /**
     * Aceasta metoda extrage textul introdus de utilizator din textfield-ul corespunzator email-ului unui client
     *
     * @return un String care reprezinta emailul unui client introdus de utilizator
     */
    public String getClientEmail(){
        return this.emailTextF.getText();
    }

}
