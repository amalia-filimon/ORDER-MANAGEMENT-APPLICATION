package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Aceasta clasa creeaza interfata grafica cu utilizatorul destinata introducerii de date pentru un produs, cum ar fi: id, nume, pret, stoc si selectarii unei operatii de inserare, modificare, stergere sau vizualizarea prin intermediul unor butoane specifice
 */
public class ProductView extends JFrame{

    private JPanel contentPane;
    private JLabel title1;
    private JLabel idLbl;
    private JLabel nameLbl;
    private JLabel priceLbl;
    private JLabel stockLbl;
    private JLabel title2;
    private JTextField idTextF;
    private JTextField nameTextF;
    private JTextField priceTextF;
    private JTextField stockTextF;
    private JButton addProductBtn;
    private JButton editProductBtn;
    private JButton deleteProductBtn;
    private JButton viewProductsBtn;

    /**
     * In acest constructor sunt initializate toate campurile din interfata grafica carora li se atribuie diverse valori cum ar fi coordonate pentru pozitia in fereastra, textul pentru o eticheta, fontul pentru un text dintr-o eticheta etc
     */
    public ProductView(){
        setTitle("Product operations");
        setBounds(200, 200, 500, 450);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.CYAN);

        title1 = new JLabel("Enter product data:");
        title1.setFont(new Font("Tahoma", Font.ITALIC, 20));
        title1.setBounds(20, 20, 200, 30);
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

        priceLbl = new JLabel("Price:");
        priceLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        priceLbl.setBounds(120, 130, 60, 20);
        contentPane.add(priceLbl);

        priceTextF = new JTextField();
        priceTextF.setBounds(180, 130, 180, 20);
        contentPane.add(priceTextF);

        stockLbl = new JLabel("Stock:");
        stockLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        stockLbl.setBounds(120, 160, 60, 20);
        contentPane.add(stockLbl);

        stockTextF = new JTextField();
        stockTextF.setBounds(180, 160, 180, 20);
        contentPane.add(stockTextF);

        title2 = new JLabel("Select product operation:");
        title2.setFont(new Font("Tahoma", Font.ITALIC, 20));
        title2.setBounds(20, 230, 250, 30);
        contentPane.add(title2);

        addProductBtn = new JButton("Add new product");
        addProductBtn.setBounds(80, 280, 150, 30);
        contentPane.add(addProductBtn);

        deleteProductBtn = new JButton("Delete product");
        deleteProductBtn.setBounds(80, 330, 150, 30);
        contentPane.add(deleteProductBtn);

        editProductBtn = new JButton("Edit product");
        editProductBtn.setBounds(250, 280, 150, 30);
        contentPane.add(editProductBtn);

        viewProductsBtn = new JButton("View all products");
        viewProductsBtn.setBounds(250, 330, 150, 30);
        contentPane.add(viewProductsBtn);
    }

    /**
     * Aceasta metoda adauga un ascultator pentru butonul care adauga un produs in baza de date ("Add new product")
     *
     * @param action reprezinta ascultatorul adaugat butonului
     */
    public void addProductBtnAL(ActionListener action){
        this.addProductBtn.addActionListener(action);
    }

    /**
     * Aceasta metoda adauga un ascultator pentru butonul care sterge un client in baza de date ("Delete product")
     *
     * @param action reprezinta ascultatorul adaugat butonului
     */
    public void deleteProductBtnAL(ActionListener action){
        this.deleteProductBtn.addActionListener(action);
    }

    /**
     * Aceasta metoda adauga un ascultator pentru butonul care modifica un client in baza de date ("Edit product")
     *
     * @param action reprezinta ascultatorul adaugat butonului
     */
    public void editProductBtn(ActionListener action){
        this.editProductBtn.addActionListener(action);
    }

    /**
     * Aceasta metoda adauga un ascultator butonului care afiseaza un tabel cu toate produsele din baza de date ("View all clients")
     *
     * @param action reprezinta ascultatorul adaugat butonului
     */
    public void viewProductsBtn(ActionListener action){
        this.viewProductsBtn.addActionListener(action);
    }

    /**
     * Aceasta metoda extrage textul introdus de utilizator din textfield-ul corespunzator ID-ului unui produs
     *
     * @return un String care reprezinta ID-ul pentru un produs introdus de utilizator
     */
    public String getIdProduct(){
        return this.idTextF.getText();
    }

    /**
     * Aceasta metoda extrage textul introdus de utilizator din textfield-ul corespunzator numelui unui produs
     *
     * @return un String care reprezinta numele unui produs introdus de utilizator
     */
    public String getNameProduct(){
        return this.nameTextF.getText();
    }

    /**
     * Aceasta metoda extrage textul introdus de utilizator din textfield-ul corespunzator pretului unui produs
     *
     * @return un String care reprezinta pretul unui produs introdus de utilizator
     */
    public String getPrice(){
        return this.priceTextF.getText();
    }

    /**
     * Aceasta metoda extrage textul introdus de utilizator din textfield-ul corespunzator stocului unui produs
     *
     * @return un String care reprezinta stocul unui produs introdus de utilizator
     */
    public String getStock(){
        return this.stockTextF.getText();
    }
}
