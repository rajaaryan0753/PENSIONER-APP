package JavaDB_001;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

@SuppressWarnings("unused")
public class Secondbox extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JLabel bloodgroup_label;
	private JTextField bloodgroup_text;
	private JLabel printarea_logo;
	private JLabel printarea_photo;
	private JLabel printarea_sign;
	private JTextArea sign_label;
	private JTextArea txtAuthorisedSignature;
	private JTextArea txtId;
	private JTextArea txtName;
	private JTextArea txtDesignation;
	private JTextArea txtLastDept;
	private JTextArea txtRetdate;
	private JTextArea textFieldAddress;
	private JTextArea txtrBloodGroup;
	private JTextArea txtrPhone;

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
		frame_title.setBounds(10, 93, 939, 35);
		frame_title.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		frame_title.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(frame_title);
		
		JLabel mpt_logo = new JLabel("");
		mpt_logo.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/Title.jpg")).getImage();
		mpt_logo.setIcon(new ImageIcon(img));
		mpt_logo.setBounds(10, 0, 939, 82);
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
		
		bloodgroup_text = new JTextField();
		bloodgroup_text.setBounds(141, 348, 131, 20);
		frame.getContentPane().add(bloodgroup_text);
		bloodgroup_text.setColumns(10);
		
		address_text = new JTextField();
		address_text.setColumns(10);
		address_text.setBounds(141, 396, 131, 21);
		frame.getContentPane().add(address_text);
		
		phone_text = new JTextField();
		phone_text.setColumns(10);
		phone_text.setBounds(141, 442, 131, 20);
		frame.getContentPane().add(phone_text);
		
		retdate_text = new JTextField();
		retdate_text.setColumns(10);
		retdate_text.setBounds(141, 485, 131, 20);
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
		
		bloodgroup_label = new JLabel("BLOOD GROUP");
		bloodgroup_label.setHorizontalAlignment(SwingConstants.CENTER);
		bloodgroup_label.setBounds(10, 348, 111, 20);
		frame.getContentPane().add(bloodgroup_label);
		
		address_lbl = new JLabel("ADDRESS");
		address_lbl.setLabelFor(address_text);
		address_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		address_lbl.setBounds(10, 396, 111, 20);
		frame.getContentPane().add(address_lbl);
		
		phone_lbl = new JLabel("PHONE");
		phone_lbl.setLabelFor(phone_text);
		phone_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		phone_lbl.setBounds(10, 442, 111, 20);
		frame.getContentPane().add(phone_lbl);
		
		retdate_lbl = new JLabel("RETIREMENT DATE");
		retdate_lbl.setLabelFor(retdate_text);
		retdate_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		retdate_lbl.setBounds(10, 485, 111, 20);
		frame.getContentPane().add(retdate_lbl);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id_text.setText(null);
				bloodgroup_text.setText(null);
				name_text.setText(null);
				designation_text.setText(null);
				lastdept_text.setText(null);
				address_text.setText(null);
				phone_text.setText(null);
				retdate_text.setText(null);
				txtId.setText(null);
				txtName.setText(null);
				txtDesignation.setText(null);
				txtLastDept.setText(null);
				txtRetdate.setText(null);
				textFieldAddress.setText(null);
				txtrBloodGroup.setText(null);
				txtrPhone.setText(null);
				
			}
		});
		
		JPanel printarea_panel = new JPanel();
		printarea_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		printarea_panel.setBackground(Color.WHITE);
		printarea_panel.setBounds(537, 262, 265, 190);
		frame.getContentPane().add(printarea_panel);
		
		printarea_logo = new JLabel("");
		printarea_logo.setBounds(216, 9, 39, 30);
		printarea_logo.setOpaque(true);
		Image img2 = new ImageIcon(this.getClass().getResource("/ID_logo.jpg")).getImage();
		printarea_panel.setLayout(null);
		printarea_logo.setIcon(new ImageIcon(img2));
		printarea_logo.setBackground(new Color(255, 255, 255));
		printarea_logo.setHorizontalAlignment(SwingConstants.CENTER);
		printarea_panel.add(printarea_logo);
		
		printarea_photo = new JLabel("");
		printarea_photo.setBounds(189, 55, 68, 77);
		printarea_photo.setHorizontalAlignment(SwingConstants.CENTER);
		printarea_photo.setOpaque(true);
		printarea_photo.setBackground(new Color(255, 255, 255));
		printarea_panel.add(printarea_photo);
		
		printarea_sign = new JLabel("");
		printarea_sign.setBounds(189, 138, 68, 22);
		printarea_panel.add(printarea_sign);
		printarea_sign.setVerticalAlignment(SwingConstants.TOP);
		printarea_sign.setOpaque(true);
		printarea_sign.setHorizontalAlignment(SwingConstants.CENTER);
		printarea_sign.setBackground(new Color(255, 255, 255));
		
		sign_label = new JTextArea("Holder's Signature");
		sign_label.setBounds(189, 170, 68, 15);
		sign_label.setLineWrap(true);
		sign_label.setWrapStyleWord(true);
		sign_label.setBorder(null);
		sign_label.setFont(new Font("Tahoma", Font.BOLD, 6));
		printarea_panel.add(sign_label);
		sign_label.setOpaque(true);
		sign_label.setBackground(new Color(255, 255, 255));
		
		txtAuthorisedSignature = new JTextArea();
		txtAuthorisedSignature.setBounds(12, 170, 96, 15);
		txtAuthorisedSignature.setWrapStyleWord(true);
		txtAuthorisedSignature.setLineWrap(true);
		txtAuthorisedSignature.setBorder(null);
		printarea_panel.add(txtAuthorisedSignature);
		txtAuthorisedSignature.setFont(new Font("Tahoma", Font.BOLD, 6));
		txtAuthorisedSignature.setText("Issuing Authority");
		txtAuthorisedSignature.setColumns(10);
		
		txtId = new JTextArea();
		txtId.setBounds(12, 43, 76, 15);
		txtId.setWrapStyleWord(true);
		txtId.setLineWrap(true);
		txtId.setBorder(null);
		txtId.setFont(new Font("Tahoma", Font.BOLD, 7));
		printarea_panel.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextArea();
		txtName.setBounds(12, 60, 154, 15);
		txtName.setWrapStyleWord(true);
		txtName.setLineWrap(true);
		txtName.setColumns(10);
		txtName.setBorder(null);
		txtName.setFont(new Font("Tahoma", Font.BOLD, 7));
		printarea_panel.add(txtName);
		
		txtDesignation = new JTextArea();
		txtDesignation.setBounds(12, 80, 154, 15);
		txtDesignation.setLineWrap(true);
		txtDesignation.setWrapStyleWord(true);
		txtDesignation.setBorder(null);
		txtDesignation.setFont(new Font("Tahoma", Font.BOLD, 7));
		txtDesignation.setColumns(10);
		printarea_panel.add(txtDesignation);
		
		txtLastDept = new JTextArea();
		txtLastDept.setBounds(12, 99, 154, 15);
		txtLastDept.setWrapStyleWord(true);
		txtLastDept.setLineWrap(true);
		txtLastDept.setBorder(null);
		txtLastDept.setFont(new Font("Tahoma", Font.BOLD, 7));
		txtLastDept.setColumns(10);
		printarea_panel.add(txtLastDept);
		
		JLabel lblTitle = new JLabel("PENSIONERS IDENTITY");
		lblTitle.setBounds(10, 26, 196, 15);
		lblTitle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblTitle.setForeground(new Color(255, 140, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		printarea_panel.add(lblTitle);
		
		txtRetdate = new JTextArea();
		txtRetdate.setBounds(90, 43, 89, 15);
		txtRetdate.setWrapStyleWord(true);
		txtRetdate.setLineWrap(true);
		txtRetdate.setBorder(null);
		txtRetdate.setFont(new Font("Tahoma", Font.BOLD, 7));
		txtRetdate.setColumns(10);
		printarea_panel.add(txtRetdate);
		
		textFieldAddress = new JTextArea();
		textFieldAddress.setBounds(12, 118, 154, 26);
		textFieldAddress.setWrapStyleWord(true);
		textFieldAddress.setLineWrap(true);
		textFieldAddress.setFont(new Font("Tahoma", Font.BOLD, 7));
		textFieldAddress.setColumns(10);
		printarea_panel.add(textFieldAddress);
		
		txtrBloodGroup = new JTextArea();
		txtrBloodGroup.setBounds(12, 148, 76, 15);
		txtrBloodGroup.setLineWrap(true);
		txtrBloodGroup.setWrapStyleWord(true);
		txtrBloodGroup.setBorder(null);
		txtrBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 7));
		txtrBloodGroup.setColumns(10);
		printarea_panel.add(txtrBloodGroup);
		
		txtrPhone = new JTextArea();
		txtrPhone.setBounds(92, 148, 93, 15);
		txtrPhone.setWrapStyleWord(true);
		txtrPhone.setLineWrap(true);
		txtrPhone.setBorder(null);
		txtrPhone.setFont(new Font("Tahoma", Font.BOLD, 7));
		txtrPhone.setColumns(10);
		printarea_panel.add(txtrPhone);
		
		JLabel lblNewLabel = new JLabel("MORMUGAO PORT TRUST");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 9, 194, 15);
		lblNewLabel.setForeground(new Color(0, 102, 255));
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		printarea_panel.add(lblNewLabel);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClear.setBounds(10, 565, 111, 35);
		frame.getContentPane().add(btnClear);
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Confirm button action
				txtId.setText(null);
				txtName.setText(null);
				txtDesignation.setText(null);
				txtLastDept.setText(null);
				txtRetdate.setText(null);
				textFieldAddress.setText(null);
				txtrBloodGroup.setText(null);
				txtrPhone.setText(null);
				txtId.append(" ID:  "+id_text.getText());
				txtName.append("Name: "+name_text.getText());
				txtDesignation.append("Designation: "+ designation_text.getText());
				txtLastDept.append("Last Dept: "+ lastdept_text.getText());
				txtRetdate.append("Ret.Date:  "+ retdate_text.getText());
				textFieldAddress.append("Address: "+ address_text.getText());
				txtrBloodGroup.append("Blood Group: "+ bloodgroup_text.getText());
				txtrPhone.append("Phone: "+ phone_text.getText());
				
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConfirm.setBounds(141, 565, 131, 35);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
				//Print command code
				Toolkit tkp = printarea_panel.getToolkit();
				PrintJob pjp = tkp.getPrintJob(frame, null, null);
				 Graphics g = pjp.getGraphics();
				 printarea_panel.printAll(g);
				 g.dispose();
				 pjp.end();
				
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPrint.setBounds(393, 565, 535, 35);
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
			            		   	case 7:
			            		   		String BG = Y;
			            		   		bloodgroup_text.setText(BG);
			            		   		break;
			                	  }  
			            		  }
			            		  }
						case BLANK:
							break;
						case BOOLEAN:
							break;
						case ERROR:
							break;
						case FORMULA:
							break;
						case _NONE:
							break;
						default:
							break;
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
		
		JButton btnUploadPhoto = new JButton("UPLOAD PHOTO");
		btnUploadPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//code to upload photo
				JFileChooser file = new JFileChooser();
		          file.setCurrentDirectory(new File(System.getProperty("user.home")));
		          //filter the files
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);
		           //if the user click on save in Jfilechooser
		          if(result == JFileChooser.APPROVE_OPTION){
		              File selectedFile = file.getSelectedFile();
		              String path = selectedFile.getAbsolutePath();
		              printarea_photo.setIcon(ResizeImage(path));
		          }
		           //if the user click on save in Jfilechooser


		          else if(result == JFileChooser.CANCEL_OPTION){
		              System.out.println("No File Select");
		          }
				
			}

			public Icon ResizeImage(String ImagePath) {
				// method to resize image according to Jlabel
				ImageIcon MyImage = new ImageIcon(ImagePath);
		        Image img = MyImage.getImage();
		        Image newImg = img.getScaledInstance(printarea_photo.getWidth(), printarea_photo.getHeight(), Image.SCALE_SMOOTH);
		        ImageIcon image = new ImageIcon(newImg);
		        return image;
			}
		});
		btnUploadPhoto.setBounds(393, 516, 161, 35);
		frame.getContentPane().add(btnUploadPhoto);
		
		JButton btnUploadSign = new JButton("UPLOAD SIGNATURE");
		btnUploadSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code to upload signature
				sign_label.setVisible(true);
				JFileChooser file = new JFileChooser();
		          file.setCurrentDirectory(new File(System.getProperty("user.home")));
		          //filter the files
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);
		           //if the user click on save in Jfilechooser
		          if(result == JFileChooser.APPROVE_OPTION){
		              File selectedFile = file.getSelectedFile();
		              String path = selectedFile.getAbsolutePath();
		              printarea_sign.setIcon(Resize(path));
		          }
		           //if the user click on save in Jfilechooser


		          else if(result == JFileChooser.CANCEL_OPTION){
		              System.out.println("No File Select");
		          }
			}

			public Icon Resize(String path) {
				// method to resize signature to Jlabel
				ImageIcon MyImage = new ImageIcon(path);
		        Image img = MyImage.getImage();
		        Image newImg = img.getScaledInstance(printarea_sign.getWidth(), printarea_sign.getHeight(), Image.SCALE_SMOOTH);
		        ImageIcon image = new ImageIcon(newImg);
		        return image;
			}
		});
		btnUploadSign.setBounds(767, 516, 161, 35);
		frame.getContentPane().add(btnUploadSign);
	}
}
//END