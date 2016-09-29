package factorys;

import hospedagem.Estadia;
import hospedagem.Quarto;
import hospede.Hospede;

public class EstadiaFactory {
	
	
	public Estadia criaEstadia(Quarto quarto, int diasHospedagem, Hospede hospede) throws Exception {
		return new Estadia(quarto, diasHospedagem, hospede);
	}

}

