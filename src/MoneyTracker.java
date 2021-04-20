import java.io.*;
import java.util.Calendar;
import java.util.Scanner;
import java.util.ArrayList;

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
		sc = new Scanner(System.in);
		Scanner scTwo = new Scanner(System.in);
		
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
		//--------------------------------------------------------------------------------------------------------------------
		//Read second file for the limit and threshold amount
		
		limitArray = new LTStorage[1];
		limitArray[0] = new LTStorage();
		
		File fileTwo = new File("Threshold.txt");
		FileReader frTwo = new FileReader(fileTwo);
		BufferedReader brTwo = new BufferedReader(frTwo);
		String strTwo;
		
		//if records exists add into limitArray for further use.
		if((strTwo = brTwo.readLine()) != null){
			
			String arr[] = strTwo.split(",");
			limitAndThreshold LandT = new limitAndThreshold(Float.parseFloat(arr[0]), Float.parseFloat(arr[1]));
			
			limitArray[0].addLT(LandT);
		}
		//if not existing records for limit and threshold prompt for 1 at the start of opening.
		else if((strTwo = brTwo.readLine()) == null) {
			float threshold;
			
			System.out.println("You have not set Daily limit and Threshold.\n");
			System.out.println("Please Enter Daily Limit: $ ");
			dLimit = scTwo.nextInt();
			System.out.println("Please Enter Threshold in percent:% ");
			thres = scTwo.nextFloat();
			
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
	
	//insert Transaction button, will automatically gets the current date.
	public void insertTransaction() {
		Scanner scTwo = new Scanner(System.in);
		
		String description;
		float amount;
		
		Calendar calendar = Calendar.getInstance();
		int cyear = calendar.get(Calendar.YEAR);
		int cmonth = calendar.get(Calendar.MONTH);
		int cday = calendar.get(Calendar.DAY_OF_MONTH);
		
		Dates date = new Dates(cyear, (cmonth + 1), cday);
		
		System.out.println("Enter description of item: ");
		description = sc.nextLine();
		System.out.println("Enter cost of item: ");
		amount = Float.parseFloat(sc.nextLine());
		
		ItemsDescription item = new ItemsDescription(date, description, amount);
		
		storageArray[0].addItem(item);
	}
	//list all Transactions
	public void listTransaction() {
		System.out.println(storageArray[0]);
	}
	//list Transaction by the Date (try to add Items into arraylist)
	public void listTransactionByDate() {
		
		int i = 0;
		int year;
		int month;
		int day;
		
		
		System.out.println("Enter year: ");
		year = sc.nextInt();
		System.out.println("Enter month: ");
		month = sc.nextInt();
		System.out.println("Enter day: ");
		day = sc.nextInt();
		
		Dates date = new Dates(year, month, day);
		
		while(storageArray[0].checkitem(i) != null) {
			if((storageArray[0].checkitem(i).getDate().getYear() == year) && (storageArray[0].checkitem(i).getDate().getMonth() == month) && (storageArray[0].checkitem(i).getDate().getDay() == day)) {
				System.out.println(storageArray[0].checkitem(i));
			}
			i++;
		}
		
		
	}
	
	public void removeTransaction() {
		
	}
	
	public void saveAndExit() {
		
	}

	
	public static void main(String[] args) throws Exception {
		
		MoneyTracker tracker = new MoneyTracker();
		
		tracker.insertTransaction();
		
		tracker.listTransaction();
		
		tracker.listTransactionByDate();
	}
	
	
}
