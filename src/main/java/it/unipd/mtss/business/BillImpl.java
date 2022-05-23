////////////////////////////////////////////////////////////////////
// [Raul] [Seganfreddo] [1226293] 
// [Saad] [Mounib] [2052815] 
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;


import java.util.List;

import it.unipd.mtss.model.Articolo;
import it.unipd.mtss.model.Articolo.itemType;
import it.unipd.mtss.business.exeption.BillException;
import it.unipd.mtss.model.Cliente;
import it.unipd.mtss.model.Ordine;

public class BillImpl implements Bill {
	public BillImpl() {}
	
	@Override
	public double getOrderPrice(List<Articolo> itemsOrdered, Cliente user) throws BillException {
		double importo = 0.0;
		if(itemsOrdered != null)
		{
			int length = itemsOrdered.size();
			
			if(length > 30)
			{
				throw new  BillException("Non e' possibile ordinare piu' di 30 articoli.");
			}				
			else {
				
				int numeroProcessori = 0;
				int numeroMouse = 0;
				int numeroTastiere = 0;
				
				Double menoCaroTastiere = -0.00;
				Double menoCaroMouse = -0.00;
				Double menoCaroProcessori = -0.00;
			
				
				Articolo aux = null;
				for(int i = 0; i < itemsOrdered.size(); i++) {
					aux = itemsOrdered.get(i);
				
					if(aux.getNome() == itemType.Processori) {
						numeroProcessori++;
						menoCaroProcessori = aux.getPrezzo();
					}
					
					if(aux.getNome() == itemType.Mouse) {
						numeroMouse++;
						menoCaroMouse = aux.getPrezzo();
					}
					if(aux.getNome() == itemType.Tastiere) {
						numeroTastiere++;
						menoCaroTastiere = aux.getPrezzo();
					}
					importo += aux.getPrezzo();
				}
				
				for(int j = 0; j < itemsOrdered.size(); j++) {
					aux = itemsOrdered.get(j);
					if(aux.getNome() == itemType.Mouse) {
						if(aux.getPrezzo() < menoCaroMouse)
						{
							menoCaroMouse = aux.getPrezzo();
						}
					}
					
					if(aux.getNome() == itemType.Tastiere) {
						if(aux.getPrezzo() < menoCaroTastiere)
						{
							menoCaroTastiere = aux.getPrezzo();
						}
					}

					if(aux.getNome() == itemType.Processori) {
						if(aux.getPrezzo() < menoCaroProcessori)
						{
							menoCaroProcessori = aux.getPrezzo();
						}
					}
					
				}

				if(numeroProcessori > 5) {
					importo = importo - (menoCaroProcessori / 2);
				}

				if(numeroMouse > 10) {
					importo -= menoCaroMouse;
				}

				if(numeroTastiere == numeroMouse) {
					importo -= menoCaroMouse;
				}
			}
		}
		else
		{
			throw new BillException("Lista non inizializzata");
		}
		
		return importo;
	}
}

// commento per la issue 1 : la issue 1 è compresa nella issue 6 
// (che necessariamente andava fatta per prima per poter gestire la eccezione), quindi non 
// viene fatta una modifica sostanziale al codice per chiudere la issue 1.