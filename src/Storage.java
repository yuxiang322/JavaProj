
public class Storage {
	private ItemsDescription records[];
	private int count;
	
	public Storage() {
		records = new ItemsDescription[50];
		count = 0;
	}
	
	//Check whether spending is above threshold
	public boolean threshold(float limit, float percentage) {
		float total = 0;
		
		for(int i = 0; i < 50; i++) {
			if(records[i] != null) {
				total += records[i].getAmount();
			}
		}
		
		if((total / limit) > percentage) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Check whether limit is reached
	public boolean limitChecker(float limit) {
		float total = 0;
		
		for(int i = 0; i < 50; i++) {
			if(records[i] != null) {
				total += records[i].getAmount();
			}
		}
		
		if(total > limit) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//removing transactions
	public ItemsDescription removeItem(ItemsDescription item) {
		ItemsDescription record = null;
		
		if(count == 0) {
			return null;
		}
		
		for(int i = 0; i < 50; i++) {
			if(((records[i].getDate().equals(item.getDate())) && records[i].getDescription().equals(item.getDescription())) && (records[i].getAmount() == item.getAmount())) {
				record = records[i];
				records[i] = null;
				count --;
				break;
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
	
	public String toString(){
		String str = "";
		for(int i = 0; i < 50; i++) {
			if(records[i] != null) {
				str += records[i];
			}
		}
		return str;
	}
	
}
