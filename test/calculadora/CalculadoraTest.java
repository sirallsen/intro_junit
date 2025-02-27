package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa a subtraçao de dois n�meros")
	@Test
	public void testSubtracaoDoisNumeros() {
		int subtracao = calc.subtracao(4, 5);		
		Assertions.assertEquals(-1, subtracao);		
	}
	
	@DisplayName("Testa a multiplicacao de dois n�meros")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int multiplicacao = calc.multiplicacao(8, 4);		
		Assertions.assertEquals(32, multiplicacao);		
	}
	
	@DisplayName("Testa a somatoria de dois n�meros")
	@Test
	public void testSomatoriaNumeros() {
		int somatoria = calc.somatoria(4);		
		Assertions.assertEquals(10, somatoria);		
	}
	
	@DisplayName("Testa se numero e positivo")
	@Test
	public void testPositivoNumero() {	
		assertTrue(calc.ehPositivo(24));		
	}
	
	@DisplayName("Testa a comparacao de dois n�meros")
	@Test
	public void testComparaNumeros() {	
		assertTrue(calc.compara(2, 5) == -1);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

}
