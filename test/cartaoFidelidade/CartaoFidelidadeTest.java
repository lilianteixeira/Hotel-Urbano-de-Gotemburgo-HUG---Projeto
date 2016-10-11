package cartaoFidelidade;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CartaoFidelidadeTest {
	
	private CartaoFidelidade cartao;
	
	
	@Before
	public void setup() {
		this.cartao = new CartaoFidelidade();
	}
	
	@Test
	public void testGetPontuacao(){
		assertEquals(0, cartao.getPontuacao());
	}
	
//	@Test
//	public void testSetPontuacao(){
//		/*
//		 * altera pontuacao para valor passado no parametro
//		 */
//		cartao.setPontuacao(250);
//		assertEquals(250, cartao.getPontuacao());
//	}
//	
	@Test
	public void testAdicionaPontos(){
		/* 
		 * Tipo de cartao padrao, adiciona 10% do valor gastos aos pontos
		 * ao chegar em 350 pontos, se torna premuim 
		*/
		cartao.adicionaPontos(2500);
		assertEquals(250, cartao.getPontuacao());
		assertEquals("Padrao", cartao.getTipoDeCartao().toString());
		
		cartao.adicionaPontos(1000);
		assertEquals(350, cartao.getPontuacao());
		assertEquals("Premium", cartao.getTipoDeCartao().toString());
		/*
		 * Tipo premium adiciona 30% do valor gasto a pontuacao + 10 pontos a cada 100$
		 * ao passar de 1000 pontos atualiza para vip
		*/
		cartao.adicionaPontos(1637);
		assertEquals(1001, cartao.getPontuacao());
		assertEquals("Vip", cartao.getTipoDeCartao().toString());
		/* 
		 * Tipo vip converte 50% do valor gasto em pontos 
		*/
		cartao.adicionaPontos(1000);
		assertEquals(1501, cartao.getPontuacao());
	}
	@Test
	public void testDiminuiPontosConvertidos(){
		/*
		 * Pontos do cartao fidelidade podem ser trocados por descontos
		 * quando feito isso pontuacao diminui e se	necessario alterado
		 * o tipo de cartao
		 */
		cartao.adicionaPontos(10010);
		assertEquals(1001, cartao.getPontuacao());
		assertEquals("Vip", cartao.getTipoDeCartao().toString());
		
		cartao.diminuiPontosConvertidos(100);
		assertEquals(901, cartao.getPontuacao());
		assertEquals("Premium", cartao.getTipoDeCartao().toString());
		
		cartao.diminuiPontosConvertidos(552);
		assertEquals(349, cartao.getPontuacao());
		assertEquals("Padrao", cartao.getTipoDeCartao().toString());
		
		
		
		
	}
}
