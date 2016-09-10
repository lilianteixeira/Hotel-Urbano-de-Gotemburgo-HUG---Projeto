package exceptions;

/**
 * @author Michele Santos Matricula 15111882 Turma 03
 */
public class ValidaDados {

	public static void validaNomeException(String str) throws Exception {
		if (str == null || str.trim().equals("")) {
			throw new Exception("Nome nao pode ser nulo ou vazio");
		}

	}

	public static void validaEmailException(String str) throws Exception {
		if (str == null || str.trim().equals("")) {
			throw new Exception("Email nao pode ser nulo ou vazio");
		} else if (!str.contains("@") || !str.contains(".com")){
			throw new Exception("Email invalido");
		}

	}

	public static void validaDataNascimento(String dataNascimento) {
		// TODO Auto-generated method stub
		
	}

}
