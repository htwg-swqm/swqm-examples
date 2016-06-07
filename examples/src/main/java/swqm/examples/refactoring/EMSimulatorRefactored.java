package swqm.examples.refactoring;

import java.io.PrintStream;
import java.util.Random;

public class EMSimulatorRefactored {
  private Random random = new Random();
  private PrintStream printStream = System.out;

  public Random getRandom() {
    return random;
  }

  public void setRandom(Random random) {
    this.random = random;
  }

  public PrintStream getPrintStream() {
    return printStream;
  }

  public void setPrintStream(PrintStream printStream) {
    this.printStream = printStream;
  }

  enum Team {
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
    printStream.println(output);
  }
}
