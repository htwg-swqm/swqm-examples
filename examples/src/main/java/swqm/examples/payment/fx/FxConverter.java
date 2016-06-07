package swqm.examples.payment.fx;

import java.util.Currency;

public interface FxConverter {
  public int convertTo(Currency currenctFrom, Currency currencyTo, int amount);
}
