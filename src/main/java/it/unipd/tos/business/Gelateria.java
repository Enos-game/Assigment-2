////////////////////////////////////////////////////////////////////
// [Lorenzo] [Piran] [1193526] 
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;
import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.model.items;
public class Gelateria implements TakeAwayBill{
    @Override
    public double getOrderPrice(List<MenuItem> itemsOrder, User user) throws TakeAwayBillException{
        double Cibo = 0.0;
        double Bevande = 0.0;
        int nrGelati = 0;
        for(MenuItem menuItem : itemsOrder) {
            if(menuItem.getType() == items.Bevande) {
                Bevande += menuItem.getPrice();
            }
            else {
                Cibo += menuItem.getPrice(); 
            }
        }
        return Cibo + Bevande;
    }
}
