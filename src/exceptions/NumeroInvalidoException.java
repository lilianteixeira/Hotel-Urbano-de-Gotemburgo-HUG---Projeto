package exceptions;

/**
 * 
 * A classe Numero Invalido Exception faz parte da hierarquia de exceptions, 
 * ele lanca uma excecao caso o numero recebido seja invalido
 * 
 */
public class NumeroInvalidoException extends Exception {

	public NumeroInvalidoException(){
		super("Erro ao realizar checkin. Quantidade de dias esta invalida.");
	}
	
	public NumeroInvalidoException(String mensagem){
		super(mensagem);
	}
}
