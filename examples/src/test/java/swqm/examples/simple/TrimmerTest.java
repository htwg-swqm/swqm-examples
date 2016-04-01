package swqm.examples.simple;
import org.junit.Assert;
import org.junit.Test;

import swqm.examples.simple.Trimmer;

public class TrimmerTest {

	@Test
	public void testEmpty() {
		Trimmer trimmer = new Trimmer("");
		Assert.assertEquals("",trimmer.trim());
	}

	@Test
	public void testNothingtoTrim() {
		Trimmer trimmer = new Trimmer("ABCD");
		Assert.assertEquals("ABCD",trimmer.trim());
	}

	@Test
	public void testLeftSide() {
		Trimmer trimmer = new Trimmer(" abc");
		Assert.assertEquals(" abc",trimmer.trim());
	}

//	@Test
//	public void testRightSide() {
//		Trimmer trimmer = new Trimmer("abc ");
//		Assert.assertEquals("abc",trimmer.trim());
//	}
	
}
