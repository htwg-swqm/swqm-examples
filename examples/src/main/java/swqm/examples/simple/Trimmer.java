package swqm.examples.simple;

public class Trimmer {

  private String value;

  public Trimmer(String value) {
    this.value = value;
  }

  /**
   * Trim a String.
   * 
   * @return the trimmed string.
   */
  public String trim() {
    int len = value.length();
    int st = 0;
    String result = value;

    while (st < len && value.charAt(st) <= ' ') {
      st++;
    }
    while ((st < len) && (value.charAt(len - 1) <= ' ')) {
      len--;
    }
    if ((st > 0) || (len < value.length())) {
      result = value.substring(st, len);
    }
    return result;
  }

}
