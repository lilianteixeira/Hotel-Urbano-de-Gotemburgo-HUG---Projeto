
package restaurante;

import java.util.Comparator;

public class RefeicaoComparatorByPrice implements Comparator<Refeicao> {

	public RefeicaoComparatorByPrice() {
	}

	@Override
	public int compare(Refeicao r1, Refeicao r2) {
		if(r1.getValor() == r2.getValor())
			return 0;
		if(r1.getValor() < r2.getValor())
			return -1;
		return 1;
	}

}