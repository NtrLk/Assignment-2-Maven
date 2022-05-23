package it.unipd.mtss.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import it.unipd.mtss.model.Articolo;
import it.unipd.mtss.model.Cliente;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;
import it.unipd.mtss.model.Ordine;

import it.unipd.mtss.business.BillImpl;
import it.unipd.mtss.business.exeption.BillException;


public class BillImplTest {

    List<Articolo> ArticoliOrdinati;
    List<Articolo> ArticoliOrdinati2;
    List<Articolo> ArticoliOrdinati3;

    @Before
    public void setUp() throws Exception {
        ArticoliOrdinati = new ArrayList<Articolo>();
        ArticoliOrdinati.add(new Articolo("Processori", 1.0));
        ArticoliOrdinati.add(new Articolo("Mouse", 1.0));
        ArticoliOrdinati.add(new Articolo("Tastiere", 1.0));
    }

      // test che la size della lista non superi i 30 articoli
      @Test
      public void testItemsOrderedSizeMinoreDiTrenta() {
          BillImpl meinn = new BillImpl();
          try {
              meinn.getOrderPrice(ArticoliOrdinati, new Cliente(10, "Mario", "Rossi", "Milano"));
          } catch (BillException e) {
              assertEquals("Non è possibile ordinare più di 30 articoli.", e.getMessage());
          }
      }
  
      // test che la size della lista maggiore di 30 articoli
      @Test
      public void testItemsOrderedSizeMaggioreDiTrenta() {
          for (int i = 0; i < 11; i++) {
              ArticoliOrdinati.add(new Articolo("Processori", 2.0));
              ArticoliOrdinati.add(new Articolo("Mouse", 2.0));
              ArticoliOrdinati.add(new Articolo("Tastiere", 2.0));
          }
          BillImpl meinn = new BillImpl();
          try {
              meinn.getOrderPrice(ArticoliOrdinati, new Cliente(10, "Mario", "Rossi", "Milano"));
          } catch (BillException e) {
              assertEquals("Non e' possibile ordinare piu' di 30 articoli.", e.getMessage());
          }
        }

    // test in cui vengono ordinati 5 processori e testo il return della funzione
    @Test
    public void testItemsOrderedPiuDi5Processori() {
        for (int i = 0; i < 5; i++) {
            ArticoliOrdinati2.add(new Articolo("Processori", 10.0));
        }
        ArticoliOrdinati2.add(new Articolo("Processori", 5.0));
        BillImpl meinn = new BillImpl();
        try {
            // visto il come ho costruito la lista di articoli, il valore che mi aspetto,
            // considerando lo sconto è di 72.50
            assertEquals(72.50, meinn.getOrderPrice(ArticoliOrdinati2, new Cliente(20, "Marco", "Verdi", "Roma")), 0.00);
        } catch (BillException e) {
            assertEquals("Non e' possibile ordinare piu' di 30 articoli.", e.getMessage());
        }
    }
}
