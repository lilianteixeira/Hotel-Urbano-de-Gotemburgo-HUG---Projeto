package exceptions;

/**
 * 
 * A classe Objeto Invalido Exception faz parte da hierarquia de exceptions, 
 * ele lanca uma excecao caso o objto seja invalido
 * 
 */
public class ObjetoInvalidoException extends Exception {
	
	public ObjetoInvalidoException() {
	
		super("O objeto e invalido");
		
	}
	
	public ObjetoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
