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
        double GelatoEconomico = 100.0;
        for(MenuItem menuItem : itemsOrder) {
            if(menuItem.getType() == items.Bevande) {
                Bevande += menuItem.getPrice();
            }
            else {
                Cibo += menuItem.getPrice(); 
            }
            if(menuItem.getType() == items.Gelati) {
                nrGelati++;
                if(GelatoEconomico > menuItem.getPrice()) {
                    GelatoEconomico = menuItem.getPrice();
                }
            }
        }
        if(nrGelati > 5) {
            Cibo -= (GelatoEconomico/2);
        }
        if(Cibo > 50.0) {
            Cibo -= (Cibo*0.1);
        }
        return Cibo + Bevande;
    }
}
