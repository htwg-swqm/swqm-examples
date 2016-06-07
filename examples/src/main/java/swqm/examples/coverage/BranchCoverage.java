package swqm.examples.coverage;

public class BranchCoverage {
  public int sum(int values[], int offset) {
    int result = 0;
    for (int value : values) {
      if (offset > 0) {
        if (offset < value) {
          result += offset;
        }
      }
      result += value;
    }
    return result;
  }
}
