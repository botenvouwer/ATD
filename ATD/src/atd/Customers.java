package atd;

import domeinModel.Customer;
import java.util.ArrayList;

public class Customers extends ArrayList<Customer> {
    
    public boolean contains(Customer newCustomer) {
        for(Customer refCustomer : this) {
            if(newCustomer.equals(refCustomer)) {
                return true;
            }
        }
        return false;
    }

    public Customer find(int number) {
        for (Customer lookingFor : this) {
            if (lookingFor.getNumber() == number) {
                return lookingFor;
            }
        }
        return null;
    }

    @Override
    public boolean add(Customer newCustomer) {
        int counter = 0;
        for (Customer equals : this) {
            if (equals.equals(newCustomer)) {
                counter++;
            }
        }
        if(counter == 0) {
            super.add(newCustomer);
            return true;
        }
        return false;

    }

}
