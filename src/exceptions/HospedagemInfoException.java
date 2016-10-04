package exceptions;

public class HospedagemInfoException extends HotelException {

	public HospedagemInfoException() {
		//ver mensagem que fica aqui
	}

	public HospedagemInfoException(String mensagem) {
		super("Erro ao checar hospedagem ativa. " + mensagem);
	}

	//desnecessario
	public HospedagemInfoException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public HospedagemInfoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public HospedagemInfoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}