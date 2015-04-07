/*
 * Studie product
 * Bestand gemaakt voor studie product. Kopieren en aanpassen is toegestaan.
 * Het is niet de bedoeling dit bestand te gebruiken voor je eiegen school opdracht.
 */
package atd;

import domeinModel.Article;
import javafx.scene.control.TextField;

/**
 *
 * @author william
 */
public class StockTextField extends TextField
{
    
    public Article article;
    
    public StockTextField(Article a){
        super();
        article = a;
        setText("0");
    }
    
    public int getNumber(){
        return Integer.parseInt(getText());
    }
    
    @Override
    public void replaceText(int start, int end, String text)
    {
        if (validate(text))
        {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text)
    {
        if (validate(text))
        {
            super.replaceSelection(text);
        }
    }

    private boolean validate(String text)
    {
        return ("".equals(text) || text.matches("[0-9]"));
    }
}
