package restaurante;

public interface Refeicao extends Comparable<Refeicao>{

	public String getNome();

	public void setNome(String nome);

	public double getValor();

	public String getDescricao();

	public void setDescricao(String descricao);

}