
public class LTStorage {
	private limitAndThreshold ltrecords[];
	
	public LTStorage() {
		ltrecords = new limitAndThreshold[1];
	}
	
	//add Limit and threshold
	public boolean addLT(limitAndThreshold ltrecord) {
		
		for(int i = 0; i < 1;) {
			if(ltrecords[i] == null || ltrecords[i] != null) {
				ltrecords[i] = ltrecord;
				break;
			}
		}
		return true;
	}
	
	//return limit
	public float getLimit() {
		float limit;
		
		limit = ltrecords[0].getLimit();
		
		return limit;
	}
	
	//return percentage
	public float getPercentage() {
		float threshold;
		
		threshold = ltrecords[0].getThreshold();
		
		return threshold;
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
	
	public String write() {
		String str = "";
		for(int i = 0; i < 1; i++) {
			if(ltrecords[i] != null) {
				str = ltrecords[i].write();
			}
		}
		return str;
	}
}
