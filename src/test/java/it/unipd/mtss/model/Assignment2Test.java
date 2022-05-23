package it.unipd.mtss.model;

import static org.junit.Assert.*;

import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


import it.unipd.mtss.business.BillImpl;
import it.unipd.mtss.business.exeption.BillException;


public class Assignment2Test {
	
	// test run del main
	@Test
	public void testMain() {
		// Arrange
		String[] args = new String[1];
		args[0] = "test";
		// Act
		Assignment2.main(args);
		
		Assignment2 D = new Assignment2();
		assertTrue(D.c == 0);
	}

	@Test(expected = BillException.class)
	public void testLancioBillException() throws BillException {
		List<Articolo> itemsOrdered = null;
		Cliente user = new Cliente(16,"QQ", "rterc","Padova");
    	BillImpl prova = new BillImpl();
    	prova.getOrderPrice(itemsOrdered,user);
	}
		
	@Test
	public void testLancioBillException2() {
		List<Articolo> itemsOrdered = new ArrayList<Articolo>();
		Cliente user = new Cliente(16,"QQ", "rterc","Padova");
    	BillImpl prova = new BillImpl();
      
    	for(int i = 0; i < 35; i++){
        	itemsOrdered.add(new Articolo("Tastiere", 10.00));
    	}
    	
    	try {
    		prova.getOrderPrice(itemsOrdered,user);
    	}
    	catch(BillException e) {
    		assertEquals(e.getMessage(), new BillException("Non e' possibile ordinare piu' di 30 articoli.").getMessage());
    	}
	}
	
	@Test
	public void testRegaloDieciOrdini() {
		int numeroRegali = 0;
		List<Cliente> clientela;
		HashMap<Cliente, Ordine> Ordini = new HashMap<Cliente, Ordine>();
		int random = 0;
		int max = 11;
		LocalTime cd;
		
		for(int i = 0; i < 10; i++) {
			Ordini.put(new Cliente(10,"A","B","Roma"), new Ordine(18,30));
			Ordini.put(new Cliente(22,"B","C","Padova"), new Ordine(15,30));
		}
		
		clientela = Ordini.keySet().stream().filter( C -> C.getAge() < 18).collect(Collectors.toList());
		max = clientela.size();
		
		
		for (int i = 0; i < 10; i++) {
			random = ThreadLocalRandom.current().nextInt(0, (max));	
			Cliente auxx = clientela.get(random);
			
			cd = LocalTime.parse(Ordini.get(auxx).getOrario());
			
			if(cd.isAfter(LocalTime.parse("17:59")) && cd.isBefore(LocalTime.parse("20:00"))) {
				Ordini.get(auxx).setImporto(0.0);
				max--;
				numeroRegali++;
				clientela.remove(random);
				System.out.println("L'acquisto del cliente --> " +"Nome :"+ auxx.getNome() + " Cognome : " + auxx.getCognome() + " viene offertto dal negozio.");
			}
			
		}
		assertTrue(numeroRegali == 10);
	}
	
	
	
}