package util;


import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Menu {
    public static int getChoice(ArrayList options) { 
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i+1) + "-" + options.get(i)); 
        }
        System.out.println("Choose 1.." + options.size() + ": ");
        return Validation.inputInt("");
    }
    
    public static int   getChoice(Object[] options) { 
        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1) + "-" + options[i]);      
        }
        System.out.println("Choose 1.." + options.length + ": ");
        return Validation.inputInt("");
    }
}
