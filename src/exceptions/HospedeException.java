package exceptions;

/**
 * a classe abaixo e filha da classe Exception
 * ela e responsavel por lancar uma aviso/excecao
 * se houver algum erro relacionado a algum hospede
 *
 */
public class HospedeException extends Exception {

	public HospedeException() {
		super();
	}

	public HospedeException(String mensagem) {
		super(mensagem);
		
	}

}
