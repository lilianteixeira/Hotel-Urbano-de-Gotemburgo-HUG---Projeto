package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cadastro.*;
import estadia.*;
import exceptions.*;
import quarto.*;
import registro.*;

/**
 * Esta classe, serve como um controller para as operacoes do sistema
 * informatizado do HUG; cadastrando hospedes, gerenciando as estadias, e
 * calculando os lucros diários.
 * <p>
 * As seguintes informacoes sao armazenadas, e ficam disponiveis para o cliente
 * do sistema:
 * <ul>
 * <li>Lista de hospedes
 * <li>Lista de estadias
 * <li>Lista com o registro dos lucros.
 * </ul>
 * <p>
 * Somente uma instancia dessa classe é gerada, e o acesso dessa instância é
 * pelo método getInstance().
 *
 */
public final class Hotel {
	private CadastroSet cadastros;
	private EstadiaSet estadias;
	private RegistroList registros;
	private ArrayList<RegistroCheckOut> registroCheckout;
	private QuartoSet quartos;

	/**
	 * 
	 */
	private Hotel() {
		this.cadastros = new CadastroSet();
		this.estadias = new EstadiaSet();
		this.registros = new RegistroList();
		this.quartos = new QuartoSet();
		this.registroCheckout = new ArrayList<>();
	}

	/**
	 * retorna uma instância de hotel
	 * 
	 * @return uma instância de hotel
	 */
	public static Hotel getInstance() {
		return instance;
	}

	/**
	 * Cria uma instância de Cadastro, e armazena na lista de hospedes.
	 * 
	 * @param nome
	 *            nome do hospede.
	 * @param email
	 *            email do hospede.
	 * @param dataDeNascimento
	 *            data de nascimento do hospede.
	 * @return email
	 * @throws HotelCadastroException
	 *             se algum dos argumentos forem vazios, a idade do hospede for
	 *             menor que 18 anos, ou não tiverem uma formatação valida. São
	 *             esperadas as seguintes formatações para cada atributo:
	 *             <ul>
	 *             <li>nome : uma sequencia de letras, podendo entre elas (nunca
	 *             no começo ou fim), existir espaços em branco isolados (Dois
	 *             espaços em branco nunca estão conectados).
	 *             <li>email: definido pelo <code>regex</code>
	 *             "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$".
	 *             <li>data: definido pelo <code>regex</code>
	 *             "\\d\\d/\\d\\d/\\d\\d\\d\\d".
	 */
	public String cadastraHospede(String nome, String email, String dataDeNascimento) throws HotelCadastroException {
		if (nome == null || nome.trim().equals(""))
			throw new HotelCadastroException("Nome do(a) hospede nao pode ser vazio.");
		if (email == null || email.trim().equals(""))
			throw new HotelCadastroException("Email do(a) hospede nao pode ser vazio.");
		if (dataDeNascimento == null || dataDeNascimento.trim().equals(""))
			throw new HotelCadastroException("Data de Nascimento do(a) hospede nao pode ser vazio.");
		validaCadastro(nome, email, dataDeNascimento);

		cadastros.addCadastro(CadastroFactory.INSTANCE.create(nome, email, dataDeNascimento));
		return email;
	}

	/**
	 * 
	 * O metodo atualiza o cadastro de um hospede
	 * 
	 * @param email
	 * @param atributo
	 * @param novoAtributo
	 * @throws CadastroNotFoundException
	 * @throws AtualizaCadastroException
	 */

