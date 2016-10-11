package registros;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RegistroOperacoesTest {
	 private RegistroOperacoes registro;
	 private String nome = "Steve";
	 private String id = "1a";
	 private double totalPago = 6543.00;
	
	 @Before
	 public void setup(){
		 this.registro = new RegistroOperacoes(nome, id, totalPago);
	 }
	 
	 @Test
	public void test() {
		assertEquals(id, registro.getId());
		assertEquals(nome, registro.getNome());
		assertEquals(totalPago, registro.getTotalPago(), 0.1);
	}

}
