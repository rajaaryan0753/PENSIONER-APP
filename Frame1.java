package javatestgui;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class Frame1 {

	private JFrame frame;
	private JTextField textpensioner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
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
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnsubmit = new JButton("Submit");
		/* CONNECTION CODE
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//public class fetchdata { (ERROR : Not required to create a separate class I think)
	
				public static String connectionString = "jdbc:sap://<connection string>";
				public static String user = "<user name>";
				public static String password = "<password>";
		
				
				
				if (Connection connection = null) {
				try {
				connection = DriverManager.getConnection(connectionString, user, password);
				} catch (SQLException e) {
				System.err.println("Connection Failed. User/Passwd Error? Message: " + e.getMessage());
				return;
					}
				}
				if (connection != null) {
				try {


					System.out.println("Connection to HANA successful!");
					Statement stmt = connection.createStatement();
					String sqlfetch = "select idno, name, des, lastdept, address, phoneno, retdate from dummy";
					ResultSet rs = stmt.executeQuery(sqlfetch);
					String id = rs.getString("idno");
					String name = rs.getString("name");
					String designation = rs.getString("des");
					String lastdept = rs.getString("lastdept");
					String address = rs.getString("address");
					String phoneno = rs.getString("phoneno");
					String retdate = rs.getString("retdate");
					rs.close();
					stmt.close();
					connection.close();
				} catch (SQLException e) {
					System.err.println("Query failed!");

					}
				}
		}
});*/



		btnsubmit.setBounds(309, 207, 114, 25);
		frame.getContentPane().add(btnsubmit);
		
		JButton btnreset = new JButton("Reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textpensioner.setText(null);
			}
		});
		btnreset.setBounds(12, 207, 114, 25);
		frame.getContentPane().add(btnreset);
		
		JLabel lblpensioner = new JLabel("PENSIONER LOGIN PAGE");
		lblpensioner.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblpensioner.setBounds(126, 76, 189, 15);
		frame.getContentPane().add(lblpensioner);
		
		JLabel lblPensionerId = new JLabel("Pensioner ID: ");
		lblPensionerId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPensionerId.setBounds(87, 131, 102, 25);
		frame.getContentPane().add(lblPensionerId);
		
		textpensioner = new JTextField();
		textpensioner.setBounds(191, 133, 141, 22);
		frame.getContentPane().add(textpensioner);
		textpensioner.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 177, 399, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 104, 399, 2);
		frame.getContentPane().add(separator_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 63);
		frame.getContentPane().add(panel);
		ImageIcon image = new ImageIcon("MPT.jpg");
		JLabel label = new JLabel(image);
		panel.add(label);
		
	
	}
}
