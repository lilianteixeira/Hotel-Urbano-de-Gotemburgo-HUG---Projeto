package factorys;

import hospedagem.Quarto;
import hospedagem.TipoDeQuarto;

public class QuartoFactory {
	public Quarto criaQuarto(String idQuarto, String tipoDeQuarto) throws Exception{

		for(TipoDeQuarto t : TipoDeQuarto.values())
			if(tipoDeQuarto.equalsIgnoreCase(t.toString()))
				return new Quarto(idQuarto, t);
		throw new Exception("Tipo de quarto invalido.");
	}
}
