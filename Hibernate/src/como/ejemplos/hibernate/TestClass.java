package como.ejemplos.hibernate;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestClass {

	public static IncrementarSalarios inc;

	@Before
	public void iniciarClase() {
		
		inc = new IncrementarSalarios();
	}
	
	@After
	public void finalizarClase() {
		
	inc = null;
	}
	
	@Test
	public void testIncrementarSalario() {
		
		assertNotNull("Comprobación del método constructor", new IncrementarSalarios());
	}
}
