package javatestgui;

import java.awt.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class Secondbox extends JFrame {

	static XSSFRow row;
	public JFrame frame;
	public final JLabel frame_title = new JLabel("Pensioner Details");
	public JTextField id_text;
	public JTextField name_text;
	public JTextField designation_text;
	public JTextField lastdept_text;
	public JTextField address_text;
	public JTextField phone_text;
	public JTextField retdate_text;
	public JLabel id_lbl;
	public JLabel name_lbl;
	public JLabel designation_lbl;
	public JLabel lastdept_lbl;
	public JLabel address_lbl;
	public JLabel phone_lbl;
	public JLabel retdate_lbl;
	public JButton btnEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Secondbox window = new Secondbox();
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
	public Secondbox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(50,50,975, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame_title.setBounds(10, 84, 864, 35);
		frame_title.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		frame_title.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(frame_title);
		
		JLabel mpt_logo = new JLabel("");
		mpt_logo.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/MPT.jpg")).getImage();
		mpt_logo.setIcon(new ImageIcon(img));
		mpt_logo.setBounds(10, 0, 864, 82);
		frame.getContentPane().add(mpt_logo);
		
		id_text = new JTextField();
		id_text.setBounds(141, 166, 131, 20);
		frame.getContentPane().add(id_text);
		id_text.setColumns(10);
		
		name_text = new JTextField();
		name_text.setBounds(141, 210, 131, 20);
		frame.getContentPane().add(name_text);
		name_text.setColumns(10);
		
		designation_text = new JTextField();
		designation_text.setColumns(10);
		designation_text.setBounds(141, 255, 131, 20);
		frame.getContentPane().add(designation_text);
		
		lastdept_text = new JTextField();
		lastdept_text.setColumns(10);
		lastdept_text.setBounds(141, 301, 131, 20);
		frame.getContentPane().add(lastdept_text);
		
		address_text = new JTextField();
		address_text.setColumns(10);
		address_text.setBounds(141, 345, 131, 20);
		frame.getContentPane().add(address_text);
		
		phone_text = new JTextField();
		phone_text.setColumns(10);
		phone_text.setBounds(141, 389, 131, 20);
		frame.getContentPane().add(phone_text);
		
		retdate_text = new JTextField();
		retdate_text.setColumns(10);
		retdate_text.setBounds(141, 440, 131, 20);
		frame.getContentPane().add(retdate_text);
		
		id_lbl = new JLabel("ID");
		id_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		id_lbl.setLabelFor(id_text);
		id_lbl.setBounds(10, 166, 111, 20);
		frame.getContentPane().add(id_lbl);
		
		name_lbl = new JLabel("NAME");
		name_lbl.setLabelFor(name_text);
		name_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		name_lbl.setBounds(10, 210, 111, 20);
		frame.getContentPane().add(name_lbl);
		
		designation_lbl = new JLabel("DESIGNATION");
		designation_lbl.setLabelFor(designation_text);
		designation_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		designation_lbl.setBounds(10, 255, 111, 20);
		frame.getContentPane().add(designation_lbl);
		
		lastdept_lbl = new JLabel("LAST DEPARTMENT");
		lastdept_lbl.setLabelFor(lastdept_text);
		lastdept_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lastdept_lbl.setBounds(10, 301, 111, 20);
		frame.getContentPane().add(lastdept_lbl);
		
		address_lbl = new JLabel("ADDRESS");
		address_lbl.setLabelFor(address_text);
		address_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		address_lbl.setBounds(10, 345, 111, 20);
		frame.getContentPane().add(address_lbl);
		
		phone_lbl = new JLabel("PHONE");
		phone_lbl.setLabelFor(phone_text);
		phone_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		phone_lbl.setBounds(10, 389, 111, 20);
		frame.getContentPane().add(phone_lbl);
		
		retdate_lbl = new JLabel("RETIREMENT DATE");
		retdate_lbl.setLabelFor(retdate_text);
		retdate_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		retdate_lbl.setBounds(10, 440, 111, 20);
		frame.getContentPane().add(retdate_lbl);
		
		JTextPane printarea_text = new JTextPane();
		printarea_text.setEditable(false);
		printarea_text.setBounds(393, 166, 481, 294);
		frame.getContentPane().add(printarea_text);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name_text.setText(null);
				designation_text.setText(null);
				lastdept_text.setText(null);
				address_text.setText(null);
				phone_text.setText(null);
				retdate_text.setText(null);
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClear.setBounds(10, 515, 111, 35);
		frame.getContentPane().add(btnClear);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(141, 515, 131, 35);
		frame.getContentPane().add(btnBack);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					printarea_text.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrint.setBounds(393, 515, 481, 35);
		frame.getContentPane().add(btnPrint);
		
		btnEdit = new JButton("Fetch");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Excel Code
				String Pensionerid=id_text.getText();
				int ID = Integer.parseInt(Pensionerid);
				int flag;
				
				
				try { 
				FileInputStream fis = new FileInputStream(new File("WriteSheet.xlsx"));	       	      
			      XSSFWorkbook workbook = new XSSFWorkbook(fis);
			      XSSFSheet spreadsheet = workbook.getSheetAt(0);
			      Iterator < Row >  rowIterator = spreadsheet.iterator();
			      
			      while (rowIterator.hasNext()) {
			         row = (XSSFRow) rowIterator.next();
			         Iterator < Cell >  cellIterator = row.cellIterator();
			         flag = 0;
			         while ( cellIterator.hasNext()) {			          
			        	Cell cell = cellIterator.next();
			           
			            switch (cell.getCellType()) {			      			           
			              case NUMERIC:  
				               if (cell.getColumnIndex() == 0 && (int)cell.getNumericCellValue() == ID ) {
				            	   flag = 1;
				               }
			            	   if ( flag == 1 ) {
			            		   double k = cell.getNumericCellValue();
			            		   int x = (int)k;
			            		   int z = cell.getColumnIndex();
			            		   switch (z) {
			            		   case 0:
			            		   		int Id = x;
			            		   		id_text.setText(Pensionerid);
			            		   		break;
			            		   	case 5:
			            		   		String Ph =Integer.toString(x);			            		   		
			            		   		phone_text.setText(Ph);
			            		   		break;
			            		   	default:
			            		   		break;
			            		   }			  
			            	   }
			            	   else {
			            		   break;
			            	   }
			              case STRING:
			            	  
			            	  if ( flag == 1 ) {
			            		  if ( cell.getCellType() == CellType.STRING) {
			            		  String Y = cell.getStringCellValue();

			            		  int z = cell.getColumnIndex();
			            		  //System.out.println(" " + z + " " + cell.getCellType());
			            		  switch (z) {
			            		   	case 1:
			            		   		String Name = Y;
			            		   		name_text.setText(Name);
			            		   		break;
			            		   	case 2:
			            		   		String Des = Y;
			            		   		designation_text.setText(Des);
			            		   		break;
			            		   	case 3:
			            		   		String Dept = Y;
			            		   		lastdept_text.setText(Dept);
			            		   		break;
			            		   	case 4:
			            		   		String Address = Y;
			            		   		address_text.setText(Address);
			            		   		break;
			            		   	case 6:
			            		   		String ReD = Y;
			            		   		retdate_text.setText(ReD);
			            		   		break;
			                	  }  
			            		  }
			            		  }
			         }
			      }
			      }
			      fis.close();
			      workbook.close();
				}
				catch (Exception e) {
					
				}
		}
		});
		btnEdit.setBounds(280, 165, 71, 21);
		frame.getContentPane().add(btnEdit);
	}
}