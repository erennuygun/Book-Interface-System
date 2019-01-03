package yazlab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class pdf extends JFrame {
	private JPanel panel_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pdf frame = new pdf();
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
	public pdf() {
		
	}
	
	public pdf(String idno) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1450, 801);
		
		
		
		
	    JPanel panel;
	    panel_1 = new JPanel();
	    panel_1.setBackground(new Color(0, 204, 204));
	    
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1388, 762);
		panel_1.add(scrollPane);
		
		 ResultSet ms = baglanti.bagla();
		 String sql2= "SELECT book_url as url FROM `book-crossing`.book where bookID='"+idno+"'; ";
		 ms = baglanti.dogrula(sql2);
		    String url = null;
		 try {
			while(ms.next()){
				
				 
				  url = ms.getString("url");
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		//	setExtendedState(MAXIMIZED_BOTH);
		
			  SwingController control=new SwingController();
	            SwingViewBuilder factry=new SwingViewBuilder(control);
	             panel=factry.buildViewerPanel();
	            ComponentKeyBinding.install(control, panel);
	            control.getDocumentViewController().setAnnotationCallback(
	                    new org.icepdf.ri.common.MyAnnotationCallback(
	                    control.getDocumentViewController()));
	                   control.openDocument(url);
	                   scrollPane.setViewportView(panel); 
	                   
	                   JButton btnNewButton = new JButton("\u00C7\u0131k");
	                   btnNewButton.addActionListener(new ActionListener() {
	                   	public void actionPerformed(ActionEvent arg0) {
	                   		setVisible(false);
	                   		menu m3 = new menu();
	                   		m3.setVisible(true);
	                   	}
	                   });
	                   btnNewButton.setBounds(1387, 0, 47, 762);
	                   panel_1.add(btnNewButton);
	                   
		      
		
	}
	
	
}
