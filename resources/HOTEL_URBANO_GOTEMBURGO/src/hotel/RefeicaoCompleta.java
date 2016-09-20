package hotel;

import java.util.List;

public class RefeicaoCompleta implements Refeicao {
	private List<Prato> pratoList;
	private String nome;
	private String descricao;
	

	public RefeicaoCompleta(List<Prato> pratoList, String nome, String descricao) {
		//Se lembrar de garantir que a lista é válida
		this.pratoList = pratoList;
		this.nome = nome;
		this.descricao = descricao;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<Prato> getPratoList() {
		return pratoList;
	}


	@Override
	public double getPreco() {
		//Calculado a partir da lista de pratos
		return 0;
	}
	
	//Na uml tem o método setPreco(), mas ele não é válido no contexto
	//Remover o método setPreco() da uml.
	
	public void editaPratoList() {
		//Talvez precise mudar muita coisa (tipo de retorno, atributos)
		//Vai depender de como a especificação quer
		//que a edição seja realizada
		//
		//Assim que decidirmos como será a assinatura do método
		//Podemos implementa-lo
	}

}
