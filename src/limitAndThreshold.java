
public class limitAndThreshold {
	
	private int limit;
	private float percentage;
	private int count;
	
	public limitAndThreshold(int limit, float percentage) {
		this.limit = limit;
		this.percentage = percentage;
		count = 0;
	}
	
	public int getLimit() {
		return limit;
	}
	public int setLimit(int limit) {
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
		str = limit + "," + percentage;
		return str;
	}
}
