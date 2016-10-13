package exceptions;

/**
 * a classe abaixo e filha da classe hospedagemException
 * ela e responsavel por lancar uma aviso/excecao
 * se houver algum erro relacionado a hospedagemm
 *
 */
public class HospedagemInfoException extends HospedagemException {

	public HospedagemInfoException() {
		super();
	}

	public HospedagemInfoException(String mensagem) {
		super("Erro ao checar hospedagem ativa. " + mensagem);
	}

	
}