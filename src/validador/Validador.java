package validador;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3956698666978335612L;


	public Validador() {
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean isEmailValid(String email) {
		if ((email == null) || (email.trim().equalsIgnoreCase("")))
			return false;

		String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
		Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		java.util.regex.Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public boolean validateDate(String date) {
		final Pattern VALID_DATE_REGEX = Pattern
				.compile("^(?:(?:31(/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/)(?:0?[1,3-9]|1[0-2])\\2))"
						+ "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|"
						+ "^(?:29(/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|"
						+ "(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/)(?:(?:0?[1-9])|"
						+ "(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", Pattern.CASE_INSENSITIVE);

		Matcher matcher = VALID_DATE_REGEX.matcher(date);
		return (matcher.find() && Pattern.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d", date));
	}

	public boolean validaIdade(String dataDeNascimento) throws Exception {
		LocalDate dataAtual = LocalDate.now();
		int ano = Integer.parseInt(dataDeNascimento.substring(6));
		int mes = Integer.parseInt(dataDeNascimento.substring(3, 4));
		int dia = Integer.parseInt(dataDeNascimento.substring(0, 1));
		if ((dataAtual.getYear() - ano) < 18)
			return false;
		else if ((dataAtual.getYear() - ano) == 18)
			if ((dataAtual.getMonthValue() - mes) < 0)
				return false;
			else if (dataAtual.getMonthValue() - mes == 0)
				if ((dataAtual.getDayOfMonth() - dia) < 0)
					return false;
		return true;
	}


	public boolean validaQuarto(String id) {
		Pattern VALID_QUARTO_ID_REGEX = Pattern.compile("^[A-Z0-9]+", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_QUARTO_ID_REGEX.matcher(id);
		return matcher.find();
	}
	
}
