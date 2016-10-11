package hospede;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HospedeTest {
	private String nome = "Capitao america";
	private String nome2 = "America Capitao";
	private String email = "capitao@america.com";
	private String dataNascimento = "25/12/1962";
	private Hospede hospede;

	@Before
	public void setup() {
		this.hospede = new Hospede(nome, email, dataNascimento);
	}

	@Test
	public void testGetNome() {
		assertEquals(nome, hospede.getNome());
	}

	public void testSetNome() {
		hospede.setNome(nome2);
		assertEquals(nome2, hospede.getNome());
	}

	public void testGetEmail() {
		assertEquals(email, hospede.getEmail());
	}
	
	public void testGetDataNascimento() {
		assertEquals(dataNascimento, hospede.getDataNascimento());
	}
	
}
