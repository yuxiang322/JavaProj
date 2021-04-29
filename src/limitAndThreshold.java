
public class limitAndThreshold {
	
	private float limit;
	private float threshold;
	
	public limitAndThreshold(float limit, float threshold) {
		this.limit = limit;
		this.threshold = threshold;
	}
	
	public float getLimit() {
		return limit;
	}
	public float setLimit(int limit) {
		this.limit = limit;
		return limit;
	}
	public float getThreshold() {
		return threshold;
	}
	public float setThreshold(float threshold) {
		this.threshold = threshold;
		return threshold;
	}
	
	public String toString() {
		String str = "";
		
		String lmt = String.valueOf(limit);
		String perc = String.valueOf(threshold);
		
		str = "$" + lmt + ", " + perc + "\n";
		return str;
	}
	
	public String write() {
		String str = "";
		String lmt = String.valueOf(limit);
		String perc = String.valueOf(threshold);
		
		str = lmt + ", " + perc;
		
		return str;
	}
	
}
