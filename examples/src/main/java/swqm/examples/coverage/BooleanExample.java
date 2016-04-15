package swqm.examples.coverage;

public class BooleanExample {
	boolean aAndbOrc(boolean a, boolean b, boolean c) {
		boolean result = false;
		if (a && b) {
			result = true;
		} else if (c) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
}