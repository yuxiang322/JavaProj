
public class Dates {
	private int year;
	private int month;
	private int day;
	
	public Dates(int day, int month, int year) {
		
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int getYear() {
		return year;
	}
	public int setYear(int year) {
		this.year = year;
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int setMonth(int month) {
		this.month = month;
		return month;
	}
	public int getDay() {
		return day;
	}
	public int setDay(int day) {
		this.day = day;
		return day;
	}
	
	public String toString() {
		String str = "";
		str = day + "," + month + "," + year;
		return str;
	}
}
