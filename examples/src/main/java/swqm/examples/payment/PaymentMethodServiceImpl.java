package swqm.examples.payment;

import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.List;

/**
 * Implementation of the PaymentService which returns all payment methods for
 * people living in Konstanz and prepayment for all others.
 * 
 * @author meiglspe
 *
 */
public class PaymentMethodServiceImpl implements PaymentMethodService {

	private String validPostcodes[] = { "78462", "78464", "78465", "78467" };
	private String blacklist[] = { "Markus/Eiglsperger" };
	private int limit = 1000;

	/**
	 * Returns the list of accepted payment methods for a given person, living at a given address for a given amount.
	 * 
	 * @param address	The name and address of the person for which the payment method should be determined..
	 * @param amount 	The amount of the payment. Must be greater than 0.
	 * @param currency	The currency of the payment amount. Currently only EUR are supported.
	 * @return the accepted payment methods
	 */
	public List<PaymentMethod> getAcceptedMethods(Address address, int amount, Currency currency)
			throws IllegalArgumentException {
		// check address
		if (address == null)
			throw new IllegalArgumentException("Address is null!");
		if (address.getFirstname() == null)
			throw new IllegalArgumentException("Firstname is null!");
		if (address.getSurname() == null)
			throw new IllegalArgumentException("Surname is null!");
		if (address.getPostcode() == null)
			throw new IllegalArgumentException("Postcode in address is null!");
		// check currency
		if (!Currency.getInstance("EUR").equals(currency))
			throw new IllegalArgumentException("Invalid Currency: "+currency);

		// check properties
		boolean inBlacklist = Arrays.asList(blacklist).contains(address.getFirstname() + "/" + address.getSurname());

		boolean inConstance = Arrays.asList(validPostcodes).contains(address.getPostcode());

		boolean inLimit = (amount <= limit);

		// apply rules
		if (inBlacklist) {
			return Collections.emptyList();
		}
		
		if (inConstance) {
			if (inLimit) {
				return Arrays.asList(PaymentMethod.creditcard, PaymentMethod.invoice, PaymentMethod.prepayment);
			} else {
				return Arrays.asList(PaymentMethod.creditcard, PaymentMethod.prepayment);
			}
		} else {
			return Arrays.asList(PaymentMethod.prepayment);
		}
	}
}
