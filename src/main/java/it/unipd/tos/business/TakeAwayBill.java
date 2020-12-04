////////////////////////////////////////////////////////////////////
// [Lorenzo] [Piran] [1193526] 
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;
import java.util.List;
import it.unipd.tos.model.*;
import it.unipd.tos.business.exception.TakeAwayBillException;
public interface TakeAwayBill {
    double getOrderPrice(List<MenuItem> itemsOrder, User user) throws TakeAwayBillException;
}
