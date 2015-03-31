package atd;

import java.util.ArrayList;

public class Invoices extends ArrayList<Invoice>{
    
    public Invoice find(int number) {
        if(exists(number)) {
            for( Invoice lookingFor : this) {
                if(lookingFor.getNumber() == number) {
                    return lookingFor;
                } 
            }
        } 
        return null;
    }
    
    public boolean exists(int number) {
        for( Invoice lookingFor : this) {
            if(lookingFor.getNumber() == number) return true;
        }
        return false;
    }
    
    @Override
    public boolean remove(Object o) {
    	if(!(o instanceof Invoice)) return false;
    	Invoice i = find(((Invoice)o).getNumber());
    	if(i != null) {
    		super.remove(i);
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Invoice remove(int number) {
    	Invoice i = find(number);
    	if(i != null) {
    		super.remove(i);
    		return i;
    	}
    	return null;
    }
    
    @Override
    public boolean add(Invoice newInvoice) {
        if(exists(newInvoice.getNumber())) {
        	super.add(newInvoice);
            return true;
        }
        return false;
    }
    
}
