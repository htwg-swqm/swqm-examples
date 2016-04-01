package swqm.examples.refactoring;

import org.junit.Test;

import swqm.examples.refactoring.EMSimulator;

public class EMSimulatorTest {

	@Test
	public void simuliere() {
		// setup
		EMSimulator simulator = new EMSimulator();
		
		//execute
		simulator.simuliereSpiel(EMSimulator.Team.DEUTSCHLAND, EMSimulator.Team.FRANKREICH);
	}
	
	@Test
	public void simuliereLoop() {
		// setup
		EMSimulator simulator = new EMSimulator();
		
		//execute
		for (int i=0;i<10;i++) {
			simulator.simuliereSpiel(EMSimulator.Team.DEUTSCHLAND, EMSimulator.Team.FRANKREICH);
		}
	}
}
