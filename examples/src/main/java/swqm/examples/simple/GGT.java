package swqm.examples.simple;

import java.util.List;

public class GGT {
  private final List<Integer> values;

  public GGT(List<Integer> values) {
    if (values.isEmpty()) {
      throw new IllegalArgumentException();
    }
    this.values = values;
  }

  public int get() {
    int value = values.get(0);
    for (int i = 1; i < values.size(); i++) {
      int a = values.get(i);
      int b = value;
      while (b != 0) {
        if (a > b)
          a = a - b;
        else
          b = b - a;
      }
      value = a;
    }
    return value;
  }
}
