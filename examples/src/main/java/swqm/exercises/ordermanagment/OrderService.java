package swqm.exercises.ordermanagment;

import java.util.Currency;
import java.util.List;

import swqm.examples.payment.Address;
import swqm.examples.payment.PaymentMethod;
import swqm.examples.payment.PaymentMethodService;
import swqm.examples.payment.PaymentMethodServiceImpl;

public class OrderService {

  Currency EUR = Currency.getInstance("EUR");

  /**
   * Creates an order from a shopping basket of single order items.
   */
  public Order createOrder(Address invoiceAddress, List<OrderItem> orderItems) {
    PaymentMethodService paymentMethodService = new PaymentMethodServiceImpl();
    int totalAmount = 0;
    for (OrderItem item : orderItems) {
      totalAmount += item.getSalesPrice();
    }
    List<PaymentMethod> paymentMethods =
        paymentMethodService.getAcceptedMethods(invoiceAddress, totalAmount, EUR);
    PaymentMethod paymentMethod = paymentMethods.get(0);
    return new Order(invoiceAddress, orderItems, paymentMethod);
  }
}