	public void atualizaCadastro(String email, String atributo, String valor)
			throws CadastroNotFoundException, AtualizaCadastroException {
		if (valor == null || valor.trim().equals("")) {
			if (atributo.equalsIgnoreCase("nome"))
				throw new AtualizaCadastroException("Nome do(a) hospede nao pode ser vazio.");
			if (atributo.equalsIgnoreCase("email"))
				throw new AtualizaCadastroException("Email do(a) hospede nao pode ser vazio.");
			if (atributo.equalsIgnoreCase("data de nascimento"))
				throw new AtualizaCadastroException("Data de Nascimento do(a) hospede nao pode ser vazio.");
		}

		if (atributo.equalsIgnoreCase("nome"))
			if (!Pattern.matches("[[a-zA-Z]+\\s?]+", valor))
				throw new AtualizaCadastroException("Nome do(a) hospede esta invalido.");
		if (atributo.equalsIgnoreCase("email"))
			if (!validateEmail(valor))
				throw new AtualizaCadastroException("Email do(a) hospede esta invalido.");
		if (atributo.equalsIgnoreCase("data de nascimento")) {
			if (!validateDate(valor))
				throw new AtualizaCadastroException("Formato de data invalido.");

			LocalDate dataAtual = LocalDate.now();
			int ano = Integer.parseInt(valor.substring(6));
			int mes = Integer.parseInt(valor.substring(3, 4));
			int dia = Integer.parseInt(valor.substring(0, 1));
			if ((dataAtual.getYear() - ano) < 18)
				throw new AtualizaCadastroException("A idade do(a) hospede deve ser maior que 18 anos.");
			else if ((dataAtual.getYear() - ano) == 18)
				if ((dataAtual.getMonthValue() - mes) < 0)
					throw new AtualizaCadastroException("A idade do(a) hospede deve ser maior que 18 anos.");
				else if (dataAtual.getMonthValue() - mes == 0)
					if ((dataAtual.getDayOfMonth() - dia) < 0)
						throw new AtualizaCadastroException("A idade do(a) hospede deve ser maior que 18 anos.");
		}
		cadastros.setInfoCadastro(email, atributo, valor);
	}

	public String getInfoHospede(String email, String atributo) throws GetInfoException, HospedeNotFoundException {
		if (email == null || email.trim().equals(""))
			throw new GetInfoException("Email do(a) hospede nao pode ser vazio.");
		if (!validateEmail(email))
			throw new GetInfoException("Email do(a) hospede esta invalido");
		try {
			return cadastros.getInfoCadastro(email, atributo);
		} catch (CadastroNotFoundException e) {
			throw new HospedeNotFoundException(email);

		}
	}

	public boolean removeHospede(String email) throws HospedeNotFoundException, HotelRemoveException {
		if (email == null || email.trim().equals(""))
			throw new HotelRemoveException("Email do(a) hospede nao pode ser vazio.");
		if (!validateEmail(email))
			throw new HotelRemoveException("Formato de email invalido.");

		try {
			cadastros.removeCadastro(cadastros.buscaCadastro(email));
			return true;
		} catch (CadastroNotFoundException e) {
			throw new HospedeNotFoundException(email);
		}

	}

	public void realizaCheckin(String email, int dias, String id, String tipoQuarto) throws CheckinException {
		// Validação dos argumentos
		if (email == null || email.trim().equals(""))
			throw new CheckinException("Email do(a) hospede nao pode ser vazio.");
		if (!validateEmail(email))
			throw new CheckinException("Email do(a) hospede esta invalido.");
		if (dias <= 0)
			throw new CheckinException("Quantidade de dias esta invalida.");
		if (!validateId(id))
			throw new CheckinException("ID do quarto invalido, use apenas numeros ou letras.");

		Cadastro hospede;
		// Checa se hospede foi cadastrado
		try {
			hospede = cadastros.buscaCadastro(email);
		} catch (CadastroNotFoundException e) {
			throw new CheckinException("Hospede de email " + email + " nao foi cadastrado(a).");
		}

		boolean isTipoInvalido = true;
		for (TipoDeQuarto t : TipoDeQuarto.values())
			if (tipoQuarto.equalsIgnoreCase(t.toString()))
				isTipoInvalido = false;
		if (isTipoInvalido)
			throw new CheckinException("Tipo de quarto invalido.");

		Quarto quarto;
		// Se o quarto não existe, cria o quarto
		try {
			quarto = quartos.buscaQuarto(id);

		} catch (QuartoNotFoundException e) {
			quarto = QuartoFactory.INSTANCE.create(id, tipoQuarto);
			quartos.addQuarto(quarto);
		}

		Estadia estadia;
		// Checa se o quarto esta ocupado
		try {
			estadia = EstadiaFactory.INSTANCE.create(quarto, dias, hospede);
		} catch (QuartoOcupadoException e) {
			throw new CheckinException(e.getMessage());
		}
		estadias.addEstadia(estadia);
	}

