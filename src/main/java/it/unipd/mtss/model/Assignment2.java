////////////////////////////////////////////////////////////////////
// [Raul] [Seganfreddo] [1226293] 
// [Saad] [Mounib] [2052815] 
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import it.unipd.mtss.business.BillImpl;
import it.unipd.mtss.business.exeption.BillException;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.ThreadLocalRandom;



public class Assignment2 {
	
	static double valoreDaPagare = 0.0;
	static BillImpl val = new BillImpl();
	static List<Cliente> clienti = new ArrayList<Cliente>();
	static HashMap<Cliente, Ordine> Ordini = new HashMap<Cliente, Ordine>();
	int c;
	public Assignment2() {
		c = 0;
	}
	
	public static void main(String [] args) {
			Cliente aux = null;
			
			clienti.add(new Cliente(16,"VV", "rterc","Padova"));
			clienti.add(new Cliente(15,"XV", "rterc","Padova"));
			clienti.add(new Cliente(17,"AQ", "rterc","Padova"));
			clienti.add(new Cliente(16,"QQ", "rterc","Padova"));
			clienti.add(new Cliente(16,"QTT", "rterc","Padova"));
			clienti.add(new Cliente(16,"QT", "rterc","Padova"));
			clienti.add(new Cliente(13,"SQ", "rterc","Padova"));
			clienti.add(new Cliente(17,"SS", "rterc","Padova"));
			clienti.add(new Cliente(15,"XX", "rterc","EWAAAa"));
			clienti.add(new Cliente(11,"XX", "rterc","Padova"));
			clienti.add(new Cliente(12,"XX", "rterc","Padova"));
			clienti.add(new Cliente(10,"XX", "rterc","Padova"));
			clienti.add(new Cliente(10,"XX", "rterc","Padova"));
			
			clienti.add(new Cliente(20,"XX", "rterc","DT"));
			clienti.add(new Cliente(20,"XX", "rterc","DS"));
			clienti.add(new Cliente(20,"XX", "rterc","DA"));
			clienti.add(new Cliente(20,"YT", "rterc","DE"));
			
			aux = clienti.get(0);
			creazioneOrdine(aux,18,45);
			aux = clienti.get(1);
			creazioneOrdine(aux,18,45);
			aux = clienti.get(2);
			creazioneOrdine(aux,18,45);
			aux = clienti.get(3);
			creazioneOrdine(aux,18,45);
			aux = clienti.get(4);
			creazioneOrdine(aux,18,45);
			aux = clienti.get(5);
			creazioneOrdine(aux,18,45);
			aux = clienti.get(6);
			creazioneOrdine(aux,18,45);
			aux = clienti.get(7);
			creazioneOrdine(aux,18,45);
			aux = clienti.get(8);
			creazioneOrdine(aux,18,45);
			aux = clienti.get(9);
			creazioneOrdine(aux,18,45);
			aux = clienti.get(10);
			creazioneOrdine(aux,17,30);
			aux = clienti.get(11);
			creazioneOrdine(aux,20,10);
			aux = clienti.get(12);
			creazioneOrdine(aux,11,21);
			aux = clienti.get(13);
			creazioneOrdine(aux,18,45);
			aux = clienti.get(14);
			creazioneOrdine(aux,18,45);
			aux = clienti.get(15);
			creazioneOrdine(aux,18,45);
			aux = clienti.get(16);
			creazioneOrdine(aux,18,45);
			

		
			for(Cliente c : clienti) {
		
				try {
					double valore = val.getOrderPrice(Ordini.get(c).getLista(), c);
					Ordini.get(c).setImporto(valore);
				} catch (BillException e) {
					// Va bene
				}
				
			}
			
			List<Cliente> clientela = Ordini.keySet().stream().filter( C -> C.getAge() < 18).collect(Collectors.toList());

			regaloDieciOrdini(clientela);
	}
	
	public static void regaloDieciOrdini(List<Cliente> clientela) {
		int max = clientela.size();
		int random = 0;
		LocalTime cd;
		int counter = 10;
	
		for (int i = 0; i < counter; i++) {
			random = ThreadLocalRandom.current().nextInt(0, (max));	
			Cliente auxx = clientela.get(random);
			
			cd = LocalTime.parse(Ordini.get(auxx).getOrario());
			
			if(cd.isAfter(LocalTime.parse("17:59")) && cd.isBefore(LocalTime.parse("20:00"))) {
				Ordini.get(auxx).setImporto(0.0);
				max--;
				clientela.remove(random);
				
				System.out.println("L'acquisto del cliente --> " +"Nome :"+ auxx.getNome() + " Cognome : " + auxx.getCognome() + " viene offertto dal negozio.");
			}
			
		}
	}

	public static void creazioneOrdine(Cliente cliente, Integer ora, Integer minuti) {

		Ordine o1 = new Ordine(ora, minuti);
		o1.addArticolo("Processori", 10.0);
		o1.addArticolo("Processori", 10.0);
		o1.addArticolo("Processori", 10.0);
		o1.addArticolo("Processori", 10.0);
		o1.addArticolo("Processori", 10.0);
		o1.addArticolo("Processori", 10.0);
		
		o1.addArticolo("Tastiere", 1000.0);
		o1.addArticolo("Tastiere", 10.0);
		o1.addArticolo("Tastiere", 10.0);
		o1.addArticolo("Tastiere", 10.0);
		o1.addArticolo("Tastiere", 10.0);
		o1.addArticolo("Tastiere", 10.0);
		o1.addArticolo("Tastiere", 10.0);
		o1.addArticolo("Tastiere", 10.0);
		o1.addArticolo("Tastiere", 10.0);
		o1.addArticolo("Tastiere", 10.0);
		o1.addArticolo("Tastiere", 10.0);
		
		o1.addArticolo("Mouse", 5.0);
		o1.addArticolo("Mouse", 10.0);
		o1.addArticolo("Mouse", 10.0);
		o1.addArticolo("Mouse", 10.0);
		o1.addArticolo("Mouse", 10.0);
		o1.addArticolo("Mouse", 10.0);
		o1.addArticolo("Mouse", 10.0);
		o1.addArticolo("Mouse", 10.0);
		o1.addArticolo("Mouse", 10.0);
		o1.addArticolo("Mouse", 10.0);
		o1.addArticolo("Mouse", 10.0);
		Ordini.put(cliente, o1);
		
		
	}
}