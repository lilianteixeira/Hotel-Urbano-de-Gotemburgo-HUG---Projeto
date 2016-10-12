package exceptions;

/**
 * 
 * A classe Numero Invalido Exception faz parte da hierarquia de exceptions, 
 * ele lanca uma excecao caso o numero recebido seja invalido
 * 
 */
public class ValorInvalidoException extends Exception {

	public ValorInvalidoException(){

	}
	
	public ValorInvalidoException(String mensagem){
		super(mensagem);
	}
}
