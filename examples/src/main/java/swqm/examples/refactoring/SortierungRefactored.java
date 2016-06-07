package swqm.examples.refactoring;

import java.util.*;
import java.util.logging.*;

public class SortierungRefactored {
  private Logger logger = Logger.getLogger(SortierungRefactored.class.getName());

  public Logger getLogger() {
    return logger;
  }

  public void setLogger(Logger logger) {
    this.logger = logger;
  }

  public int[] sortiere(int[] zusortieren) {
    logger.info("Sortiere array" + Arrays.toString(zusortieren));
    int laenge = zusortieren.length;
    int[] sortiert = new int[laenge];
    for (int i = 0; i < laenge; i++) {
      sortiert[i] = zusortieren[i];
      for (int j = i; j < laenge; j++) {
        if (sortiert[i] > zusortieren[j]) {
          int tmp = sortiert[i];
          sortiert[i] = zusortieren[j];
          zusortieren[j] = tmp;
        }
      }
    }
    logger.info("Ergebnis der Sortierung:" + Arrays.toString(sortiert));
    return sortiert;
  }
}
