package it.unipd.mtss.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import java.util.List;
import java.util.ArrayList;

public class OrdineTest {

	List<Articolo> ArticoliOrdinati;
	List<Articolo> Aux;

	// controllo che nel costruttore l'ora sia < 24
	@Test(expected = IllegalArgumentException.class)
	public void testOrdineOraMinore() {
		new Ordine(24, 0);
	}

	// controllo che nel costruttore l'ora sia > -1
	@Test(expected = IllegalArgumentException.class)
	public void testOrdineOraMaggiore() {
		new Ordine(-1, 0);
	}

	// controllo che nel costruttore i minuti siano < 60
	@Test(expected = IllegalArgumentException.class)
	public void testOrdineMinutiMinore() {
		new Ordine(0, 60);
	}

	// controllo che nel costruttore i minuti siano > -1
	@Test(expected = IllegalArgumentException.class)
	public void testOrdineMinutiMaggiore() {
		new Ordine(0, -1);
	}

	// controllo che il nome dell'ordine non sia null
	@Test(expected = IllegalArgumentException.class)
	public void testAddArticolocleaNomeNotNull() {
		new Ordine(0, 0).addArticolo(null, 0.0);
	}

	// controllo che il prezzo dell'ordine non sia null
	@Test(expected = IllegalArgumentException.class)
	public void testAddArticoloPrezzoNotNull() {
		new Ordine(0, 0).addArticolo("Processore", null);
	}

	// controllo che il prezzo dell'ordine non sia <= 0
	@Test(expected = IllegalArgumentException.class)
	public void testAddArticoloPrezzoMinoreDiZero() {
		new Ordine(0, 0).addArticolo("Processore", -1.0);
	}

	// inizializzo la lista di articoli aggiungendo un elemento, utile
	// per i test successivi
	@Before
	public void setUpListaArticolo() throws Exception {
		ArticoliOrdinati = new ArrayList<Articolo>();
		Aux = new ArrayList<Articolo>();
		ArticoliOrdinati.add(new Articolo("Processori",10.0));
		Aux.add(new Articolo("Processori", 10.0));
	}

	// test che il return di getLista() funzioni correttamente
	@Test
	public void testReturnGetLista() {
		Ordine o1 = new Ordine(0, 0);
		Ordine o2 = new Ordine(0, 0);
		o1.addArticolo("Processori", 10.0);
		o2.addArticolo("Processori", 10.0);
		assertEquals(o1.getLista().get(0).getNome(), o2.getLista().get(0).getNome());
		assertEquals(o1.getLista().get(0).getPrezzo(), o2.getLista().get(0).getPrezzo());
	}

	// test che il return di getOrario() ritorni la formattazione corretta
	@Test
	public void testReturnGetOrario() {
		Ordine o1 = new Ordine(0, 0);
		assertEquals("0:0", o1.getOrario());
	}

	// test se getImporto() funziona correttamente
	@Test
	public void testGetImporto() {
		Ordine o1 = new Ordine(0, 0);
		o1.setImporto(10.0);
		assertEquals(10.0, o1.getImporto(), 0.0);
	}

	// test se setImporto() ha un importo non valido
	@Test(expected = IllegalArgumentException.class)
	public void testSetImporto() {
		Ordine o1 = new Ordine(0, 0);
		o1.setImporto(-1.0);
	}
}