package yazlab;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class menu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	int i=1;
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"ISBN","bookID","bookTitle","bookAuthor","yearOfPublication","publisher","urlS","urlM","urlL","sumOfRating","countOfReading","bookRating"};
	Object[] satirlar = new Object[12];
	public int rate_count;
	private JTextField textField;
	private JTextField l1;
	private JTextField l2;
	private JTextField l3;
	private JTextField l4;
	public JTextField bookID;
	public String idno;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1444, 777);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 204));
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 760, 545);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		modelim.setColumnIdentifiers(kolonlar);
		
		table.setBounds(187, 178, 210, 108);
		scrollPane.setViewportView(table);
		
		
		JButton btnListele = new JButton("T\u00FCm Kitaplar\u0131 Listele");
		btnListele.setBounds(793, 65, 173, 32);
		btnListele.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						ResultSet myRs = baglanti.listele1();
				
				modelim.setRowCount(0);
				
				
				try {
					while(myRs.next()) {
						
						satirlar[0] = myRs.getString("ISBN");
						satirlar[1] = myRs.getString("bookID");
						satirlar[2] = myRs.getString("bookTitle");
						satirlar[3] = myRs.getString("bookAuthor");
						satirlar[4] = myRs.getString("yearOfPublication");
						satirlar[5] = myRs.getString("publisher");
						//satirlar[6] = myRs.getURL("urlS");
						String url1 = myRs.getString("urlS");
						satirlar[6] = myRs.getString("urlS");
						satirlar[7] = myRs.getString("urlM");
						satirlar[8] = myRs.getString("urlL");
						
						satirlar[9] = myRs.getString("sumOfRating");
						satirlar[10] = myRs.getString("countOfReading");
						satirlar[11] = myRs.getString("bookRating");
						
						
						modelim.addRow(satirlar);
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.setModel(modelim);
			}
		});
		contentPane.add(btnListele);
		
		
		
		JTextPane txtpnYnetimPaneli = new JTextPane();
		txtpnYnetimPaneli.setBounds(181, 11, 412, 32);
		txtpnYnetimPaneli.setBackground(SystemColor.menu);
		txtpnYnetimPaneli.setText("             Men\u00FCye Ho\u015Fgeldiniz.");
		txtpnYnetimPaneli.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(txtpnYnetimPaneli);
		
		JButton btnk = new JButton("\u00C7IK");
		btnk.setBounds(1105, 667, 87, 23);
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				anamenu am1 = new anamenu();
				am1.setVisible(true);
			}
		});
		contentPane.add(btnk);
		
		JLabel lblResim = new JLabel();
		lblResim.setBounds(780, 138, 361, 518);
		contentPane.add(lblResim);
		
		textField = new JTextField();
		textField.setBounds(995, 107, 322, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("BookTitle:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(1151, 181, 93, 17);
		contentPane.add(label);
		
		l1 = new JTextField();
		l1.setColumns(10);
		l1.setBounds(1234, 181, 184, 20);
		contentPane.add(l1);
		
		JLabel label_1 = new JLabel("Publisher:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(1151, 235, 86, 17);
		contentPane.add(label_1);
		
		l2 = new JTextField();
		l2.setColumns(10);
		l2.setBounds(1234, 235, 184, 20);
		contentPane.add(l2);
		
		JLabel label_2 = new JLabel("bookAuthor:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(1151, 299, 84, 17);
		contentPane.add(label_2);
		
		l3 = new JTextField();
		l3.setColumns(10);
		l3.setBounds(1245, 299, 173, 20);
		contentPane.add(l3);
		
		JLabel label_3 = new JLabel("yearOfPublication:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(1151, 366, 138, 17);
		contentPane.add(label_3);
		
		l4 = new JTextField();
		l4.setColumns(10);
		l4.setBounds(1284, 366, 134, 20);
		contentPane.add(l4);
		
		JButton btnPoplerKitaplarListele = new JButton("Pop\u00FCler Kitaplar\u0131 Listele\r\n");
		btnPoplerKitaplarListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
             
				
		ResultSet myRs = baglanti.listele2();
				
				modelim.setRowCount(0);
				
				
				try {
					while(myRs.next()) {
						
						satirlar[0] = myRs.getString("ISBN");
						satirlar[1] = myRs.getString("bookID");
						satirlar[2] = myRs.getString("bookTitle");
						satirlar[3] = myRs.getString("bookAuthor");
						satirlar[4] = myRs.getString("yearOfPublication");
						satirlar[5] = myRs.getString("publisher");
						//satirlar[6] = myRs.getURL("urlS");
						String url1 = myRs.getString("urlS");
						satirlar[6] = myRs.getString("urlS");
						satirlar[7] = myRs.getString("urlM");
						satirlar[8] = myRs.getString("urlL");
						satirlar[9] = myRs.getString("sumOfRating");
						satirlar[10] = myRs.getString("countOfReading");
						satirlar[11] = myRs.getString("bookRating");
						
						
						modelim.addRow(satirlar);
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.setModel(modelim);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			// ------------------------ Database'e yazdýrma kýsmý------------------------------	
				
				
				/*  int a=0,b=0;
                 float avg = 0;
				
				String sql,sql1,sql2,sql3;
				ResultSet myRs,myRs2,myRs3,myRs4;
				String isbn = null;
			   // myRs = baglanti.bagla();	
				sql = "SELECT bookID FROM book order by bookID DESC LIMIT 1;";
			    
				myRs = baglanti.dogrula(sql);
				try {
					while(myRs.next()){
						
						   b = myRs.getInt("bookID");
					    }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				for (i=1794;i<=b;i++) {
					
					myRs2 = baglanti.bagla();	
					sql1 = "SELECT ISBN FROM `book-crossing`.book where bookID='"+i+"';";
					
					myRs2 = baglanti.dogrula2(sql1);
					try {
						while(myRs2.next()){
							
							   isbn = myRs2.getString("ISBN");
							
						   }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					myRs3 = baglanti.bagla();	
					sql2 = "SELECT AVG(bookRating) as ort FROM `book-crossing`.bookrating where ISBN='"+isbn+"';";
					myRs3 = baglanti.dogrula3(sql2);
					try {
						while(myRs3.next()){
							
							   avg = myRs3.getFloat("ort");
							
						   }
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					sql3 = "UPDATE book SET avg = '"+avg+"' WHERE `bookID` = '"+i+"';";
					baglanti.kayit_ol(sql3);
					
					
				}
				*/
				// ------------------------ Database'e yazdýrma kýsmý------------------------------	
				
				
			}
		});
		btnPoplerKitaplarListele.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnPoplerKitaplarListele.setBounds(985, 65, 191, 32);
		contentPane.add(btnPoplerKitaplarListele);
		
		JButton btnEnokOkunan = new JButton("En \u00C7ok Okunan Kitaplar\u0131 Listele\r\n");
		btnEnokOkunan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                  ResultSet myRs = baglanti.listele3();
				
				modelim.setRowCount(0);
				
				
				try {
					while(myRs.next()) {
						
						satirlar[0] = myRs.getString("ISBN");
						satirlar[1] = myRs.getString("bookID");
						satirlar[2] = myRs.getString("bookTitle");
						satirlar[3] = myRs.getString("bookAuthor");
						satirlar[4] = myRs.getString("yearOfPublication");
						satirlar[5] = myRs.getString("publisher");
						//satirlar[6] = myRs.getURL("urlS");
						String url1 = myRs.getString("urlS");
						satirlar[6] = myRs.getString("urlS");
						satirlar[7] = myRs.getString("urlM");
						satirlar[8] = myRs.getString("urlL");
						satirlar[9] = myRs.getString("sumOfRating");
						satirlar[10] = myRs.getString("countOfReading");
						satirlar[11] = myRs.getString("bookRating");
						
						
						modelim.addRow(satirlar);
						
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.setModel(modelim);
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnEnokOkunan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnEnokOkunan.setBounds(1186, 65, 232, 32);
		contentPane.add(btnEnokOkunan);
		
		
		
		JLabel lblBookId = new JLabel("Book ID:");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookId.setBounds(1151, 420, 138, 17);
		contentPane.add(lblBookId);
		
		bookID = new JTextField();
		bookID.setColumns(10);
		bookID.setBounds(1284, 420, 134, 20);
		contentPane.add(bookID);
		textField.setVisible(false);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				textField.setText(modelim.getValueAt(table.getSelectedRow(),8).toString());
				l1.setText(modelim.getValueAt(table.getSelectedRow(),2).toString());
				l2.setText(modelim.getValueAt(table.getSelectedRow(),5).toString());
				l3.setText(modelim.getValueAt(table.getSelectedRow(),3).toString());
				l4.setText(modelim.getValueAt(table.getSelectedRow(),4).toString());
				bookID.setText(modelim.getValueAt(table.getSelectedRow(),1).toString());
				
				URL url;
				try {
				
				url = new URL(textField.getText());
				BufferedImage image = ImageIO.read(url);
				lblResim.setIcon(new ImageIcon(image));
				}
				catch (MalformedURLException e1) {
				e1.printStackTrace();
				}
				catch (IOException ex) {
				ex.printStackTrace();
				}
				
				
				
			}
		});
		JButton btnPdfOku = new JButton("OKU");
		btnPdfOku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			  idno = modelim.getValueAt(table.getSelectedRow(),1).toString();
			 
			  setVisible(false);
				new pdf(idno).setVisible(true);
				
			}
		});
		btnPdfOku.setBounds(1222, 495, 87, 23);
		contentPane.add(btnPdfOku);
	
		
		//contentPane.add(table);
	}
	
	
	
	
	
	
}
