import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Month;
import java.util.Calendar;

import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrackerGUI {

	private JFrame frame;
	private JTextField textDescription;
	private JTextField textAmount;
	private JTextField textNewLimit;
	private JTextField textNewThreshold;
	private JTextField textYear;
	private JTextField textMonth;
	private JTextField textDay;
	private JTextField textDescriptionRemove;
	private JTextField textAmountRemove;
	private Storage storageArray[];
	private LTStorage limitArray[];

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrackerGUI window = new TrackerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public TrackerGUI() throws Exception {
		initialize();
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	//read from array
	public void readFromStorage() throws Exception {
		
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
		br.close();
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	//insert Transaction
	public void insertTransaction(String description, float amount) {
			
		Calendar calendar = Calendar.getInstance();
		int cyear = calendar.get(Calendar.YEAR);
		int cmonth = calendar.get(Calendar.MONTH);
		int cday = calendar.get(Calendar.DAY_OF_MONTH);
		
		Dates date = new Dates(cday, (cmonth + 1), cyear);
		
		ItemsDescription item = new ItemsDescription(date, description, amount);
		
		storageArray[0].addItem(item);
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	//save
	public void save() throws IOException {
		File file = new File("Records.txt");
		FileWriter writer = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write(storageArray[0].write());
		bw.close();
		
		File filetwo = new File("Threshold.txt");
		FileWriter writertwo = new FileWriter(filetwo);
		BufferedWriter bwtwo = new BufferedWriter(writertwo);
		bwtwo.write(limitArray[0].write());
		bwtwo.close();
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	//change limit
	public void changeLimitAndThreshold(float limit, float percentage) {
		
		float threshold;
		
		threshold = percentage / 100;
		
		limitAndThreshold LandT = new limitAndThreshold(limit, threshold);
		
		limitArray[0].addLT(LandT);
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	//remove transaction
	public void removeItem(ItemsDescription item) {

		//Dates date = new Dates(year, month, day);
		//ItemsDescription items = new ItemsDescription(date, description, amount);
		
		storageArray[0].removeItems(item);
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	

	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	//list Transaction by the Date **(try to add Items into arraylist)**
	public String listTransactionByDate(int day, int month, int year) {
		String str = "";
		int i = 0;
		//Dates date = new Dates(year, month, day);
			
		while(storageArray[0].checkitem(i) != null) {
			if((storageArray[0].checkitem(i).getDate().getYear() == year) && (storageArray[0].checkitem(i).getDate().getMonth() == month) && (storageArray[0].checkitem(i).getDate().getDay() == day)) {
				str += "\n" + storageArray[0].checkitem(i).toString();
			}
			i++;
		}
		
		return str;
			
	}
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		
	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */

	private void initialize() throws Exception{
		// read from storage for limit and threshold
		readFromStorage();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1214, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDescription = new JLabel("Description : ");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescription.setBounds(10, 53, 112, 27);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblAmount = new JLabel("Amount : ");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAmount.setBounds(10, 90, 112, 15);
		frame.getContentPane().add(lblAmount);
		
		textDescription = new JTextField();
		textDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textDescription.setBounds(112, 53, 96, 27);
		frame.getContentPane().add(textDescription);
		textDescription.setColumns(10);
		
		textAmount = new JTextField();
		textAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textAmount.setBounds(112, 90, 96, 24);
		frame.getContentPane().add(textAmount);
		textAmount.setColumns(10);
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		JButton btnInsertTransaction = new JButton("Insert Transaction");
		btnInsertTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//read from storage
				try {
					readFromStorage();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				//insert transaction
				String description = textDescription.getText();
				float amount = Float.parseFloat(textAmount.getText());
				insertTransaction(description, amount);
				
				//save after every insert
				try {
					save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textDescription.setText(null);
				textAmount.setText(null);
				
			}
			
		});
		btnInsertTransaction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInsertTransaction.setBounds(231, 72, 176, 21);
		frame.getContentPane().add(btnInsertTransaction);
		//--------------------------------------------------------------------------------------------------------------------------------------------------------
		
		JLabel lblDATE = new JLabel("Date :");
		lblDATE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDATE.setBounds(10, 176, 75, 13);
		frame.getContentPane().add(lblDATE);
		
		JComboBox comboBoxYear = new JComboBox();
		comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"Year..", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"}));
		comboBoxYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxYear.setBounds(71, 173, 75, 21);
		frame.getContentPane().add(comboBoxYear);
		
		JComboBox comboBoxMonth = new JComboBox();
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxMonth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxMonth.setBounds(156, 173, 60, 21);
		frame.getContentPane().add(comboBoxMonth);
		
		JComboBox comboBoxDay = new JComboBox();
		comboBoxDay.setModel(new DefaultComboBoxModel(new String[] {"Day...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxDay.setBounds(226, 173, 52, 21);
		frame.getContentPane().add(comboBoxDay);
		
		JLabel lblListbyDate = new JLabel("List By Date");
		lblListbyDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListbyDate.setBounds(121, 138, 103, 25);
		frame.getContentPane().add(lblListbyDate);
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
				
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Show transaction by date
		JButton btnShowByDate = new JButton("Show");
		btnShowByDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int year = Integer.parseInt((String) comboBoxYear.getSelectedItem());
				int month = Integer.parseInt((String) comboBoxMonth.getSelectedItem());
				int day = Integer.parseInt((String) comboBoxDay.getSelectedItem());
				
				String list  = listTransactionByDate(day, month, year);
				
				JOptionPane.showMessageDialog(null, list);
			}
		});
		btnShowByDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnShowByDate.setBounds(91, 225, 156, 21);
		frame.getContentPane().add(btnShowByDate);
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 126, 426, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblTransactions = new JLabel("Transactions");
		lblTransactions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTransactions.setBounds(121, 10, 126, 13);
		frame.getContentPane().add(lblTransactions);
		
		JLabel lblListAllTransactons = new JLabel("List All Transactions");
		lblListAllTransactons.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListAllTransactons.setBounds(554, 10, 156, 13);
		frame.getContentPane().add(lblListAllTransactons);
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		JButton btnListAllTransaction = new JButton("List\r\n");
		btnListAllTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//read from storage when clicked
				try {
					readFromStorage();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//message of the transactions will pop out
				JOptionPane.showMessageDialog(null, storageArray[0]);
			}
		});
		btnListAllTransaction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListAllTransaction.setBounds(585, 41, 85, 21);
		frame.getContentPane().add(btnListAllTransaction);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(490, 126, 312, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblRemoveTransaction = new JLabel("Remove Transaction");
		lblRemoveTransaction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRemoveTransaction.setBounds(554, 140, 156, 13);
		frame.getContentPane().add(lblRemoveTransaction);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 470, 755, 2);
		frame.getContentPane().add(separator_2);
		
		JLabel lblChangeLimitThreshold = new JLabel("Change Limit");
		lblChangeLimitThreshold.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChangeLimitThreshold.setBounds(224, 470, 135, 27);
		frame.getContentPane().add(lblChangeLimitThreshold);
		
		JLabel lblCurrentLimit = new JLabel("Current Limit :");
		lblCurrentLimit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentLimit.setBounds(10, 516, 112, 27);
		frame.getContentPane().add(lblCurrentLimit);
		
		JLabel lblCurrentThreshold = new JLabel("Current Threshold :");
		lblCurrentThreshold.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentThreshold.setBounds(10, 553, 147, 27);
		frame.getContentPane().add(lblCurrentThreshold);
		
		JLabel lblNewLimit = new JLabel("New Limit :");
		lblNewLimit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLimit.setBounds(321, 516, 86, 27);
		frame.getContentPane().add(lblNewLimit);
		
		JLabel lblNewThreshold = new JLabel("New Threshold :");
		lblNewThreshold.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewThreshold.setBounds(321, 553, 121, 27);
		frame.getContentPane().add(lblNewThreshold);
		
		textNewLimit = new JTextField();
		textNewLimit.setBounds(452, 518, 75, 27);
		frame.getContentPane().add(textNewLimit);
		textNewLimit.setColumns(10);
		
		textNewThreshold = new JTextField();
		textNewThreshold.setBounds(452, 555, 75, 27);
		frame.getContentPane().add(textNewThreshold);
		textNewThreshold.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("%");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(529, 560, 26, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("%");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(248, 558, 26, 22);
		frame.getContentPane().add(lblNewLabel_4);
		
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		String lmt = String.valueOf(limitArray[0].getLimit());
		JLabel lblCurrentLimitShown = new JLabel(lmt);
		lblCurrentLimitShown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentLimitShown.setBounds(172, 516, 75, 27);
		lblCurrentLimitShown.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		frame.getContentPane().add(lblCurrentLimitShown);
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		float percent;
		percent = 100 * (limitArray[0].getPercentage());
		String perc = String.valueOf(percent);
		
		JLabel lblCurrentThresholdShown = new JLabel(perc);
		lblCurrentThresholdShown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentThresholdShown.setBounds(172, 553, 75, 27);
		lblCurrentThresholdShown.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		frame.getContentPane().add(lblCurrentThresholdShown);
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		JButton btnLimitThresholdChange = new JButton("Change");
		btnLimitThresholdChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get limit and threshold and then change and save
				float limit = Float.parseFloat(textNewLimit.getText());
				float threshold = Float.parseFloat(textNewThreshold.getText());
				changeLimitAndThreshold(limit, threshold);
				// save
				try {
					save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				String lmt = String.valueOf(limit);
				String perc = String.valueOf(threshold);
				
				lblCurrentLimitShown.setText(lmt);
				lblCurrentThresholdShown.setText(perc);
				
				textNewLimit.setText(null);
				textNewThreshold.setText(null);
			}
		});
		btnLimitThresholdChange.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimitThresholdChange.setBounds(565, 532, 105, 27);
		frame.getContentPane().add(btnLimitThresholdChange);
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		JLabel lblYear = new JLabel("Year :");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblYear.setBounds(490, 178, 52, 16);
		frame.getContentPane().add(lblYear);
		
		textYear = new JTextField();
		textYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textYear.setBounds(541, 178, 52, 20);
		frame.getContentPane().add(textYear);
		textYear.setColumns(10);
		
		JLabel lblMonth = new JLabel("Month :");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMonth.setBounds(603, 178, 60, 20);
		frame.getContentPane().add(lblMonth);
		
		JLabel lblDay = new JLabel("Day :");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDay.setBounds(704, 178, 45, 20);
		frame.getContentPane().add(lblDay);
		
		textMonth = new JTextField();
		textMonth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textMonth.setBounds(663, 179, 36, 19);
		frame.getContentPane().add(textMonth);
		textMonth.setColumns(10);
		
		textDay = new JTextField();
		textDay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textDay.setBounds(751, 179, 36, 19);
		frame.getContentPane().add(textDay);
		textDay.setColumns(10);
		
		JLabel lblDescriptionRemove = new JLabel("Description :");
		lblDescriptionRemove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescriptionRemove.setBounds(490, 225, 96, 21);
		frame.getContentPane().add(lblDescriptionRemove);
		
		textDescriptionRemove = new JTextField();
		textDescriptionRemove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textDescriptionRemove.setBounds(603, 220, 146, 27);
		frame.getContentPane().add(textDescriptionRemove);
		textDescriptionRemove.setColumns(10);
		
		JLabel lblAmountRemove = new JLabel("Amount :");
		lblAmountRemove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAmountRemove.setBounds(490, 272, 96, 13);
		frame.getContentPane().add(lblAmountRemove);
		
		textAmountRemove = new JTextField();
		textAmountRemove.setBounds(603, 264, 146, 27);
		frame.getContentPane().add(textAmountRemove);
		textAmountRemove.setColumns(10);
		
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		JButton btnRemoveTransaction = new JButton("Remove");
		btnRemoveTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int year;
				int month;
				int day;
				String Description;
				float amount;
				
				// read from storage
				try {
					readFromStorage();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				//get from text field
				year = Integer.parseInt(textYear.getText());
				month = Integer.parseInt(textMonth.getText());
				day = Integer.parseInt(textDay.getText());
				
				Description = textDescriptionRemove.getText();
				
				amount = Float.parseFloat(textAmountRemove.getText());
				
				Dates date = new Dates(day, month, year);
				ItemsDescription item = new ItemsDescription (date, Description, amount);
				// remove transaction
				removeItem(item);
				
				//save after remove
				try {
					save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				textYear.setText(null);
				textMonth.setText(null);
				textDay.setText(null);
				textDescriptionRemove.setText(null);
				textAmountRemove.setText(null);
				
			}
		});
		btnRemoveTransaction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemoveTransaction.setBounds(548, 332, 176, 21);
		frame.getContentPane().add(btnRemoveTransaction);
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
	}
}
