package prob1;

	public class LocalDate implements Comparable<LocalDate>{
	
	private int day; 
	private int month;
	private int year;
	
	public LocalDate(String date) {
		super();
		this.year = Integer.parseInt(date.substring(0,4));
		this.month = Integer.parseInt(date.substring(5,7));
		this.day = Integer.parseInt(date.substring(8));
	}
	
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public static LocalDate of(int year, int month, int day) {
		LocalDate r;
		if(month<10) {
			 r = new LocalDate(year + "-0" + month + "-" + day);
				return r;
		}
		else {
		 r = new LocalDate(year + "-" + month + "-" + day);
			return r;}

		
	}
	public LocalDate minusDays(int days) {
		LocalDate date;
		if(days > this.day) {
			return null; 
		}
		else {
			this.day = this.day - days;
			date = of(this.year, this.month, this.day);
		}
		return date;
	}
	public LocalDate minusWeeks(int weeks) {
		LocalDate date;
		this.day = this.day - (weeks*7);
		date = of(this.year, this.month, this.day);
		return date;
	}
	public LocalDate minusMonths(int months) {
		LocalDate date;
		if(months > this.month) {
			return null; 
		}
		else {
			this.month = this.month - months;
			date = of(this.year, this.month, this.day);
		}
		return date;
	}
	public LocalDate minusYears(int years) {
		LocalDate date;
		if(years > this.year) {
			return null; 
		}
		else {
			this.year = this.year - years;
			date = of(this.year, this.month, this.day);
		}
		return date;
	}
	public LocalDate plusDays(int days) {
		LocalDate date;
		if((days + this.day) > 31) {
			return null; 
		}
		else {
			this.day = this.day + days;
			date = of(this.year, this.month, this.day);
		}
		return date;
	}
	public LocalDate plusWeeks(int weeks) {
		LocalDate date;
		this.day = this.day + (weeks*7);
		date = of(this.year, this.month, this.day);
		return date;
	}
	public LocalDate plusMonths(int months) {
		LocalDate date;
		if((months + this.month)>12) {
			return null; 
		}
		else {
			this.month = this.month + months;
			date = of(this.year, this.month, this.day);
		}
		return date;
	}
	public LocalDate plusYears(int years) {
		LocalDate date;
			this.year = this.year + years;
			date = of(this.year, this.month, this.day);
		return date;
	}
	@Override
	public boolean equals(Object o) {
		LocalDate date = (LocalDate)o; 
		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDay();
		if(year == this.getYear()&& month == this.getMonth() && day == this.getDay()) {
			return true;}
		return false;
	}
	
	@Override
	public int compareTo(LocalDate date) {
		int yearDiff = date.getYear()-this.getYear();
		int monthDiff = date.getMonth()-this.getMonth();
		int dayDiff = date.getDay()-this.getDay();
		if(yearDiff <= -1) {return 1;}
			else {
			if(monthDiff <= -1) {return 1;}
			else {
				if(dayDiff <= -1) {return 1;}
				
			}
		}
		if(yearDiff == 0 && monthDiff == 0 && dayDiff == 0 ) {
			return 0;
		}
		return -1;
	}
	@Override
	public String toString() {
		return year + "-" + month + "-" + day ;
	}
	}
