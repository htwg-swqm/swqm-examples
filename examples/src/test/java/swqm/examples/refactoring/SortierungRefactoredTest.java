package swqm.examples.refactoring;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import swqm.examples.refactoring.SortierungRefactored;

public class SortierungRefactoredTest {
	
	@Test
	public void testTwoNumbers() {
		// fixture
		SortierungRefactored sortierung = new SortierungRefactored();
		Logger logger = Logger.getLogger(SortierungRefactored.class.getName());
		Logger loggerSpy = Mockito.spy(logger);
		sortierung.setLogger(loggerSpy);
		int[] input = {2, 1};
		
		// execution
		int[] output = sortierung.sortiere(input);
		
		// verify
		int[] expected = {1, 2};
		Assert.assertArrayEquals(expected, output);
		Mockito.verify(loggerSpy).info("Ergebnis der Sortierung:[1, 2]");
		Mockito.verify(loggerSpy).info("Sortiere array[2, 1]");
	}
}
