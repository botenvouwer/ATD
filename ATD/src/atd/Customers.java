package atd;

import java.util.ArrayList;

public class Customers extends ArrayList<Customer>{
    
    public Customer find(int number) {
            for( Customer lookingFor : this) {
                if(lookingFor.getNumber() == number) {
                    return lookingFor;
                } 
            }
        return null;
        } 
    
    public void remove(Customer deleteCustomer) {
        remove(deleteCustomer.getNumber());
    }
    
    @Override
    public boolean add(Customer newCustomer) {
        if(contains(newCustomer)) {
            super.add(newCustomer);
            return true;
        }
        return false;
    }
    
}
