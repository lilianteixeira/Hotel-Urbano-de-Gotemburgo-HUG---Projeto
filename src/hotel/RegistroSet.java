package hotel;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RegistroSet {
	private Set<RegistroCheckOut> registroSet;

	public RegistroSet() {
		this.registroSet = new HashSet<>();
	}

	public boolean addRegistro(RegistroCheckOut r) {
		return registroSet.add(r);
	}

	public Iterator<RegistroCheckOut> iterator() {
		return registroSet.iterator();
	}

}
