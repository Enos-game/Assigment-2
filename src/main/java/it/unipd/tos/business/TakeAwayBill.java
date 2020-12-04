////////////////////////////////////////////////////////////////////
// [Lorenzo] [Piran] [1193526]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;
import java.util.List;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.business.exception.BillException;
public interface TakeAwayBill {
double getOrderPrice(List<MenuItem> itemsOrder, User user) throws BillException;
}
