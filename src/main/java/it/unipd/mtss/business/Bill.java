////////////////////////////////////////////////////////////////////
// [Raul] [Seganfreddo] [1226293] 
// [Saad] [Mounib] [2052815] 
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;
import java.util.List;

import it.unipd.mtss.model.Articolo;
import it.unipd.mtss.model.Cliente;
import it.unipd.mtss.business.exeption.BillException;

public interface Bill {
	double getOrderPrice(List<Articolo> itemsOrdered, Cliente user) throws BillException;
}