package hotel;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class QuartoSet {
	private SortedSet<Quarto> quartos;

	public QuartoSet() {
		quartos = new TreeSet<>();
	}

	public boolean addQuarto(Quarto q) {
		return quartos.add(q);
	}

	public boolean removeQuarto(Quarto q) {
		return quartos.remove(q);
	}

	public Quarto buscaQuarto(String id) {
		Quarto q = null;
		Iterator<Quarto> i = quartos.iterator();

		while (i.hasNext()) {
			q = i.next();
			if (q.getId().equals(id))
				return q;
		}
		return null;
	}

}
