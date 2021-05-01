import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;

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
	 */
	public TrackerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		JButton btnInsertTransaction = new JButton("Insert Transaction");
		btnInsertTransaction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInsertTransaction.setBounds(231, 72, 176, 21);
		frame.getContentPane().add(btnInsertTransaction);
		
		JLabel lblDATE = new JLabel("Date :");
		lblDATE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDATE.setBounds(10, 176, 75, 13);
		frame.getContentPane().add(lblDATE);
		
		JComboBox comboBoxYear = new JComboBox();
		comboBoxYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxYear.setBounds(71, 173, 75, 21);
		frame.getContentPane().add(comboBoxYear);
		
		JComboBox comboBoxMonth = new JComboBox();
		comboBoxMonth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxMonth.setBounds(156, 173, 36, 21);
		frame.getContentPane().add(comboBoxMonth);
		
		JComboBox comboBoxDay = new JComboBox();
		comboBoxDay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxDay.setBounds(211, 173, 36, 21);
		frame.getContentPane().add(comboBoxDay);
		
		JLabel lblListbyDate = new JLabel("List By Date");
		lblListbyDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListbyDate.setBounds(121, 138, 103, 25);
		frame.getContentPane().add(lblListbyDate);
		
		JButton btnShowByDate = new JButton("Show");
		btnShowByDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnShowByDate.setBounds(91, 225, 156, 21);
		frame.getContentPane().add(btnShowByDate);
		
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
		
		JButton btnListAllTransaction = new JButton("List\r\n");
		btnListAllTransaction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListAllTransaction.setBounds(585, 41, 85, 21);
		frame.getContentPane().add(btnListAllTransaction);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(355, 272, 17, 148);
		frame.getContentPane().add(scrollBar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(490, 126, 312, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblRemoveTransaction = new JLabel("Remove Transaction");
		lblRemoveTransaction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRemoveTransaction.setBounds(554, 140, 156, 13);
		frame.getContentPane().add(lblRemoveTransaction);
		
		JButton btnRemoveTransaction = new JButton("Remove");
		btnRemoveTransaction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemoveTransaction.setBounds(548, 332, 176, 21);
		frame.getContentPane().add(btnRemoveTransaction);
		
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
		
		JLabel lblCurrentLimitShown = new JLabel("");
		lblCurrentLimitShown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentLimitShown.setBounds(172, 516, 75, 27);
		lblCurrentLimitShown.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		frame.getContentPane().add(lblCurrentLimitShown);
		
		JLabel lblCurrentThresholdShown = new JLabel("");
		lblCurrentThresholdShown.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurrentThresholdShown.setBounds(172, 553, 75, 27);
		lblCurrentThresholdShown.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		frame.getContentPane().add(lblCurrentThresholdShown);
		
		JButton btnLimitThresholdChange = new JButton("Change");
		btnLimitThresholdChange.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimitThresholdChange.setBounds(565, 532, 105, 27);
		frame.getContentPane().add(btnLimitThresholdChange);
		
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
		
		JLabel lblListTransactionDate = new JLabel("");
		lblListTransactionDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListTransactionDate.setBounds(10, 272, 362, 148);
		lblListTransactionDate.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(lblListTransactionDate);
		
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
	}
}
