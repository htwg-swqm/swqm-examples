package swqm.exercises;

import java.util.*;
import java.util.logging.*;

public class Sortierung {
  public int[] sortiere(int[] zusortieren) {
    Logger logger = Logger.getLogger(Sortierung.class.getName());
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
