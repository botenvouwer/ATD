/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author william
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Slave s = new Slave();
        Master m = new Slave();
        
        Slave s1 = (Slave)m;
        Master m2 = s;
        
        double test = 434.3434;
        int qwerty = 56;
        
        System.out.println(String.format("test %s deze shit %s", test, qwerty));
        
    }
    
}
