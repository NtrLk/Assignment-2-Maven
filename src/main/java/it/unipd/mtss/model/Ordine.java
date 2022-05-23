////////////////////////////////////////////////////////////////////
// [Raul] [Seganfreddo] [1226293] 
// [Saad] [Mounib] [2052815] 
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import java.util.ArrayList;
import java.util.List;


public class Ordine {
	private double importo = 0.0;
	private List<Articolo> ArticoliOrdinati;
	private Integer ora;
	private Integer minuti;

	public Ordine(Integer ora, Integer minuti) {
		this.ArticoliOrdinati = new ArrayList<Articolo>();
		// controllo che nel costruttore l'ora sia valida
		if (ora < 0 || ora > 23) {
			throw new IllegalArgumentException("ora non valida");
		}
		else {
			this.ora = ora;
		}

		// controllo che nel costruttore i minuti siano validi
		if (minuti < 0 || minuti > 59) {
			throw new IllegalArgumentException("minuti non validi");
		}
		else {
			this.minuti = minuti;
		}
	}
	
	public void addArticolo(String nome,Double prezzo) {
		if (nome == null || prezzo == null || prezzo < 0) {
			throw new IllegalArgumentException("nome o prezzo non validi");
		}
		ArticoliOrdinati.add(new Articolo(nome,prezzo));
	}

	// CONTROLLI
	public List<Articolo> getLista()
	{
		return ArticoliOrdinati;
	}

	public String getOrario() {
		return this.ora + ":" + this.minuti;
	}
	
	public double getImporto() {
		return this.importo;
	}
	
	public void setImporto(double importo) {
		if(importo >= 0.00) {
			this.importo = importo;
		}
		else
		{
			throw new IllegalArgumentException("importo non valido");
		}
	}
}