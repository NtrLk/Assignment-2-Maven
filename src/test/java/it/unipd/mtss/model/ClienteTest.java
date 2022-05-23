package it.unipd.mtss.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ClienteTest {

	private Cliente Mario = new Cliente(20, "Mario", "Rossi", "Roma");

	@Test(expected = IllegalArgumentException.class)
	public void costruttoreNomeNullo() {
		new Cliente(20, null, "Rossi", "Roma");
	}

	@Test(expected = IllegalArgumentException.class)
	public void costruttoreCognomeNullo() {
		new Cliente(20, "Mario", null, "Roma");
	}

	@Test(expected = IllegalArgumentException.class)
	public void costruttoreLuogoNascitaNullo() {
		new Cliente(20, "Mario", "Rossi", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void costruttoreAgeNullo() {
		new Cliente(0, "Mario", "Rossi", "Roma");
	}

	@Test
	public void costruttoreAgeMin() {
		assertTrue(Mario.getAge() > 9);
	}

	@Test
	public void getNomeNotNull() {
		assertTrue(Mario.getNome() != null);
	}

	@Test
	public void getCognomeNotNull() {
		assertTrue(Mario.getCognome() != null);
	}

	@Test
	public void getLuogoNascitaNotNull() {
		assertTrue(Mario.getLuogoNascita() != null);
	}
}