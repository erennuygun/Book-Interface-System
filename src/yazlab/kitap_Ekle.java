package yazlab;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class kitap_Ekle extends JFrame {

	private JPanel contentPane;
	
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"ISBN","bookID","bookTitle","bookAuthor","yearOfPublication","publisher","urlS","urlM","urlL"};
	Object[] satirlar = new Object[9];
	
	Object[] kolonlar2 = {"userID","username","password","Location","Age"};
	Object[] satirlar2 = new Object[5];
	private JTextField txt3;
	private JTextField txt1;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt4;
	private JTextField txt7;
	private JTextField txt8;
	private JTextField txt9;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yonetimpaneli frame = new yonetimpaneli();
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
	public kitap_Ekle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 537);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 204));
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		modelim.setColumnIdentifiers(kolonlar);
		
		JButton btnNewButton = new JButton("Kitap Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql_sorgu,isbn,bookid,booktitle,bookauthor,yearofpublication,publisher,urls,urlm,urll;
				int a = 0;
				
				String sql;
				ResultSet myRs;
				sql = "SELECT bookID FROM book order by bookID DESC LIMIT 1;";
				myRs = baglanti.dogrula(sql);
				
				try {
					while(myRs.next()){
						
						   a = myRs.getInt("bookID");
						
						   
					    }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				a++;
				
				isbn=txt1.getText();
				//bookid=txt2.getText();
				booktitle=txt3.getText();
				bookauthor=txt5.getText();
				yearofpublication=txt6.getText();
				publisher=txt4.getText();
				urls=txt7.getText();
				urlm=txt8.getText();
				urll=txt9.getText();
				
				
				sql_sorgu="INSERT INTO `book-crossing`.`book`\r\n" + 
						"(`ISBN`,\r\n" + 
						"`bookID`,\r\n" + 
						"`bookTitle`,\r\n" + 
						"`bookAuthor`,\r\n" + 
						"`yearOfPublication`,\r\n" + 
						"`publisher`,\r\n" + 
						"`urlS`,\r\n" + 
						"`urlM`,\r\n" + 
						"`urlL`)\r\n" + 
						"VALUES\r\n(" + 
						"'"+isbn+"',"+"'"+a+"',"+"'"+booktitle+"',"+"'"+bookauthor+"',"+"'"+yearofpublication+"',"+"'"+publisher+"',"+"'"+urls+"',"+"'"+urlm+"',"+"'"+urll+"'"+
						");";
				baglanti.kayit_ol(sql_sorgu);
			
			}
		});
		btnNewButton.setBounds(410, 403, 91, 23);
		contentPane.add(btnNewButton);
		
		JTextPane txtpnYnetimPaneli = new JTextPane();
		txtpnYnetimPaneli.setBackground(SystemColor.menu);
		txtpnYnetimPaneli.setText("              Y\u00F6netim Paneli");
		txtpnYnetimPaneli.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnYnetimPaneli.setBounds(244, 11, 321, 32);
		contentPane.add(txtpnYnetimPaneli);
		
		JButton btnKitabGncelle = new JButton("Kitab\u0131 G\u00FCncelle\r\n");
		btnKitabGncelle.setBounds(282, 403, 101, 23);
		contentPane.add(btnKitabGncelle);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				kitap_duzenle k3 = new kitap_duzenle();
				k3.setVisible(true);
				
			}
		});
		btnGeri.setBounds(656, 464, 91, 23);
		contentPane.add(btnGeri);
			
		JLabel lblOy = new JLabel("urlL:");
		lblOy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOy.setBounds(549, 291, 59, 17);
		contentPane.add(lblOy);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIsbn.setBounds(126, 164, 59, 17);
		contentPane.add(lblIsbn);
		
		JLabel lblBooktitle = new JLabel("BookTitle:");
		lblBooktitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBooktitle.setBounds(334, 164, 93, 17);
		contentPane.add(lblBooktitle);
		
		JLabel lblBookauthor = new JLabel("bookAuthor:");
		lblBookauthor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookauthor.setBounds(183, 222, 84, 17);
		contentPane.add(lblBookauthor);
		
		JLabel lblYearofpublication = new JLabel("yearOfPublication:");
		lblYearofpublication.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYearofpublication.setBounds(410, 222, 138, 17);
		contentPane.add(lblYearofpublication);
		
		JLabel lblPublisher = new JLabel("Publisher:");
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPublisher.setBounds(549, 164, 86, 17);
		contentPane.add(lblPublisher);
		
		JLabel lblUrls = new JLabel("urlS:");
		lblUrls.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUrls.setBounds(126, 291, 59, 17);
		contentPane.add(lblUrls);
		
		JLabel lblUrlm = new JLabel("urlM:");
		lblUrlm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUrlm.setBounds(334, 291, 59, 17);
		contentPane.add(lblUrlm);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(428, 164, 86, 20);
		contentPane.add(txt3);
		
		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBounds(213, 164, 86, 20);
		contentPane.add(txt1);
		
		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(282, 222, 86, 20);
		contentPane.add(txt5);
		
		txt6 = new JTextField();
		txt6.setColumns(10);
		txt6.setBounds(549, 222, 86, 20);
		contentPane.add(txt6);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(624, 164, 86, 20);
		contentPane.add(txt4);
		
		txt7 = new JTextField();
		txt7.setColumns(10);
		txt7.setBounds(213, 291, 86, 20);
		contentPane.add(txt7);
		
		txt8 = new JTextField();
		txt8.setColumns(10);
		txt8.setBounds(428, 291, 86, 20);
		contentPane.add(txt8);
		
		txt9 = new JTextField();
		txt9.setColumns(10);
		txt9.setBounds(624, 291, 86, 20);
		contentPane.add(txt9);
	
	
		
		//contentPane.add(table);
	}
}
