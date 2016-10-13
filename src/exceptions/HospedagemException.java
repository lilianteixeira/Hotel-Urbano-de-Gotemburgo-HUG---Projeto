package exceptions;

/**
 * a classe abaixo e filha da classe Exception
 * ela e responsavel por lancar uma aviso/excecao
 * se houver algum erro relacionado a informacoes da hospedagem
 *
 */
public class HospedagemException extends Exception{

	public HospedagemException() {
		super();
	}

	public HospedagemException(String mensagem) {
		super(mensagem);
		
	}
}
