package yazlab;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class kayitol extends JFrame {

	private JPanel contentPane;
	private JTextField kullanici_adi;
	private JTextField parola;
	private JTextField adres;
	private JTextField yas;
	int i=278858;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kayitol frame = new kayitol();
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
	public kayitol() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(137, 43, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblYa = new JLabel("\u015Eifre:");
		lblYa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYa.setBounds(137, 87, 46, 14);
		contentPane.add(lblYa);
		
		kullanici_adi = new JTextField();
		kullanici_adi.setBounds(278, 37, 164, 26);
		contentPane.add(kullanici_adi);
		kullanici_adi.setColumns(10);
		
		parola = new JTextField();
		parola.setBounds(278, 81, 164, 26);
		contentPane.add(parola);
		parola.setColumns(10);
		
		JLabel lblAdres = new JLabel("Adres:");
		lblAdres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdres.setBounds(137, 128, 46, 26);
		contentPane.add(lblAdres);
		
		JLabel lblYa_1 = new JLabel("Ya\u015F:");
		lblYa_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYa_1.setBounds(137, 176, 80, 26);
		contentPane.add(lblYa_1);
		
		adres = new JTextField();
		adres.setBounds(278, 128, 164, 26);
		contentPane.add(adres);
		adres.setColumns(10);
		
		yas = new JTextField();
		yas.setBounds(278, 176, 164, 26);
		contentPane.add(yas);
		yas.setColumns(10);
		
		JButton btnKaytOl = new JButton("Kay\u0131t Ol");
		btnKaytOl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKaytOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kullanici_adii,parolan,adresin,yasin,sql_sorgu;
				int a = 0;
				
				String sql;
				ResultSet myRs;
				sql = "SELECT userID FROM users order by userID DESC LIMIT 1;";
				myRs = baglanti.dogrula(sql);
				
				try {
					while(myRs.next()){
						
						   a = myRs.getInt("userID");
						
						   
					    }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				a++;
				
				kullanici_adii=kullanici_adi.getText();
				parolan=parola.getText();
				adresin=adres.getText();
				yasin=yas.getText();
				
				sql_sorgu="INSERT INTO `book-crossing`.`users`\r\n" + 
						"(`userID`,\r\n" + 
						"`username`,\r\n" + 
						"`password`,\r\n" + 
						"`location`,\r\n" + 
						"`age`)\r\n" + 
						"VALUES\r\n(" + 
						"'"+a+"',"+"'"+kullanici_adii+"',"+"'"+parolan+"',"+"'"+adresin+"',"+"'"+yasin+"'"+
						");";
				baglanti.kayit_ol(sql_sorgu);
			
				 JOptionPane.showMessageDialog(null, "Kayýt Ýþlemi Baþarýlý.Giriþ Yapabilirsiniz.");
				
			}
		});
		btnKaytOl.setBounds(210, 305, 115, 35);
		contentPane.add(btnKaytOl);
		
		JButton btnk = new JButton("\u00C7\u0131k");
		btnk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anamenu a = new anamenu();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnk.setBounds(401, 305, 129, 35);
		contentPane.add(btnk);
	}

}
