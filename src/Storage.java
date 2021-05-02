
public class Storage {
	private ItemsDescription records[];
	private int count;
	
	public Storage() {
		records = new ItemsDescription[50];
		count = 0;
	}
	
	
	//Check whether spending is above threshold
	public boolean threshold(float limit, float threshold, int cyear, int cmonth, int cday) {
		float total = 0;
		
		for(int i = 0; i < 50; i++) {
			if(records[i] != null) {
				if(records[i].getDate().getYear() == cyear && (records[i].getDate().getMonth() == (cmonth + 1)) && (records[i].getDate().getDay() == cday)) {
					total += records[i].getAmount();
				}
			}
		}
		
		if((total / limit) > threshold) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Check whether limit is reached
	public boolean limitChecker(float limit, int cyear, int cmonth, int cday) {
		float total = 0;
		
		for(int i = 0; i < 50; i++) {
			if(records[i] != null) {
				if(records[i].getDate().getYear() == cyear && (records[i].getDate().getMonth() == (cmonth + 1)) && (records[i].getDate().getDay() == cday)) {
					total += records[i].getAmount();
				}
			}
		}
		
		if(total > limit) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//removing transactions
	public ItemsDescription removeItem(int year, int month, int day, String description, float amount) {
		ItemsDescription record = null;
	
		for(int i = 0; i < 50; i++) {
			if(records[i] != null) { 
				if((records[i].getDescription().equals(description)) && (records[i].getAmount() == amount) && (records[i].getDate().getYear() == year) && (records[i].getDate().getMonth() == month) && (records[i].getDate().getDay() == day)) {
					record = records[i];
					records[i] = null;
					count --;
					break;
				}
		
			}
		}
		return record;
	}
	
	//adding transactions
	public boolean addItem(ItemsDescription record) {
		if(count == 50) {
			return false;
		}
		
		for(int i = 0; i < 50; i++) {
			if(records[i] == null) {
				records[i] = record;
				count++;
				break;
			}
		}
		return true;
	}
	//check if records is null or not also returning the checked item.
	public ItemsDescription checkitem(int i) {
		
		ItemsDescription item = null;
		
		if(records[i] != null) {
			item = records[i];
		}
		
		return item;
	}
	
	public String toString(){
		String str = "";
		for(int i = 0; i < 50; i++) {
			if(records[i] != null) {
				str += records[i];
			}
		}
		return str;
	}
	
	public String write() {
		String str = "";
		for(int i  = 0; i < 50; i++) {
			if(records[i] != null) {
				str += records[i].write() + "\n";
			}
		}
		return str;
	}
}
