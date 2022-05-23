////////////////////////////////////////////////////////////////////
// [Raul] [Seganfreddo] [1226293] 
// [Saad] [Mounib] [2052815] 
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

public class Articolo implements EItem{
	public enum itemType {Processori,SchedeMadri, Mouse, Tastiere};
	itemType nome;
	Double prezzo;
	
	public Articolo(String nome, Double prezzo) {
		if(nome == null) {
			throw new IllegalArgumentException("Il nome non può essere nullo");
		}
		if(prezzo == null) {
			throw new IllegalArgumentException("Il prezzo non può essere nullo");
		}
		
		if(prezzo > 0) {
			this.prezzo = prezzo;
		}
		else
		{
			throw new IllegalArgumentException("Il prezzo deve essere maggiore di zero");
		}
		
		switch (nome) {
		case "Processori":
			this.nome = itemType.Processori;
			break;
		case "SchedeMadri":
			this.nome = itemType.SchedeMadri;
			break;
		case "Mouse":
			this.nome = itemType.Mouse;
			break;
		case "Tastiere":
			this.nome = itemType.Tastiere;
			break;
		default:
			throw new IllegalArgumentException("Articolo non riconosciuto");
		}

		this.prezzo = prezzo;
	}
	public Double getPrezzo() {
		return this.prezzo;
	}
	
	public itemType getNome() {
		return this.nome;
	}
}