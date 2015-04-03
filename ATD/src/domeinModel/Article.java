package domeinModel;

public class Article {
    private String name;
    private int number;
    private int inStock;
    private double price;
    
    public Article(String name, int number, double Price) {
        this.name = name;
        this.number = number;
        this.price = Price;
    }
    
    public String getName() {
        return name;
    }
    
    public int getNumber() {
        return number;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getInStock() {
        return inStock;
    }
    
    public void setPrice(double newPrice) {
        price = newPrice;
    }
    
    public void setInStock(int countedStock) {
        inStock = countedStock;
    }
    
    public void stockIn(int newStock) {
        inStock += newStock;
    }
    
    public void StockOut(int lostStock) {
        inStock -= lostStock;
    }
    
    public String toString() {
        return name + " costs " + price;
    }
    
    public boolean equals(Article refArticle) {
        if(refArticle.getNumber() == this.number) {
            return true;
        }
        return false;
    }
}
