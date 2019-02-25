package dev.console;

import dev.exception.CalculException;
import dev.service.CalculService;
import dev.service.CalculServiceTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AppTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	private static final Logger LOG = LoggerFactory.getLogger(AppTest.class);

	private App app;
	private CalculService calculService;

	@Before
	public void setUp() throws Exception {
		this.calculService = new CalculService();
		Scanner sc = new Scanner(System.in);
		this.app = new App(sc, calculService);
		this.calculService = mock(CalculService.class);
		this.app = new App(sc,calculService);
	}

	@Test
	public void testAfficherTitre() throws Exception {
		this.app.afficherTitre();
		String logConsole = systemOutRule.getLog();
		assertThat(logConsole).contains("**** Application Calculatrice ****");
	}

	@Test
	public void testEvaluer() throws Exception {
		LOG.info("Etant donné, un service CalculService qui retourne 35 à l'évaluation de l'expression 1+34");
		String expression = "1+34";
		
		when(calculService.additionner(expression)).thenReturn(35);
		LOG.info("Lorsque la méthode evaluer est invoquée");
		this.app.evaluer(expression);
		LOG.info("Alors le service est invoqué avec l'expression {}", expression);
		verify(calculService).additionner(expression);
		LOG.info("Alors dans la console, s'affiche 1+34=35");
		assertThat(systemOutRule.getLog()).contains("1+34=35");
	}
	
	@Test
	public void expressionNonValide() throws Exception{
		LOG.info("Etant donné, un service CalculService qui retourne 35 à l'évaluation de l'expression 1+34");
		String expression = "1+34";
		when(calculService.additionner(expression)).thenThrow(CalculException.class);
		LOG.info("L'expression {} est invalide", expression);
	}


}
