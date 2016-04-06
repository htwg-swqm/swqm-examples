package swqm.examples.payment.fx;

import java.util.Currency;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import swqm.examples.payment.Address;
import swqm.examples.payment.PaymentMethod;
import swqm.examples.payment.PaymentMethodService;

public class PaymentMethodServiceFxImplTest {

	@Test
	public void testKonstanzInvoiceEURAccepted() {
		//Setup
		PaymentMethodService paymentMethodService = new PaymentMethodServiceFxImpl();
		Address address = createKonstanzAddress();
		Currency currency = Currency.getInstance("EUR");
		int amount = 500;
		
		// execute
		List<PaymentMethod> acceptedMethods = paymentMethodService.getAcceptedMethods(address, amount, currency);
		
		//verify
		Assert.assertTrue(acceptedMethods.contains(PaymentMethod.invoice));
		
		//Tear Down
	}

	@Test
	public void testKonstanzInvoiceCHFAccepted() {
		//Setup
		Address address = createKonstanzAddress();
		Currency currency = Currency.getInstance("CHF");
		Currency eur = Currency.getInstance("EUR");
		int amount = 500;
		PaymentMethodServiceFxImpl paymentMethodService = new PaymentMethodServiceFxImpl();
		FxConverter fxConverter = Mockito.mock(FxConverter.class);
		paymentMethodService.setFxConverter(fxConverter);
		Mockito.when(fxConverter.convertTo(currency, eur, amount)).thenReturn(600);
		
		// execute
		List<PaymentMethod> acceptedMethods = paymentMethodService.getAcceptedMethods(address, amount, currency);
		
		//verify
		Assert.assertTrue(acceptedMethods.contains(PaymentMethod.invoice));
		Mockito.verify(fxConverter).convertTo(currency, eur, amount);
		
		//Tear Down
	}
	
	@Test
	public void testKonstanzInvoiceCHFNotAccepted() {
		//Setup
		Address address = createKonstanzAddress();
		Currency currency = Currency.getInstance("CHF");
		int amount = 990;
		PaymentMethodServiceFxImpl paymentMethodService = new PaymentMethodServiceFxImpl();
		FxConverter fxConverter = Mockito.mock(FxConverter.class);
		paymentMethodService.setFxConverter(fxConverter);
		Mockito.when(fxConverter.convertTo(currency, Currency.getInstance("EUR"), amount)).thenReturn(1100);
		
		// execute
		List<PaymentMethod> acceptedMethods = paymentMethodService.getAcceptedMethods(address, amount, currency);
		
		//verify
		Assert.assertFalse(acceptedMethods.contains(PaymentMethod.invoice));
		Mockito.verify(fxConverter).convertTo(currency, Currency.getInstance("EUR"), amount);
		
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

