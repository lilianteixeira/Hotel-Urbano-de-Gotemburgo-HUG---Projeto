package exceptions;

/**
 * a classe abaixo e filha da classe Exception
 * ela e responsavel por lancar um aviso/excecao
 * se houver algum erro com algo ligado ao restaurante
 *
 */
public class RestauranteException extends Exception {

	public RestauranteException() {
		super();
	}

	public RestauranteException(String mensagem) {
		super(mensagem);
		
	}
}