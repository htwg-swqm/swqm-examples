package swqm.examples.refactoring;

import java.util.Random;

public class EMSimulator {
	private Random random = new Random();

	public enum Team {
		DEUTSCHLAND, FRANKREICH, ITALIEN, OTHER;
	}
	
	public void simuliereSpiel(Team firstTeam, Team secondTeam) {
		int firstTeamGoals = random.nextInt() % 4;
		int secondTeamGoals = random.nextInt() % 4;
		String output = "Ausgang irrelevant";
		if (Team.DEUTSCHLAND.equals(firstTeam))
			if (secondTeamGoals > firstTeamGoals) 
				output = "Deutschland verliert";
			else 
				output = "Deutschland hat nicht verloren";
		if (Team.DEUTSCHLAND.equals(secondTeam))
			if (firstTeamGoals > secondTeamGoals) 
				output = "Deutschland hat nicht verloren";
			else
				output = "Deutschland verliert";
		System.out.println(output);
	}
}