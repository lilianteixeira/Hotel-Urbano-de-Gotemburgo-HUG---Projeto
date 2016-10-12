package exceptions;

public class AtualizaCadastroException extends HospedeException {

	public AtualizaCadastroException() {
		
	}
	
	public AtualizaCadastroException(String mensagem) {
		super("Erro na atualizacao do cadastro de Hospede. " + mensagem);

	}


}