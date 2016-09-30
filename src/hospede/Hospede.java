package hospede;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cartaoFidelidade.CartaoFidelidade;
import exceptions.StringInvalidaException;

public class Hospede {

	private String nome;
	private String email;
	private String dataNascimento;
	private CartaoFidelidade cartaoFidelidade;



	public Hospede(String nome, String email, String dataDeNascimento) throws Exception {
				
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataDeNascimento;
		this.cartaoFidelidade = new CartaoFidelidade();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		if (nome == null || nome.trim().equals(""))
			throw new StringInvalidaException(
					"Erro na atualizacao do cadastro de Hospede. Nome do(a) hospede nao pode ser vazio.");
		if (nome.contains("@"))
			throw new StringInvalidaException(
					"Erro na atualizacao do cadastro de Hospede. Nome do(a) hospede esta invalido.");
		this.nome = nome;
	}

	public String getEmail() throws Exception  {
		if (email == null || email.trim().equals(""))
		throw new StringInvalidaException(
				"Erro na atualizacao do cadastro de Hospede. Email do(a) hospede nao pode ser vazio.");
	if (!isEmailValid(email))
		throw new StringInvalidaException(
				"Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.");

		return email;
	}

	public void setEmail(String email)  throws Exception  {
		if (email == null || email.trim().equalsIgnoreCase("")) {
			throw new StringInvalidaException("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede nao pode ser vazio.");
		}
		if (!isEmailValid(email)) {
			throw new StringInvalidaException("Erro na atualizacao do cadastro de Hospede. Email do(a) hospede esta invalido.");
		}
		this.email = email;
	}

	public String getDataNascimento() {
		
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) throws Exception {
		if (dataNascimento == null || dataNascimento.trim().equals("")) {
			throw new StringInvalidaException(
					"Erro na atualizacao do cadastro de Hospede. Data de Nascimento do(a) hospede nao pode ser vazio.");
		}
		
		try {
			converteParaData(dataNascimento);
		} catch (ParseException e) {
			throw new StringInvalidaException("Erro na atualizacao do cadastro de Hospede. Formato de data invalido.");
		}
		
		this.dataNascimento = dataNascimento;
	}
	
	public CartaoFidelidade getCartaoFidelidade() {
		return cartaoFidelidade;
	}

	public boolean isEmailValid(String email) {
		if ((email == null) || (email.trim().equalsIgnoreCase("")))
			return false;

		String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
		Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		java.util.regex.Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private Date converteParaData(String dataString) throws StringInvalidaException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		Date data = sdf.parse(dataString);
		return data;
	}

	public void setInfoCadastro(String atributo, String alteracao) throws Exception {
		if(atributo.equalsIgnoreCase("Nome")) {
			setNome(alteracao);
			
		}
		if(atributo.equalsIgnoreCase("Data de nascimento")) {
			setDataNascimento(alteracao);
			
		}
		if(atributo.equalsIgnoreCase("Email")) {
			setEmail(alteracao);
			
		}
		
	}
	
	
}


