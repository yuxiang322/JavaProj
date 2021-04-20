
public class LTStorage {
	private limitAndThreshold ltrecords[];
	private int count;
	
	public LTStorage() {
		ltrecords = new limitAndThreshold[1];
		count = 0;
	}
	
	//add Limit and threshold
	public boolean addLT(limitAndThreshold ltrecord) {
		if(count == 1) {
			return false;
		}
		
		for(int i = 0; i < 1; i++) {
			if(ltrecords[i] == null) {
				ltrecords[i] = ltrecord;
				count++;
				break;
			}
		}
		return true;
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i < 1; i++) {
			if(ltrecords[i] != null) {
				String lt = String.valueOf(ltrecords[i]);
				str = lt;
			}
		}
		return str;
	}
}
