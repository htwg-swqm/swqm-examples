package swqm.examples.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class GGTTest {


	@Test
	public void test2NumbersGGT() {
		// setup
		List<Integer> examples = new ArrayList<Integer>();
		examples.add(15);
		examples.add(10);
		GGT ggt = new GGT(examples);
		// execute
		int ggtValue = ggt.get();
		//verify 
		Assert.assertEquals(4, ggtValue);
		//tear down 
	}
	
	@Test
	public void test4NumbersGGT() {
		// setup
		List<Integer> examples = new ArrayList<Integer>();
		examples.add(15);
		examples.add(10);
		examples.add(25);
		examples.add(7);
		GGT ggt = new GGT(examples);
		// execute
		int ggtValue = ggt.get();
		//verify 
		Assert.assertEquals(1, ggtValue);
		//tear down 
	}

	@Test
	public void testEmptyGGT() {
		// setup
		List<Integer> examples = new ArrayList<Integer>();
		GGT ggt = new GGT(examples);
		try {
			// execute
			ggt.get();
			//verify 
			Assert.fail("Expected exception");
		} catch (IllegalArgumentException ie) {
			// expected
		}
	}
	//tear down 
}
