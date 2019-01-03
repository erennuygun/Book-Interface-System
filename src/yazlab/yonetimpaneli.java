package yazlab;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class yonetimpaneli extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"userID","username","password","Location","Age"};
	Object[] satirlar = new Object[5];
	private JTextField userID;
	
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
	public yonetimpaneli() {
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
		
		
				
				
				
		
		
	
		
		JButton btnListele = new JButton("Kullan\u0131c\u0131lar\u0131 Listele");
		btnListele.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ResultSet myRs = baglanti.users();
				
				modelim.setRowCount(0);
				
				
				try {
					while(myRs.next()) {
						
						satirlar[0] = myRs.getString("userID");
						satirlar[1] = myRs.getString("username");
						satirlar[2] = myRs.getString("password");
						satirlar[3] = myRs.getString("location");
						satirlar[4] = myRs.getString("age");
						//satirlar[5] = myRs.getString("rate_count");
						
						modelim.addRow(satirlar);
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table.setModel(modelim);
			}
		});
		btnListele.setBounds(617, 57, 173, 41);
		contentPane.add(btnListele);
		
		JButton btnKullanclarListele = new JButton("Kitaplar\u0131 D\u00FCzenle\r\n");
		btnKullanclarListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
               setVisible(false);
               kitap_duzenle k1 = new kitap_duzenle();
               k1.setVisible(true);
				
			}
		});
		btnKullanclarListele.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKullanclarListele.setBounds(630, 122, 145, 32);
		contentPane.add(btnKullanclarListele);
		
		
		
		JTextPane txtpnYnetimPaneli = new JTextPane();
		txtpnYnetimPaneli.setBackground(SystemColor.menu);
		txtpnYnetimPaneli.setText("              Y\u00F6netim Paneli");
		txtpnYnetimPaneli.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnYnetimPaneli.setBounds(181, 11, 321, 32);
		contentPane.add(txtpnYnetimPaneli);
		
		JButton btnk = new JButton("\u00C7\u0131k\u0131\u015F\r\n");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				anamenu m2 = new anamenu();
				m2.setVisible(true);
			}
		});
		btnk.setBounds(699, 446, 91, 23);
		contentPane.add(btnk);
		
		userID = new JTextField();
		userID.setBounds(665, 340, 91, 20);
		contentPane.add(userID);
		userID.setColumns(10);
		
		JButton btnKullancySil = new JButton("Kullan\u0131c\u0131y\u0131 Sil");
		btnKullancySil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String id = userID.getText();
          	   
          	   String sql = "DELETE FROM `book-crossing`.`users` WHERE (`userID` = '"+id+"');";
          	   baglanti.kayit_ol(sql);
				
				
			}
		});
		btnKullancySil.setBounds(630, 391, 143, 23);
		contentPane.add(btnKullancySil);
			
		JLabel lblOy = new JLabel("UserID:");
		lblOy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOy.setBounds(606, 340, 59, 17);
		contentPane.add(lblOy);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				userID.setText(modelim.getValueAt(table.getSelectedRow(),0).toString());
			}
		});	
	
		
		//contentPane.add(table);
	}
}
