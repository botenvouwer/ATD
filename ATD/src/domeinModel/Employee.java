/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package domeinModel;

import java.io.Serializable;

/**
 *
 * @author william
 */
public class Employee implements Serializable{
    
    private String name;
    
    public Employee(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean equals(Object o){
        return (o instanceof Employee && ((Employee)o).getName().equals(name));
    }
    
    public String toString(){
        return name;
    }
    
}
