
public class ItemsDescription {
	
	private String description;
	private float amount;
	private Dates date;
	
	public String getDescription() {
		return description;
	}
	public String setDescription(String description) {
		this.description = description;
		return description;
	}
	public float getAmount() {
		return amount;
	}
	public float setAmount(float amount) {
		this.amount = amount;
		return amount;
	}
	public Dates getDate() {
		return date;
	}
	public Dates setDate(Dates date) {
		this.date = date;
		return date;
	}
	
	public ItemsDescription(Dates date, String description, float amount) {
		this.description = description;
		this.amount = amount;
		this.date = date;
	}
	
	public String toString() {
		String str = "";
		str += date + "," + description + "," + amount + "\n";
		return str;
	}
	
	
}
