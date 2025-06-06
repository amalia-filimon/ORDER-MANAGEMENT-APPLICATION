package exceptions;

import javax.swing.*;

/**
 * Aceasta clasa creeaza o exceptie noua si este folosita pentru a arunca exceptia respectiva atunci cand se creeaza o comanda noua, iar utilizatorul introduce o cantitate mai mare decat stocul disponibil pentru produsul selectat
 */
public class InvalidInputException extends Exception{

    /**
     * Constructorul va crea de fiecare data cand este apelat o casuta de dialog cu un mesaj de eroare care se va afisa pe ecran atunci cand se selecteaza o cantitate mai mare decat stocul disponibil pentru produsul selectat
     *
     * @param exceptionName reprezinta numele exceptiei care va aparea in casuta de dialog
     */
    public InvalidInputException(String exceptionName){
        JOptionPane.showMessageDialog(null, exceptionName);
    }
}
