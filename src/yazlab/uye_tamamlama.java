package yazlab;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// ,"sumOfRating","countOfReading","bookRating"
public class uye_tamamlama extends JFrame {

	private JPanel contentPane;
	private JTable table;
	int i=1;
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"ISBN","bookID","bookTitle","bookAuthor","yearOfPublication","publisher","urlS","urlM","urlL"};
	Object[] satirlar = new Object[9];
	
	
	private JTextField text2;
	private JTextField rate;
	public int rate_count;
	private JTextField kalanOy;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uye_tamamlama frame = new uye_tamamlama();
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
	public uye_tamamlama() {
		
	}
	
	
	public uye_tamamlama(String adi,int a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 537);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 204));
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 62, 644, 383);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		modelim.setColumnIdentifiers(kolonlar);
		
		table.setBounds(187, 178, 210, 108);
		scrollPane.setViewportView(table);
		
		
		JButton btnListele = new JButton("Kitaplar\u0131 Listele");
		btnListele.setBounds(664, 64, 143, 32);
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
		contentPane.add(btnListele);
		
		
		
		JTextPane txtpnYnetimPaneli = new JTextPane();
		txtpnYnetimPaneli.setBounds(181, 11, 412, 32);
		txtpnYnetimPaneli.setBackground(SystemColor.menu);
		txtpnYnetimPaneli.setText("              En Az 10 Kitap Oylay\u0131n!");
		txtpnYnetimPaneli.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(txtpnYnetimPaneli);
		
		text2 = new JTextField();
		text2.setBounds(736, 201, 71, 23);
		contentPane.add(text2);
		text2.setColumns(10);
		
		JButton btnk = new JButton("\u00C7IK");
		
		btnk.setBounds(721, 464, 87, 23);
		contentPane.add(btnk);
		
		JLabel lblNewLabel = new JLabel("Kitap ID:");
		lblNewLabel.setBounds(664, 205, 46, 14);
		contentPane.add(lblNewLabel);
		
		rate = new JTextField();
		rate.setColumns(10);
		rate.setBounds(736, 235, 71, 23);
		contentPane.add(rate);
	    
		JButton devam = new JButton("Devam");
		
		devam.setBounds(721, 410, 87, 23);
		contentPane.add(devam);
	    
		devam.setVisible(false);
		
		JLabel lblOy = new JLabel("Oy:");
		lblOy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOy.setBounds(664, 230, 46, 32);
		
		JButton oyla = new JButton("OYLA!");
		oyla.setBounds(664, 344, 143, 23);
		oyla.setVisible(false);
		
		contentPane.add(lblOy);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				text2.setText(modelim.getValueAt(table.getSelectedRow(),1).toString());
				
				oyla.setVisible(true);
			}
		});	
	   
		kalanOy = new JTextField();
		kalanOy.setColumns(10);
		kalanOy.setBounds(746, 282, 61, 23);
		contentPane.add(kalanOy);
		JLabel lblKalanOyunuz = new JLabel("Kalan Oyunuz:");
		lblKalanOyunuz.setBounds(658, 286, 105, 14);
		contentPane.add(lblKalanOyunuz);
		
		
	   
 	   i = a+1;
		
		
		oyla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 /* int rate_count;
				  String adi=null,sifre = null;
				  anamenu a1 = new anamenu();
				  a1.rate(adi, sifre);
				  
			rate_count = a1.rate(adi, sifre);
				 
			System.out.println(rate_count);
                   */
				
				   String oy = rate.getText();
            	   String id = text2.getText();	
            	   
            	   
            	   
            	   
            	   String sql2 = "UPDATE `book-crossing`.`bookrating` SET `bookRating` = '"+oy+"' WHERE (`id` = '"+id+"');";
            	   baglanti.kayit_ol(sql2);
					
					if (i==10) {
						lblOy.setVisible(false);
						devam.setVisible(true);
					}
					oyla.setVisible(false);
					String counter = Integer.toString(10-i);
					kalanOy.setText(counter);
					i++;
					
					
			}
		});
		contentPane.add(oyla);
		
		devam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String sql3 = "UPDATE `book-crossing`.`users` SET `rate_count` = '"+i+"' WHERE (`username` = '"+adi+"');";
				baglanti.kayit_ol(sql3);		
	          	  	
				
				setVisible(false);
				menu m1 = new menu();
				m1.setVisible(true);
			}
		});
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					String sql4 = "UPDATE `book-crossing`.`users` SET `rate_count` = '"+i+"' WHERE (`username` = '"+adi+"');";
					baglanti.kayit_ol(sql4);
	          	   
				setVisible(false);
				anamenu am1 = new anamenu();
				am1.setVisible(true);
			}
		});
		
		
		
		
		
		//contentPane.add(table);
	}

}
