package dev.console;

import dev.exception.CalculException;
import dev.service.CalculService;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class App {

	private Scanner scanner;
	private CalculService calculatrice;
	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public App(Scanner scanner, CalculService calculatrice) {
		this.scanner = scanner;
		this.calculatrice = calculatrice;
	}

	protected void afficherTitre() {
		LOG.info("**** Application Calculatrice ****");
	}

	public void demarrer() {
		afficherTitre();
		LOG.info("Veuillez saisir une expression : ");

		String expression = "";
		while(!expression.equals("fin")){
			expression = scanner.nextLine();
			evaluer(expression);
		}
		LOG.info("Au revoir :-(");
	}

	protected void evaluer(String expression) {
		
		try {
			
			int addition = calculatrice.additionner(expression);
			LOG.debug(expression + "=" + addition);
			
		} catch (CalculException e) {

			LOG.debug("L'expression" + expression + " est invalide");
		}

	}


}
