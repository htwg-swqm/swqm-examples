package swqm.examples.payment;

import java.util.Currency;
import java.util.List;

/**
 * PaymentService provides methods to process payments.
 * 
 * @author meiglspe
 *
 */
public interface PaymentMethodService {

	/**
	 * Returns the list of accepted payment methods for a given person, living at a given address for a given amount.
	 * 
	 * @param address	The name and address of the person for which the payment method should be determined..
	 * @param amount 	The amount of the payment. Must be greater than 0.
	 * @param currency	The currency of the payment amount. Currently only EUR and USD are supported.
	 * @return the accepted payment methods
	 */
	public List<PaymentMethod> getAcceptedMethods(Address address, int amount, Currency currency) throws IllegalArgumentException;
	
}
