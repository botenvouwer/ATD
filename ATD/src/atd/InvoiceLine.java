package atd;

public class InvoiceLine {

	private String description;
	private double amount;
	private int quantity;
	
	public InvoiceLine(String desc, double a)
	{
		description = desc;
		amount = a;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setAmount(double a)
	{
		amount = a;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public void setQuantity(int q)
	{
		quantity = q;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	@Override
	public boolean equals(Object o)
	{
		return (o instanceof InvoiceLine) && ((InvoiceLine)o).getDescription().equals(this.getDescription());
	}
	
	public String toString()
	{
		return description + ". Met een prijs van: " + amount + ", en een aantal van: " + quantity + "\n";
	}
}
