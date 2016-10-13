package exceptions;

/**
 * a classe abaixo e filha da classe restauranteException
 * ela e responsavel por lancar uma aviso/excecao
 * se houver algum erro na hora de cadastrar um prato do restaurante
 *
 */
public class PratoCadastroException extends RestauranteException {

	public PratoCadastroException() {
		super();
		
	}

	public PratoCadastroException(String mensagem) {
		super("Erro no cadastro do prato. " + mensagem);
	}

}