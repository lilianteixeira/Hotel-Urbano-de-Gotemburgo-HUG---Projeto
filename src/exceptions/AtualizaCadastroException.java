package exceptions;

public class AtualizaCadastroException extends Exception {

	public AtualizaCadastroException() {
		
	}
	
	public AtualizaCadastroException(String mensagem) {
		super("Erro na atualizacao do cadastro de Hospede. " + mensagem);

	}


}