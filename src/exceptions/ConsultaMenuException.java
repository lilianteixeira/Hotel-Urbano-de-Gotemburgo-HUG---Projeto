package exceptions;

/**
 * a classe abaixo e filha da classe restauranteException
 * ela e responsavel por lancar uma aviso/excecao
 * se houver algum erro na hora de consultar o menu do restaurante
 *
 */
public class ConsultaMenuException extends RestauranteException {
	
	public ConsultaMenuException() {
		super();
	}
	
	public ConsultaMenuException(String mensagem){
		super("Erro na consulta do restaurante. " + mensagem);
	}

}