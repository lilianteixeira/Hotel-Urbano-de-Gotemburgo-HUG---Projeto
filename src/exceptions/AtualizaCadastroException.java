package exceptions;

/**
 * a classe abaixo e filha da classe hospedeException
 * ela e responsavel por lancar uma aviso/excecao
 * se houver algum erro na hora de atualizar o cadastro de algum hospede
 *
 */
public class AtualizaCadastroException extends HospedeException {

	public AtualizaCadastroException() {
		super();
	}
	
	public AtualizaCadastroException(String mensagem) {
		super("Erro na atualizacao do cadastro de Hospede. " + mensagem);

	}


}