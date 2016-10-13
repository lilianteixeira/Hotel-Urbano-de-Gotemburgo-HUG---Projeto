package exceptions;

/**
 * a classe abaixo e filha da classe Exception
 * ela e responsavel por lancar uma aviso/excecao
 * caso ela receba algum valor invalido
 *
 */
public class ValorInvalidoException extends Exception {

	public ValorInvalidoException(){
		super();
	}
	
	public ValorInvalidoException(String mensagem){
		super(mensagem);
	}
}
