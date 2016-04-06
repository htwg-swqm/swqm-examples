package swqm.examples.payment;

import java.util.Currency;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PaymentMethodServiceImplTestDelegateFixture {
	
	@Test
	public void testKonstanzInvoiceAccepted() {
		//Setup
		Address address = createKonstanzAddress();
		PaymentMethodService paymentMethodService = new PaymentMethodServiceImpl();
		int amount = 500;
		Currency currency = Currency.getInstance("EUR");
		
		// execute
		List<PaymentMethod> acceptedMethods = paymentMethodService.getAcceptedMethods(address, amount, currency);
		
		//verify
		Assert.assertTrue(acceptedMethods.contains(PaymentMethod.invoice));
		
		//Tear Down
	}

	@Test
	public void testKonstanzInvoiceNotAccepted() {
		//Setup
		Address address = createKonstanzAddress();
		PaymentMethodService paymentMethodService = new PaymentMethodServiceImpl();
		int amount = 1500;
		Currency currency = Currency.getInstance("EUR");
		
		// execute
		List<PaymentMethod> acceptedMethods = paymentMethodService.getAcceptedMethods(address, amount, currency);
		
		//verify
		Assert.assertFalse(acceptedMethods.contains(PaymentMethod.invoice));
		
		//Tear Down
	}
	
	@Test
	public void testNotKonstanzInvoiceNotAccepted() {
		//Setup
		Address address = createMaxMustermann();
		address.setPostcode("78343");
		address.setCity("Gaienhofen");
		address.setStreet("Hapotstr. 107");
		PaymentMethodService paymentMethodService = new PaymentMethodServiceImpl();
		int amount = 500;
		Currency currency = Currency.getInstance("EUR");
		
		// execute
		List<PaymentMethod> acceptedMethods = paymentMethodService.getAcceptedMethods(address, amount, currency);
		
		//verify
		Assert.assertFalse(acceptedMethods.contains(PaymentMethod.invoice));
		
		//Tear Down
	}
	
	private Address createKonstanzAddress() {
		Address address = createMaxMustermann();
		address.setPostcode("78462");
		address.setCity("Konstanz");
		address.setStreet("Rheingutstr. 8");
		return address;
	}

	private Address createMaxMustermann() {
		Address address = new Address();
		address.setFirstname("Max");
		address.setSurname("Mustermann");
		return address;
	}
}