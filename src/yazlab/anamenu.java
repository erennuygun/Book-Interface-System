package yazlab;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.*;
import java.awt.Color;
public class anamenu extends JFrame {

	private JPanel contentPane;
	private JTextField txtKitapSistemimizeHogeldiniz;
	private JTextField textField;
	private JTextField textField_1;
    
    public int a;
    public String adi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anamenu frame = new anamenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		baglanti b1 = new baglanti();
		b1.bagla();
		
	}

	/**
	 * Create the frame.
	 */
	public anamenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtKitapSistemimizeHogeldiniz = new JTextField();
		txtKitapSistemimizeHogeldiniz.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtKitapSistemimizeHogeldiniz.setText("Kitap Sistemimize Ho\u015Fgeldiniz.");
		txtKitapSistemimizeHogeldiniz.setBackground(new Color(253, 245, 230));
		txtKitapSistemimizeHogeldiniz.setBounds(220, 11, 305, 43);
		contentPane.add(txtKitapSistemimizeHogeldiniz);
		txtKitapSistemimizeHogeldiniz.setColumns(10);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 204));
		textField.setBounds(280, 153, 211, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 204));
		textField_1.setBounds(280, 216, 211, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Giri\u015F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				String sifre;
			    
				
				adi=textField.getText();
				sifre=textField_1.getText();
				
				
				ResultSet myRs = baglanti.bagla();	
				String sql= "SELECT count(userID) as giris FROM users where username='"+adi+"' AND password='"+sifre+"';";
				
			    myRs = baglanti.dogrula(sql);
			    
			try {
				while(myRs.next()){
					
					
					if( adi.equals("admin") && sifre.equals("password")) {
						
						
						
						
						
						setVisible(false);
						yonetimpaneli y1 = new yonetimpaneli();
						y1.setVisible(true);
				     }
					
					
					
					else if(myRs.getInt("giris")==1) {
						 ResultSet ms = baglanti.bagla();
						 String sql2= "SELECT rate_count as dogrulama FROM users where username='"+adi+"' AND password='"+sifre+"';";
						 ms = baglanti.dogrula(sql2);
						    
						 while(ms.next()){
							
							 
							 if(ms.getInt("dogrulama")>=10) {
								
								   menu m1 = new menu();
								   m1.setVisible(true);
								   setVisible(false);
							 }
							 else if (ms.getInt("dogrulama")<10){
								 
								 int a = ms.getInt("dogrulama");
								 
								 uye_tamamlama u1 = new uye_tamamlama(adi,a);
								  
									u1.setVisible(true);
									setVisible(false);
							 }
							 
						 }
						   
						 
				    	}
					
					 else {
						
						 JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Ediniz.");
					 }
				    }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
				
				
				
			}

			
		});
		btnNewButton.setBounds(279, 278, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnKaytOl = new JButton("Kay\u0131t Ol");
		btnKaytOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				kayitol nw = new kayitol();
				nw.setVisible(true);
				setVisible(false);
			}
		});
		btnKaytOl.setBounds(402, 278, 89, 23);
		contentPane.add(btnKaytOl);
		
		JLabel lblUsername = new JLabel("Kullan\u0131c\u0131 Ad\u0131:\r\n");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(161, 160, 80, 14);
		contentPane.add(lblUsername);
		
		JLabel lblifre = new JLabel("Parola:");
		lblifre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblifre.setBounds(161, 221, 80, 14);
		contentPane.add(lblifre);
		
		JButton btnk = new JButton("\u00C7\u0131k\u0131\u015F");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnk.setBounds(558, 381, 89, 23);
		contentPane.add(btnk);
		
		
		
		
		
		
	}
	
	
	
	
	
}
