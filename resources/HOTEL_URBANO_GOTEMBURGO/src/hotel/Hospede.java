//IMPORTANTE :
/*
 * IMPLEMENTEM ATÉ O QUE JÁ ESTÁ IMPLEMENTADO
 * PARA ADICIONAREM EXCEPTIONS E OUTRAS COISAS QUE FALTAM.
 */

package hotel;

public class Hospede {
	private String nome;
	private String email;
	private int anoDeNascimento;
	
	public Hospede(String nome, String email, int anoDeNascimento) {
		//Construtor
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAnoDeNascimento() {
		return anoDeNascimento;
	}

	public void setAnoDeNascimento(int anoDeNascimento) {
		this.anoDeNascimento = anoDeNascimento;
	}
	
	
}
