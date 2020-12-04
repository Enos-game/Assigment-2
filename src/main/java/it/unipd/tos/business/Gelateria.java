////////////////////////////////////////////////////////////////////
// [Lorenzo] [Piran] [1193526] 
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;
import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.model.items;
import java.util.Random;
public class Gelateria implements TakeAwayBill{
    public static int OrdiniRegalati = 0;
    @Override
    public double getOrderPrice(List<MenuItem> itemsOrder, User user) throws TakeAwayBillException{
        double Cibo = 0.0;
        double Bevande = 0.0;
        int nrGelati = 0;
        double GelatoEconomico = 100.0;
        MenuItem first = itemsOrder.get(0);
        Random random = new Random();
        if(user.getAnnoDiNascita()>=2003 && OrdiniRegalati <= 10 && ((first.getData().getHours() == 18 || first.getData().getHours() == 19) && (first.getData().getMinutes() >= 0 || first.getData().getMinutes() <= 59)) ) {
          int decisione = random.nextInt(100);
          if(decisione < 50) {//50% di probabilità di avere minore con gelato gratuito, se esso è tra i primi 10
              OrdiniRegalati++;
              return 0;
            }
        }
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
        if(itemsOrder.size() > 30) {
            throw new TakeAwayBillException("troppi elementi nell'ordine effettuato");
        }
        if(Bevande + Cibo < 10.0) {
            return Bevande + Cibo + 0.5;
        }
        else {
          return Cibo + Bevande;
        }
    }
}
