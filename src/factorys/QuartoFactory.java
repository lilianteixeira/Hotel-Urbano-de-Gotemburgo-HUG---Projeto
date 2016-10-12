package factorys;

import java.io.Serializable;

import hospedagem.Quarto;
import hospedagem.TipoDeQuarto;

public class QuartoFactory  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7186869929469504717L;

	public Quarto criaQuarto(String idQuarto, String tipoDeQuarto) throws Exception{

		for(TipoDeQuarto t : TipoDeQuarto.values())
			if(tipoDeQuarto.equalsIgnoreCase(t.toString()))
				return new Quarto(idQuarto, t);
		throw new Exception("Tipo de quarto invalido.");
	}
}
