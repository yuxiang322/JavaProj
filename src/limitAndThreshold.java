
public class limitAndThreshold {
	
	private float limit;
	private float percentage;
	
	public limitAndThreshold(float limit, float percentage) {
		this.limit = limit;
		this.percentage = percentage;
	}
	
	public float getLimit() {
		return limit;
	}
	public float setLimit(int limit) {
		this.limit = limit;
		return limit;
	}
	public float getPercentage() {
		return percentage;
	}
	public float setPercentage(float percentage) {
		this.percentage = percentage;
		return percentage;
	}
	
	public String toString() {
		String str = "";
		
		String lmt = String.valueOf(limit);
		String perc = String.valueOf(percentage);
		
		str = "$"+ lmt + ", " + perc + "\n";
		return str;
	}
}
