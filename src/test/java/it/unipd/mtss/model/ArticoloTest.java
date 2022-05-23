package it.unipd.mtss.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.unipd.mtss.model.Articolo.itemType;


public class ArticoloTest {

	private Articolo articolo;
	Double x = 20.0;

    @Before
    public void setUp()
    {
    	articolo = new Articolo("Mouse",20.0);
    }
	
	// controllo che il costruttore non accetti un prezzo nullo
	@Test(expected = IllegalArgumentException.class)
	public void testPrezzoNelCostruttoreNonNullo()
	{
		new Articolo("Processori",null);
	}

	// controllo che il costruttore non accetti un nome nullo
	@Test(expected = IllegalArgumentException.class)
	public void testNomeArticoloNelCostruttoreNonNullo()
	{
		new Articolo(null,10.0);
	}

	// controllo che il costruttore non accetti un prezzo negativo
	@Test(expected = IllegalArgumentException.class)
	public void testPrezzoArticoloCostruttoreMaggioreDiZero()
	{
		new Articolo("SchedeMadri",-10.0);
	}

	// vari test per il switch
	@Test
	public void testSwitchProcessore()
	{
		assertEquals("Processori", new Articolo("Processori",x).getNome().toString());
	}

	@Test
	public void testSwitchSchedeMadri()
	{
		assertEquals("SchedeMadri",new Articolo("SchedeMadri",x).getNome().toString());
	}

	@Test
	public void testSwitchMouse()
	{
		assertEquals("Mouse",new Articolo("Mouse",x).getNome().toString());
	}

	@Test
	public void testSwitchTastiere()
	{
		assertEquals("Tastiere",new Articolo("Tastiere",x).getNome().toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSwitchArticoloNonRiconosciuto()
	{
		new Articolo("Sbagliato",x).getNome();
	}
	
	// controllo che il return di getPrezzo() funzioni correttamente
	@Test
	public void testReturnGetPrezzo()
	{
		Double x = 20.0;
		assertEquals(articolo.getPrezzo(),x);
	}

	// controllo che il return di getNome() funzioni correttamente
	@Test
	public void testReturnGetNome()
	{
		assertEquals(articolo.getNome(),itemType.Mouse);
	}

	// controllo che in getNome() il nome non sia null
	@Test(expected = IllegalArgumentException.class)
	public void testNomeNotNullGetNome() {
		new Articolo(null, 0.0).getNome();
	}
	

	
}