/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atd;

import java.util.ArrayList;

/**
 *
 * @author william
 */
public class Stock extends ArrayList<Article> {
    
    public boolean conatins(Article newArticle) {
        for(Article refArticle : this) {
            if(newArticle.equals(refArticle)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Article newArticle) {
        if (this.contains(newArticle)) {
            super.add(newArticle);
            return true;
        }
        return false;
    }
}
