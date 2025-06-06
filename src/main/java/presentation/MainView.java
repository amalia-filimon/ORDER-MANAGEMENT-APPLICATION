package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Aceasta clasa creeaza interfata grafica cu utilizatorul sub forma unui meniu din care utilizatorul selecteaza daca doreste sa efectueze operatii asupra tabelului "client", "produs" sau "order" din baza de date
 */
public class MainView extends JFrame {
    private JPanel contentPane;
    private JLabel title;
    private JButton clientBtn;
    private JButton productBtn;
    private JButton orderBtn;

    /**
     * In acest constructor sunt initializate toate campurile din interfata grafica carora li se atribuie diverse valori cum ar fi coordonate pentru pozitia in fereastra, textul pentru o eticheta, fontul pentru un text dintr-o eticheta etc
     */
    public MainView(){
        setTitle("MENU");
        setBounds(200, 200, 350, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.CYAN);

        title = new JLabel("Select operation on:");
        title.setFont(new Font("Tahoma", Font.ITALIC, 15));
        title.setBounds(20, 20, 150, 20);
        contentPane.add(title);

        clientBtn = new JButton("CLIENT");
        clientBtn.setBounds(120, 70, 100, 25);
        contentPane.add(clientBtn);

        productBtn = new JButton("PRODUCT");
        productBtn.setBounds(120, 120, 100, 25);
        contentPane.add(productBtn);

        orderBtn = new JButton("ORDER");
        orderBtn.setBounds(120, 170, 100, 25);
        contentPane.add(orderBtn);
    }

    /**
     * Aceasta metoda adauga un ascultator pentru butonul care selecteaza efectuarea operatiilor asupra tabelului "client" ("CLIENT")
     *
     * @param action reprezinta ascultatorul adaugat butonului
     */
    public void clientBtnAL(ActionListener action){
        this.clientBtn.addActionListener(action);
    }

    /**
     * Aceasta metoda adauga un ascultator pentru butonul care selecteaza efectuarea operatiilor asupra tabelului "product" ("PRODUCT")
     *
     * @param action reprezinta ascultatorul adaugat butonului
     */
    public void productBtnAL(ActionListener action){
        this.productBtn.addActionListener(action);
    }

    /**
     * Aceasta metoda adauga un ascultator pentru butonul care selecteaza efectuarea operatiilor asupra tabelului "order" ("ORDER")
     *
     * @param action reprezinta ascultatorul adaugat butonului
     */
    public void orderBtnAL(ActionListener action){
        this.orderBtn.addActionListener(action);
    }

}
