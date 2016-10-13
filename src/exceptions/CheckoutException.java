package exceptions;

/**
 * a classe abaixo e filha da classe hospedagemException
 * ela e responsavel por lancar uma aviso/excecao
 * se houver algum erro na hora de fazer checkout
 *
 */
public class CheckoutException extends HospedagemException {

	public CheckoutException() {
		super();
	}
	
	public CheckoutException(String mensagem) {
		super("Erro ao realizar checkout. " + mensagem);
	}


}