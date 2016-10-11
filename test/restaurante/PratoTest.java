package restaurante;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PratoTest {
	private String nome = "Macarrao com queijo";
	private String nome2 = "Macarronada";
	private double preco = 10.00;
	private String descricao = "Penne com queijo";
	private Prato prato;

	@Before
	public void setup() {
		this.prato = new Prato(nome, preco, descricao);
	}

	@Test
	public void testGetNome() {
		assertEquals(nome, prato.getNome());
	}

	@Test
	public void testSetNome() {
		prato.setNome(nome2);
		assertEquals(nome2, prato.getNome());
	}

	@Test
	public void testGetValor() {
		assertEquals(preco, prato.getValor(), 0.01);
	}

	@Test
	public void testGetDescricao() {
		assertEquals(descricao, prato.getDescricao());

	}

}
