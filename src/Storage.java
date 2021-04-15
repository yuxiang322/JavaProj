
public class Storage {
	private ItemsDescription records[];
	private int count;
	
	public Storage() {
		records = new ItemsDescription[50];
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
