package domeinModel;

import Exceptions.StockException;
import java.io.Serializable;

public class Article implements Serializable{
    private String name;
    private int number;
    private int inStock;
    
    public Article(String name, int number) {
        this.name = name;
        this.number = number;
    }
    
    public String getName() {
        return name;
    }
    
    public int getNumber() {
        return number;
    }
    
    public int getInStock() {
        return inStock;
    }
    
    public void setInStock(int countedStock) throws StockException{
        
        if(countedStock >= 0){
            inStock = countedStock;
        }
        else{
            throw new StockException();
        }
    }
    
    public void stockIn(int add) throws StockException{
        
        if(add >= 0){
            inStock += add;
        }
        else{
            throw new StockException();
        }
    }
    
    public void StockOut(int lose) throws StockException{
        
        if(lose < 1){
            throw new StockException();
        }
        
        if(lose > inStock){
            throw new StockException("Uitboek aantal is groter dan voorraad en voorraad mag niet negatief geboekt worden");
        }
        else{
            inStock -= lose;
        }
    }
    
    public String toString() {
        return String.format("%s - %s: %s in voorraad", number, name, inStock);
    }
    
    public boolean equals(Object refArticle) {
        
        if (refArticle instanceof Article && ((Article)refArticle).getNumber() == this.number) {
            return true;
        }
        return false;
    }
}
