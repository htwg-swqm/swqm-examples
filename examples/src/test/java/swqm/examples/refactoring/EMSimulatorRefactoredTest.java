package swqm.examples.refactoring;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import swqm.examples.refactoring.EMSimulatorRefactored;

public class EMSimulatorRefactoredTest {

	EMSimulatorRefactored simulator;

	@Before
	public void setUp() {
		simulator = new EMSimulatorRefactored();
		@SuppressWarnings("serial")
		Random randomStub = new Random() {
			int count = 0;
			int series[] = { 2, 0 };

			@Override
			public int nextInt() {
				return series[count++ % 2];
			}
		};
		simulator.setRandom(randomStub);
	}

	@Test
	public void testDeutschlandGewinnt() {
		simulator.simuliereSpiel(EMSimulatorRefactored.Team.DEUTSCHLAND, EMSimulatorRefactored.Team.FRANKREICH);
	}

	@Test
	public void testDeutschlandGewinntVerify() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(bos);
		simulator.setPrintStream(printStream);

		simulator.simuliereSpiel(EMSimulatorRefactored.Team.DEUTSCHLAND, EMSimulatorRefactored.Team.FRANKREICH);

		Assert.assertEquals("Deutschland hat nicht verloren".trim(), new String(bos.toByteArray()).trim());
	}

}
