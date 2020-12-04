////////////////////////////////////////////////////////////////////
// [Lorenzo] [Piran] [1193526]
////////////////////////////////////////////////////////////////////
 
package it.unipd.tos.model;
import java.util.Date;
public class MenuItem {
    private items itemType;
    private String name;
    private double price;
    private Date data;//data e orario ordine
 
    public MenuItem(String n, items t, double p){
        itemType = t;
        name = n;
        price = p;
        data = new Date();
    }
    
    public items getType(){
        return itemType;
    }
 
    public double getPrice(){
        return price;
    }
    public Date getData() {
        return data;
    }
}
