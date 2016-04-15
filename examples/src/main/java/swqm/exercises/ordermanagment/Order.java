package swqm.exercises.ordermanagment;

import java.util.List;

import swqm.examples.payment.Address;
import swqm.examples.payment.PaymentMethod;

public class Order {
	private Address invoiceAdress;
	private List<OrderItem> items;
	private PaymentMethod paymentMethod;
	
	public Order( Address invoiceAdress, List<OrderItem> items, PaymentMethod paymentMethod) {
		super();
		this.invoiceAdress = invoiceAdress;
		this.items = items;
		this.paymentMethod = paymentMethod;
	}
}
