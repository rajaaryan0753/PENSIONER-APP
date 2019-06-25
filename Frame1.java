package javatestgui;

import java.awt.EventQueue;
import java.sql.*;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;

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
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Pensionerid=textpensioner.getText();
				if(Pensionerid.contains("123456")
				{
				textpensioner.setText(null);
				}
				else
				{
				JOptionPane.showMessageDialog(null, "invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
				textpensioner.setText(null);
				}
			}
		};
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
		lblpensioner.setBounds(171, 12, 189, 15);
		frame.getContentPane().add(lblpensioner);
		
		JLabel lblPensionerId = new JLabel("PENSIONER ID");
		lblPensionerId.setBounds(24, 78, 142, 34);
		frame.getContentPane().add(lblPensionerId);
		
		textpensioner = new JTextField();
		textpensioner.setBounds(217, 86, 124, 19);
		frame.getContentPane().add(textpensioner);
		textpensioner.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 177, 399, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 56, 399, 2);
		frame.getContentPane().add(separator_1);
	}
}
