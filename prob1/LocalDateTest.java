package prob1;

	public class LocalDateTest {
		public static void main(String[] args) {
			createLocalDateTest();
			testLocalDateOf();
			
			testMinusDays();
			testMinusWeeks();
			testMinusMonth();
			testMinusYears();
			
			testPlusDays();
			testPlusWeeks();
			testPlusMonth();
			testPlusYears();
			
			testCompareDates();
			
		}
		public static void createLocalDateTest() {
			System.out.println("createLocalDateTest()----> 2020-10-10");
			LocalDate date = new LocalDate("2020-10-10");
			System.out.println(date);
		}
		public static void testLocalDateOf() {
			System.out.println("testLocalDateOf()----> 1995,11,21");
			LocalDate date = LocalDate.of(1995,11,21);
			System.out.println(date);
		}
		public static void testMinusDays() {
			System.out.println("testMinusDays(10)----> 1995-11-21");
			LocalDate date = LocalDate.of(1995,11,21);
			LocalDate dateLow = date.minusDays(10);
			System.out.println(dateLow);
		}
		public static void testMinusWeeks() {
			System.out.println("testMinusWeeks(2)----> 1995-11-21");
			LocalDate date = LocalDate.of(1995,11,21);
			LocalDate dateLow = date.minusWeeks(2);
			System.out.println(dateLow);
		}
		public static void testMinusMonth() {
			System.out.println("testMinusMonth(5)----> 2020-12-21");
			LocalDate date = LocalDate.of(2020,12,21);
			LocalDate monthLow = date.minusMonths(5);
			System.out.println(monthLow);
		}
		public static void testMinusYears() {
			System.out.println("testMinusYears(2)----> 2020-12-21");
			LocalDate date = LocalDate.of(2020,12,21);
			LocalDate yearsLow = date.minusYears(2);
			System.out.println(yearsLow);
		}
		
		public static void testPlusDays() {
			System.out.println("testPlusDays(10)----> 1995-11-21");
			LocalDate date = LocalDate.of(1995,11,21);
			LocalDate dateHigh = date.plusDays(10);
			System.out.println(dateHigh);
		}
		public static void testPlusWeeks() {
			System.out.println("testPlusWeeks(2)----> 1995-11-21");
			LocalDate date = LocalDate.of(1995,11,14);
			LocalDate dateLow = date.plusWeeks(2);
			System.out.println(dateLow);
		}
		public static void testPlusMonth() {
			System.out.println("testPlusMonth(5)----> 2020-11-21");
			LocalDate date = LocalDate.of(2020,11,21);
			LocalDate monthHigh = date.plusMonths(1);
			System.out.println(monthHigh);
		}
		public static void testPlusYears() {
			System.out.println("testPlusYears(2)----> 2020-12-21");
			LocalDate date = LocalDate.of(2020,12,21);
			LocalDate yearsHigh = date.plusYears(2);
			System.out.println(yearsHigh);
		}
		public static void testCompareDates() {
			System.out.println("\nTest 0: testCompareDates");
			// Create the object to represent: June 9, 2020. 
			// Format for "of" method: year, month, day
			LocalDate date = LocalDate.of(2020, 6, 9); // year, month, day
			// Create a new date, date1, by subtracting 3 days from date2.
			// Also minusWeeks, minusMonths, minusYears
			LocalDate dateLow = date.minusDays(3); 
			// Create a new date, date3, by adding 3 days to date2.
			// Also plusWeeks, plusMonths, plusYears
			LocalDate dateHigh = date.plusDays(3);
			// Create a date from a string. Format must be: yyyy-mm-dd
			LocalDate date2 = new LocalDate("2020-06-09");
			
			// The toString method prints in format: yyyy-mm-dd
			System.out.println("\nDates: " + dateLow + ", " + date + ", " + dateHigh);
			
			System.out.println("\nDate Comparisons:");
			// See if one date is less than another
			if(dateLow.compareTo(date)<0) {
				System.out.println(dateLow + " < " + date);
			}
			
			// See if one date is greater than another
			if(dateHigh.compareTo(dateLow)>0) {
				System.out.println(dateHigh + " > " + dateLow);
			}

			// See if two dates are equal using compareTo
			if(date.compareTo(date2)==0) {
				System.out.println(date + " = " + date2);
			}

			// See if two dates are equal using equals
			if(date.equals(date2)) {
				System.out.println(date + " = " + date2);
			}
			
			// Get the pieces of a date
			int year = date.getYear();
			int month = date.getMonth();
			int day = date.getDay();
			String msg = String.format("\nPieces of date: mon:%d, day:%d, year:%d", month, day, year);
			System.out.println(msg);

			// toString method format: yyyy-mm-dd, e.g. 2020-06-09
			// System.out.println(date);
		}

	}
