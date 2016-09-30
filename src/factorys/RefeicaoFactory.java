
package factorys;

import java.util.List;

import restaurante.Prato;
import restaurante.Refeicao;
import restaurante.RefeicaoCompleta;

public class RefeicaoFactory {
//	INSTANCE;
	
	public Refeicao createPrato(String nome, double preco, String descricao) {
		return Prato.novoPrato(nome, preco, descricao);
	}
	public Refeicao createRefeicaoCompleta(String nome, String descricao, List<Prato> componentes) {
		return RefeicaoCompleta.novaRefeicaoCompleta(nome, descricao, componentes);
	}

}