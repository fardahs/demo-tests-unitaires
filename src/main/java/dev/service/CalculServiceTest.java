package dev.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.assertj.core.api.Assertions.*;

import dev.exception.CalculException;

/**
 * Test unitaire de la classe dev.service.CalculService.
 */
public class CalculServiceTest {
	private static final Logger LOG = LoggerFactory.getLogger(CalculServiceTest.class);
	@Rule
	 public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testAdditionner() throws CalculException{
		LOG.info("Etant donné, une instance de la classe CalculService"); 
		//TODO
		CalculService service = new CalculService();
		LOG.info("Lorsque j'évalue l'addition de l'expression 1+3+4"); 
		//TODO
		int somme = service.additionner("1+3+4");

		LOG.info("Alors j'obtiens le résultat 8");
		// TODO
		assertThat(somme).isEqualTo(8);
		

	}
}
