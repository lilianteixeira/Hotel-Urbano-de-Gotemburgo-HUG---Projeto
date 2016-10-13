package exceptions;

/**
 * a classe abaixo e filha da classe hospedeException
 * ela e responsavel por lancar um aviso/excecao
 * se houver algum erro na hora da remorcao de um hospede
 *
 */
public class RemoveHospedeException extends HospedeException {
	public RemoveHospedeException() {
		super();
	}

	public RemoveHospedeException(String arg0) {
		super("Erro na remocao do Hospede. " + arg0);
		
	}
}
