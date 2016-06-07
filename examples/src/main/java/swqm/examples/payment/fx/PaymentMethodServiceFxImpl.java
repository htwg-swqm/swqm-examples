package swqm.examples.payment.fx;

import java.util.Currency;
import java.util.List;

import swqm.examples.payment.Address;
import swqm.examples.payment.PaymentMethod;
import swqm.examples.payment.PaymentMethodServiceImpl;


public class PaymentMethodServiceFxImpl extends PaymentMethodServiceImpl {

  private FxConverter fxConverter = null;
  private static Currency EUR = Currency.getInstance("EUR");

  @Override
  public List<PaymentMethod> getAcceptedMethods(Address address, int amount, Currency currency)
      throws IllegalArgumentException {

    int eurAmount = amount;
    if (!currency.equals(EUR)) {
      eurAmount = fxConverter.convertTo(currency, EUR, amount);
    } ;
    List<PaymentMethod> result = super.getAcceptedMethods(address, eurAmount, EUR);
    return result;
  }

  public FxConverter getFxConverter() {
    return fxConverter;
  }

  public void setFxConverter(FxConverter fxConverter) {
    this.fxConverter = fxConverter;
  }

}
