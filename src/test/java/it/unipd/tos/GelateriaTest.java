package it.unipd.tos;

import it.unipd.tos.business.Gelateria;
import it.unipd.tos.business.exception.BillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.model.items;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.not;

import org.junit.rules.ExpectedException;
import org.junit.Test;

public class GelateriaTest {
    @Test
    public void TotalTest() throws BillException{
      List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
      Gelateria testBill = new Gelateria();
      User utente = new User("1193526","Marco","Prova",1995);

      itemsOrdered.add(new MenuItem("Gelato stracciatella", items.Gelati, 4.00));
      itemsOrdered.add(new MenuItem("Pepsi", items.Bevande, 1.50));
      itemsOrdered.add(new MenuItem("vaniglia", items.Budini, 2.50));

      try{
          assertEquals(8.5, testBill.getOrderPrice(itemsOrdered, utente), 0.0);
      } 
      catch (BillException e){
          e.getMessage();
      }
  }
  @Test
  public void ScontoGelatoTest() throws BillException{
    List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
    Gelateria testBill = new Gelateria();
    User utente = new User("1193526","Marco","Prova",1995);

    itemsOrdered.add(new MenuItem("stracciatella", items.Gelati, 4.00));
    itemsOrdered.add(new MenuItem("Pepsi" , items.Bevande, 1.50));
    itemsOrdered.add(new MenuItem("pistacchio", items.Gelati, 3.50));
    itemsOrdered.add(new MenuItem("vaniglia" , items.Gelati, 4.00));
    itemsOrdered.add(new MenuItem("cioccolato" , items.Budini, 3.00));
    itemsOrdered.add(new MenuItem("fragola", items.Gelati, 4.00));
    itemsOrdered.add(new MenuItem("Coca cola" , items.Bevande, 1.50));
    itemsOrdered.add(new MenuItem("limone", items.Gelati, 3.50));
    itemsOrdered.add(new MenuItem("pera" , items.Gelati, 4.00));
    itemsOrdered.add(new MenuItem("vaniglia" , items.Budini, 3.00));

    try {
        assertEquals(30.25, testBill.getOrderPrice(itemsOrdered, utente), 0.0);
    } 
    catch (BillException e){
        e.getMessage();
    }
}

@Test
        public void Sconto10PercentoTest() throws BillException {
            List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
            Gelateria testBill = new Gelateria();
            User utente = new User("1193526","Marco","Prova",1995);

            for(int i = 1; i <= 10; i++)
                itemsOrdered.add(new MenuItem("stracciatella", items.Gelati, 5.00));

            itemsOrdered.add(new MenuItem("Pepsi" , items.Bevande, 1.50));
            itemsOrdered.add(new MenuItem("per", items.Gelati, 3.50));
            itemsOrdered.add(new MenuItem("fragola" , items.Gelati, 4.00));
            itemsOrdered.add(new MenuItem("vaniglia" , items.Budini, 3.00));
            try {
                assertEquals(54.375, testBill.getOrderPrice(itemsOrdered, utente), 0.0);
            } 
            catch (BillException e){
                e.getMessage();
            }
        }
@Test
public void PrezzoInferioreA10EuroTest() throws BillException {
    List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
    Gelateria testBill = new Gelateria();
    User utente = new User("1193526","Marco","Prova",1995);

    itemsOrdered.add(new MenuItem("vaniglia" , items.Budini, 2.00));

    try {
        assertEquals(2.5, testBill.getOrderPrice(itemsOrdered, utente), 0.0);
    } 
    catch (BillException e){
        e.getMessage();
    }
}
@Test(expected = BillException.class)
public void EccezzioneTest() throws BillException{
  List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
  Gelateria testBill = new Gelateria();
  User utente = new User("1193526","Marco","Prova",1995);
  for(int i = 1; i <= 50; i++)
      itemsOrdered.add(new MenuItem("stracciatella", items.Gelati, 4.00));

  testBill.getOrderPrice(itemsOrdered, utente);
}
@Test
public void RegaloRandomTest() throws BillException{
  List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
  Gelateria testBill = new Gelateria();
  User utente = new User("1193526","Marco","Prova",2005);
  for(int i = 1; i <= 15; i++)
    itemsOrdered.add(new MenuItem("stracciatella", items.Gelati, 4.00));
  //assertThat(Gelateria.OrdiniRegalati,not(11));
  testBill.getOrderPrice(itemsOrdered, utente);
  assertTrue(0 <= Gelateria.OrdiniRegalati && Gelateria.OrdiniRegalati <= 10);
}
}
