package swqm.examples.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import swqm.examples.simple.GGT;

public class GGTTest {

	@Before
	public void setUp() {
	}

	@Test
	public void test2NumbersGGT() {
		List<Integer> examples = new ArrayList<Integer>();
		examples.add(15);
		examples.add(10);
		GGT ggt = new GGT(examples);
		int ggtValue = ggt.get();
		Assert.assertEquals(4, ggtValue);
	}

	@Test
	public void testEmptyGGT() {
		List<Integer> examples = new ArrayList<Integer>();
		try {
			GGT ggt = new GGT(examples);
			ggt.get();
			Assert.fail("Expected exception");
		} catch (IllegalArgumentException ie) {
			// expected
		}
	}

	@After
	public void tearDown() {
	}
}
