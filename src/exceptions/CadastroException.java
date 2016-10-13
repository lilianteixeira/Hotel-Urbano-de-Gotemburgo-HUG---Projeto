package exceptions;

/**
 * a classe abaixo e filha da classe hospedeException
 * ela e responsavel por lancar uma aviso/excecao
 * se houver algum erro na hora de cadastrar um hospede
 *
 */
public class CadastroException extends HospedeException {
	
	public CadastroException() {
		super();
	}

	public CadastroException(String mensagem) {
		super("Erro no cadastro de Hospede. " + mensagem);
	}

}