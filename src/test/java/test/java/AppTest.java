package test.java;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import dev.utils.StringUtils;

@RunWith(Parameterized.class)
public class AppTest {
	
	@Parameters
	public static Collection<Object[]> datas(){
		List<Object[]> mots = new ArrayList<Object[]>();
		mots.add(new Object[]{"chat", "chats", 1});
		mots.add(new Object[]{"machins", "machine", 1});
		mots.add(new Object[]{"machins", "machine", 1});
		mots.add(new Object[]{"aviron", "avion", 1});
		mots.add(new Object[]{"distance", "instance", 2});
		mots.add(new Object[]{"chien", "chine", 2});
		return mots;
	}
	
	@Parameter public String mot1;
	@Parameter (value = 1) public String mot2;
	@Parameter (value = 2) public int expected2;
	
	@Test
	public void testLevenshteinDistance(){	
		
		assertEquals(expected2, StringUtils.levenshteinDistance(mot1, mot2));

	}
	
	

}
