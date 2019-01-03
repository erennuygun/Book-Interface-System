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

public class kitap_duzenle extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"ISBN","bookID","bookTitle","bookAuthor","yearOfPublication","publisher","urlS","urlM","urlL"};
	Object[] satirlar = new Object[9];
	
	Object[] kolonlar2 = {"userID","username","password","Location","Age"};
	Object[] satirlar2 = new Object[5];
	private JTextField bookID;
	
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
	public kitap_duzenle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 537);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 204));
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 57, 570, 383);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		
		table.setBounds(187, 178, 210, 108);
		scrollPane.setViewportView(table);
		
		
				
				
				
		
		
	
		
		JButton btnListele = new JButton("Kitaplar\u0131 Listele");
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
						satirlar[6] = myRs.getString("urlS");
						satirlar[7] = myRs.getString("urlM");
						satirlar[8] = myRs.getString("urlL");
						/*satirlar[9] = myRs.getString("sumOfRating");
						satirlar[10] = myRs.getString("countOfReading");
						satirlar[11] = myRs.getString("bookRating");*/
						
						modelim.addRow(satirlar);
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.setModel(modelim);
			}
		});
		btnListele.setBounds(630, 62, 143, 32);
		contentPane.add(btnListele);
		
		JButton btnNewButton = new JButton("Kitap Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				kitap_Ekle k2 = new kitap_Ekle();
				k2.setVisible(true);
			}
		});
		btnNewButton.setBounds(716, 347, 91, 23);
		contentPane.add(btnNewButton);
		
		JTextPane txtpnYnetimPaneli = new JTextPane();
		txtpnYnetimPaneli.setBackground(SystemColor.menu);
		txtpnYnetimPaneli.setText("              Y\u00F6netim Paneli");
		txtpnYnetimPaneli.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnYnetimPaneli.setBounds(181, 11, 321, 32);
		contentPane.add(txtpnYnetimPaneli);
		
		JButton btnKitabGncelle = new JButton("Kitab\u0131 G\u00FCncelle\r\n");
		btnKitabGncelle.setBounds(603, 347, 101, 23);
		contentPane.add(btnKitabGncelle);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				yonetimpaneli y1 = new yonetimpaneli();
				y1.setVisible(true);
				
			}
		});
		btnGeri.setBounds(716, 391, 91, 23);
		contentPane.add(btnGeri);
			
		JButton btnKullancySil = new JButton("Kitap Sil");
		btnKullancySil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String id = bookID.getText();
          	   
          	   String sql = "DELETE FROM `book-crossing`.`book` WHERE (`bookID` = '"+id+"');";
          	   baglanti.kayit_ol(sql);
				
				
			}
		});
		btnKullancySil.setBounds(603, 391, 101, 23);
		contentPane.add(btnKullancySil);
			
		JLabel lblOy = new JLabel("BookID:");
		lblOy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOy.setBounds(603, 295, 59, 17);
		contentPane.add(lblOy);
		
		bookID = new JTextField();
		bookID.setBounds(687, 295, 86, 20);
		contentPane.add(bookID);
		bookID.setColumns(10);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				bookID.setText(modelim.getValueAt(table.getSelectedRow(),1).toString());
			}
		});	
	
	
		
		//contentPane.add(table);
	}
}
