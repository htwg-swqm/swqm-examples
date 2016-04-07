package swqm.examples.simple;
import org.junit.Assert;
import org.junit.Test;

import swqm.examples.simple.Trimmer;

public class TrimmerTest {

	@Test
	public void testEmpty() {
		// setup
		Trimmer trimmer = new Trimmer("");
		// execute
		String result = trimmer.trim();
		// verify
		Assert.assertEquals("",result);
		// tear down
	}

	@Test
	public void testNothingtoTrim() {
		// setup
		Trimmer trimmer = new Trimmer("ABCD");
		// execute
		String result = trimmer.trim();
		// verify
		Assert.assertEquals("ABCD",result);
		// tear down
	}

	@Test
	public void testLeftSide() {
		// setup
		Trimmer trimmer = new Trimmer(" abc");
		// execute
		String result = trimmer.trim();
		// verify
		Assert.assertEquals("abc",result);
		// tear down
	}

	@Test
	public void testRightSide() {
		// setup
		Trimmer trimmer = new Trimmer("abc ");
		// execute
		String result = trimmer.trim();
		// verify
		Assert.assertEquals("abc",result);
		// tear down
	}
}
