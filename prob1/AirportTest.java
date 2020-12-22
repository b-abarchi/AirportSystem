package prob1;

public class AirportTest {

	public static void main(String[] args) {
		testEqualsTrue();
		testEqualsFalse();

	}
	public static void 	testEqualsTrue() {
	Airport a = new Airport("OZR", 31.28, 85.72, "FortRucker", "AL");
	Airport b = new Airport("OZR", 41.28, 85.72, "FortRucker", "AL");
	boolean t = a.equals(b);
	System.out.println(" OZR.equals(OZR)? "+t);
}
	public static void 	testEqualsFalse() {
		Airport a = new Airport("BHM", 33.57, 86.75, "Birmingham", "AL");
		Airport b = new Airport("OZR", 41.28, 85.72, "FortRucker", "AL");
		boolean f = a.equals(b);
		System.out.println(" BHM.equals(OZR)? "+f);
	}
}