	public String getInfoHospedagem(String email, String atributo) throws HospedagemInfoException {
		if (email == null || email.trim().equals(""))
			throw new HospedagemInfoException("Email do(a) hospede nao pode ser vazio.");
		if (!validateEmail(email))
			throw new HospedagemInfoException("Email do(a) hospede esta invalido.");

		Cadastro hospede;
		try {
			hospede = cadastros.buscaCadastro(email);
		} catch (CadastroNotFoundException e) {
			throw new HospedagemInfoException(e.getMessage());
		}
		try {
			return estadias.getInfoHospedagem(hospede, atributo);
		} catch (EstadiaInfoException e) {
			throw new HospedagemInfoException(e.getMessage());
		}
	}

	public String realizaCheckout(String email, String quarto) throws CheckoutException, QuartoNotFoundException {
		if(email == null || email.trim().equals(""))
			throw new CheckoutException("Email do(a) hospede nao pode ser vazio.");
		if(!validateEmail(email))
			throw new CheckoutException("Email do(a) hospede esta invalido.");
		if(!validateId(quarto))
			throw new CheckoutException("ID do quarto invalido, use apenas numeros ou letras.");
		Estadia estadia;
		try {
			estadia = estadias.buscaEstadia(quarto);
		} catch (NoSuchEstadiaException e) {
			throw new CheckoutException();
		}

		if (!estadia.getHospede().getEmail().equals(email))
			throw new CheckoutException();

		registros.addRegistro(
				RegistroFactory.INSTANCE.create(estadia.getHospede().getNome(), quarto, estadia.getPrecoTotal()));
		
		quartos.buscaQuarto(quarto).setOcupadoState();
		estadias.removeEstadia(estadia);
		return String.format("R$%.2f", estadia.getPrecoTotal()).replace(".", ",");
	}

	 public String consultaTransacoes(String atributo) throws ConsultaRegistroException {
		 return registros.consultaTransacoes(atributo);
	 }

	public String consultaTransacoes(String atributo, int indice) throws ConsultaRegistroException {
		return registros.consultaTransacoes(atributo, indice);
	}

	private void validaCadastro(String nome, String email, String dataDeNascimento) throws HotelCadastroException {
		if (!validateName(nome))
			throw new HotelCadastroException("Nome do(a) hospede esta invalido.");
		if (!validateEmail(email))
			throw new HotelCadastroException("Email do(a) hospede esta invalido.");
		if (!validateDate(dataDeNascimento))
			throw new HotelCadastroException("Formato de data invalido.");
		LocalDate dataAtual = LocalDate.now();
		int ano = Integer.parseInt(dataDeNascimento.substring(6));
		int mes = Integer.parseInt(dataDeNascimento.substring(3, 4));
		int dia = Integer.parseInt(dataDeNascimento.substring(0, 1));
		if ((dataAtual.getYear() - ano) < 18)
			throw new HotelCadastroException("A idade do(a) hospede deve ser maior que 18 anos.");
		else if ((dataAtual.getYear() - ano) == 18)
			if ((dataAtual.getMonthValue() - mes) < 0)
				throw new HotelCadastroException("A idade do(a) hospede deve ser maior que 18 anos.");
			else if (dataAtual.getMonthValue() - mes == 0)
				if ((dataAtual.getDayOfMonth() - dia) < 0)
					throw new HotelCadastroException("A idade do(a) hospede deve ser maior que 18 anos.");
	}

	private static final Pattern VALID_NAME_REGEX = Pattern.compile("^[[A-Z]+\\s?]+$", Pattern.CASE_INSENSITIVE);
	private static final Pattern VALID_DATE_REGEX = Pattern
			.compile("^(?:(?:31(/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(/)(?:0?[1,3-9]|1[0-2])\\2))"
					+ "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|"
					+ "^(?:29(/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|"
					+ "(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(/)(?:(?:0?[1-9])|"
					+ "(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", Pattern.CASE_INSENSITIVE);
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
			.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	private static final Pattern VALID_QUARTO_ID_REGEX = Pattern.compile("^[A-Z0-9]+", Pattern.CASE_INSENSITIVE);

	private static boolean validateName(String name) {
		Matcher matcher = VALID_NAME_REGEX.matcher(name);
		return matcher.find();
	}

	private static boolean validateDate(String date) {
		Matcher matcher = VALID_DATE_REGEX.matcher(date);
		return (matcher.find() && Pattern.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d", date));
	}

	private static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	private static boolean validateId(String id) {
		Matcher matcher = VALID_QUARTO_ID_REGEX.matcher(id);
		return matcher.find();
	}
	
	private static final Hotel instance = new Hotel();
}
