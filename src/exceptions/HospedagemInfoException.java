package exceptions;

public class HospedagemInfoException extends HospedagemException {

	public HospedagemInfoException() {
		//ver mensagem que fica aqui
	}

	public HospedagemInfoException(String mensagem) {
		super("Erro ao checar hospedagem ativa. " + mensagem);
	}

	
}