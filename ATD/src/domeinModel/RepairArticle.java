/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package domeinModel;

/**
 *
 * @author william
 */
public class RepairArticle {
    
    private int quantity;
    private Article article;
    
    public RepairArticle(int q, Article a){
        setQuantity(q);
        article = a;
    }
    
    public Article getArticle(){
        return article;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int q){
        if(q > 0){
            quantity = q;
        }
    }
    
    public boolean equals(Object a){
        return (a instanceof RepairArticle && ((RepairArticle)a).getArticle().equals(this));
    }
    
    public String toString(){
        return String.format("%s items van %s", quantity, article);
    }
    
}
