/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package atd;

import java.util.ArrayList;

/**
 *
 * @author Nigel
 */
public class Cars extends ArrayList<Car> {
    
    public boolean contains(Car newCar) {
        for(Car refCar : this) {
            if(newCar.equals(refCar)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(Car newCar) {
        if(this.contains(newCar)) {
            super.add(newCar);
            return true;
        }
        return false;
    }
}
