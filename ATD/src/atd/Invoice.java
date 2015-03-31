package atd;

import java.util.ArrayList;


public class Invoice {

	private int number;
	private boolean paid;
	private ArrayList<InvoiceLine> invoices = new ArrayList<InvoiceLine>();
	
	public Invoice()
	{
		
	}
	
	public void addLine(InvoiceLine line)
	{
		for(InvoiceLine i : invoices)
		{
			if(i.equals(line)) return;
		}
		invoices.add(line);
	}
	
	public void addLines(ArrayList<InvoiceLine> line)
	{
		for(InvoiceLine i : line) addLine(i);
	}
	
	public void removeLine(InvoiceLine line)
	{
		invoices.remove(line);
	}
	
	public void setPaid(boolean p)
	{
		paid = p;
	}
	
	public boolean getPaid()
	{
		return paid;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public double total()
	{
		double totalamount = 0;
		for(InvoiceLine il : invoices) totalamount += (il.getAmount() * il.getQuantity());
		return totalamount;
	}
	
	public double tax()
	{
		return total() * 0.21;//uitgaande van 21% (?)
	}
	
	
	/*TODO: finish this function as i have no idea what size's supposed to do...*/
	public int size()
	{
		return 0;
	}
	
	public ArrayList<InvoiceLine> getLines()
	{
		return invoices;
	}
	
	public String toString()
	{
		String s = "Invoice number " + number + (paid ? ", which has been paid" : ", which has yet to be paid") + " contains the following invoicelines:\n";
		for(InvoiceLine il : invoices) s += il;
		return s;
	}
}
