package swqm.examples.coverage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BranchCoverageTest {

	private BranchCoverage branchCoverage;
	
	@Before
	public void setUp(){
		branchCoverage = new BranchCoverage();
	}
	
	@Test
	public void testBranch1() {
		int values[] = {2};
		int result = branchCoverage.sum(values,1);
		assertEquals(3,result);
	}
	

  	@Test
	public void testBranch2() {
		int values[] = {2};
		int result = branchCoverage.sum(values,0);
		assertEquals(2,result);
	} 

  	@Test
	public void testBranch3() {
		int values[] = {2};
		int result = branchCoverage.sum(values,2);
		assertEquals(2,result);
	} 

}
