package swqm.examples.coverage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BooleanExampleTest {
	BooleanExample booleanExample;
	
	@Before
	public void setUp() {
		booleanExample = new BooleanExample();
	}
	
	@Test
	public void testTTF() {
		boolean value = booleanExample.aAndbOrc(true, true, false);
		Assert.assertTrue(value);
	}

	@Test
	public void testFFT() {
		boolean value = booleanExample.aAndbOrc(false, false, true);
		Assert.assertTrue(value);
	}

	@Test
	public void testFTF() {
		boolean value = booleanExample.aAndbOrc(false, true, false);
		Assert.assertFalse(value);
	}
}
