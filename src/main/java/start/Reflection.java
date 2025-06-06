package start;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Aceasta clasa utilizeaza reflexia in cele doua metode ale sale pentru a extrage campurile dintr-o lista de obiecte care vor reprezenta coloanele tabelului pentru afisarea tuturor clientilor sau produselor, respectiv pentru a extrage valorile din baza de date care vor reprezenta randurile din tabel
 * @param <T> va fi reprezentat de clasa Client sau Product
 */
public class Reflection<T> {

    /**
     * Aceasta metoda extrage prin reflexie campurile din lista de obiecte care vor reprezenta coloanele din tabelul care contine fie toti clientii, fie toate produsele din baza de date
     *
      * @param objects reprezinta lista generica de obiecte care poate fi o lista de clienti sau o lista de produse
     * @return un vector de String-uri in care sunt puse campurile din lista de obiecte
     */
    public String[] retrieveColumns(List<T> objects) {
        List<T> genericList = new ArrayList<>();
        Object obiect= objects.get(0);
        for (Field field : obiect.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.getName();
                genericList.add((T) value);

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

        }
        int sizeColumns = genericList.size();
        String[] columns = new String[sizeColumns];

        for(int i = 0; i < sizeColumns; i++){
            columns[i] = (String) genericList.get(i);
        }

        return columns;
    }

    /**
     * Aceasta metoda extrage prin reflexie valorile din lista de obiecte care vor reprezenta randurile din tabelul care contine fie toti clientii, fie toate produsele din baza de date
     *
     * @param objects reprezinta lista generica de obiecte care poate fi o lista de clienti sau o lista de produse
     * @return o matrice de String-uri in care sunt puse valorile din lista generica de obiecte
     */
    public String[][] retrieveRows(List<T> objects) {
        int sizeRows = objects.size();
        int sizeColumns = this.retrieveColumns(objects).length;
        String[][] rows = new String[sizeRows][sizeColumns];

        int i = 0;
        for(T object : objects){
            int j = 0;
            for (Field field : object.getClass().getDeclaredFields())
            {
                field.setAccessible(true);
                Object value;
                try{
                    value = field.get(object);
                    rows[i][j] = value.toString();
                    j++;
                }catch(IllegalArgumentException e){
                    e.printStackTrace();
                }catch(IllegalAccessException e){
                    e.printStackTrace();
                }
            }
            i++;
        }
        return rows;
    }

}
