/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package Exceptions;

/**
 *
 * @author william
 */
public class StockException extends Exception{
    
    public StockException(){
        super("Voorraad kan alleen gemuteerd worden met positieve nummers of 0 (s >= 0)");
    }
    
    public StockException(String m){
        super(m);
    }
    
}
