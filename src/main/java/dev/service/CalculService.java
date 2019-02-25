package dev.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.exception.CalculException;

public class CalculService{

	private static final Logger LOG = LoggerFactory.getLogger(CalculService.class);

	public int additionner(String expression) throws CalculException {
		// TODO Ajouter un log en niveau DEBUG affichant "Evaluation de l'expression <expression>".
		LOG.debug("Evaluation de l'expression {}", expression);

		// TODO par exemple "Evaluation de l'expression 1+4"
		int somme = 0;
		Pattern pattern = Pattern.compile("(\\d+)\\+(\\d+)\\+(\\d+)");
		Matcher matcher = pattern.matcher(expression);
		
		try{
			if (matcher.matches()) {
				somme = Integer.valueOf(matcher.group(1)) + Integer.valueOf(matcher.group(2))+  Integer.valueOf(matcher.group(3));
			}
		}catch(Exception e){
			somme = 0;
			throw new CalculException("Expression non valide");
		}
		
		return somme;
	}
}
