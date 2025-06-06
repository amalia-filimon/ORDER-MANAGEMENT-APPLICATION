package presentation;

import start.Reflection;

import javax.swing.*;
import java.util.List;

/**
 * Aceasta clasa creeaza o fereastra noua in care apare un tabel cu obiecte. Obiectele pot fi de tip client, produs sau comanda
 *
 * @param <T> este un parametru generic care va fi inlocuit de una din clasele Client sau Product atunci cand se va instantia un obiect din aceasta clasa
 */
public class TableView<T> extends JFrame {
    private JTable table;
    private JScrollPane scroll;

    /**
     * Constructorul acestei clase va crea tabelul generic cu campurile si valorile specifice uneia din clasele Client sau Product
     * @param genericList reprezinta lista generica care poate fi fie o lista de clienti, fie o lista de produse in functie de clasa cu care este creata lista
     */
    public TableView(List<T> genericList) {
        setTitle("View all");
        setSize(800, 400);

        Reflection<T> reflection = new Reflection<>();

        String[] columns = reflection.retrieveColumns(genericList);
        String[][] rows = reflection.retrieveRows(genericList);

        table = new JTable(rows,columns);
        scroll = new JScrollPane(table);
        add(scroll);
        setVisible(true);
    }

}
