package swqm.examples.payment;

import java.util.Currency;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PaymentMethodServiceImplTestImplicitFixture {
	
	private Address konstanzAddress = null;
	private Address gaienhofenAddress = null;
	private Currency currency = null;
	private PaymentMethodService paymentMethodService = null;

	@Before
	public void setup() {
		konstanzAddress = new Address();
		konstanzAddress.setFirstname("Max");
		konstanzAddress.setSurname("Mustermann");
		konstanzAddress.setPostcode("78462");
		konstanzAddress.setCity("Konstanz");
		konstanzAddress.setStreet("Rheingutstr. 8");
		gaienhofenAddress = new Address();
		gaienhofenAddress.setFirstname("Max");
		gaienhofenAddress.setSurname("Mustermann");
		gaienhofenAddress.setPostcode("78343");
		gaienhofenAddress.setCity("Gaienhofen");
		gaienhofenAddress.setStreet("Hauptstr. 107");
		paymentMethodService = new PaymentMethodServiceImpl();
		currency = Currency.getInstance("EUR");
	}
	
	@Test
	public void testKonstanzInvoiceAccepted() {
		//Setup
		
		// execute
		List<PaymentMethod> acceptedMethods = paymentMethodService.getAcceptedMethods(konstanzAddress, 500, currency);
		
		//verify
		Assert.assertTrue(acceptedMethods.contains(PaymentMethod.invoice));
		
		//Tear Down
	}

	@Test
	public void testKonstanzInvoiceNotAccepted() {
		//Setup
		
		// execute
		List<PaymentMethod> acceptedMethods = paymentMethodService.getAcceptedMethods(konstanzAddress, 1500, currency);
		
		//verify
		Assert.assertFalse(acceptedMethods.contains(PaymentMethod.invoice));
		
		//Tear Down
	}
	
	@Test
	public void testNotKonstanzInvoiceNotAccepted() {
		//Setup
		
		// execute
		List<PaymentMethod> acceptedMethods = paymentMethodService.getAcceptedMethods(gaienhofenAddress, 500, currency);
		
		//verify
		Assert.assertFalse(acceptedMethods.contains(PaymentMethod.invoice));
		
		//Tear Down
	}
}
