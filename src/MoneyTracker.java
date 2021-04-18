import java.io.*;
import java.util.Scanner;

/* App that allow user to enter their spending
 * app will keep a record
 * app will store an show all the record
 * user can set daily $ limit
 * once certain threshold (75% of $) user will be informed*/

//menu based Change limit and threshold
//           Added new Transaction
//           List Transactions by choosen dates 
//			 Remove transactions based on Description, amount, date
//           Save and exit

//classes MoneyTracker(main) | Records.txt | ItemsDescription | Storage | limitAndThreshold | Dates
//function to prompt user to enter ITEM: AMOUNT:
//A file to store all the data in array
//function to write user prompt into file
//function to display records based on dates
//implement GUI

public class MoneyTracker {
	private Storage storageArray[];
	private LTStorage limitArray[];
	private Scanner sc;
	
	public MoneyTracker() throws Exception {
		Scanner sctwo = new Scanner(System.in);
		
		int dLimit = 0;
		float thres = 0;
		
		
		storageArray = new Storage[1];
		
		storageArray[0] = new Storage();
		
		File file = new File("Records.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str;
		
		while((str = br.readLine()) != null) {
			String arr[] = str.split(",");
			Dates date = new Dates(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
			ItemsDescription record = new ItemsDescription(date, arr[3], Float.parseFloat(arr[4]));
			
			storageArray[0].addItem(record);
			
		}
		//----------------------------------------------------------------------------------------------
		limitArray = new LTStorage[1];
		
		limitArray[0] = new LTStorage();
		
		File fileTwo = new File("Threshold.txt");
		FileReader frTwo = new FileReader(fileTwo);
		BufferedReader brTwo = new BufferedReader(frTwo);
		String strTwo;
		
		if((strTwo = br.readLine()) != null){
			
			String arr[] = strTwo.split(",");
			limitAndThreshold LandT = new limitAndThreshold(Integer.parseInt(arr[0]), Float.parseFloat(arr[1]));
			
			limitArray[0].addLT(LandT);
			// add in a return so limitArray not null
		}
		
		else if((strTwo = br.readLine()) == null) {
			float threshold;
			
			System.out.println("You have not set Daily limit and Threshold.\n");
			System.out.println("Please Enter Daily Limit: $ ");
			dLimit = sctwo.nextInt();
			System.out.println("Please Enter Threshold in percent:% ");
			thres = sctwo.nextFloat();
			
			threshold = thres / 100;
			
			limitAndThreshold LandTtwo = new limitAndThreshold(dLimit, threshold);
			
			limitArray[0].addLT(LandTtwo);
		}

		br.close();
		
	}
	
	public void menu() {
		System.out.println(limitArray[0]);
		System.out.println(storageArray[0]);
	}

	
	public static void main(String[] args) throws Exception {
		
		MoneyTracker tracker = new MoneyTracker();
		
		tracker.menu();
	}
	
	
}
