package yazlab;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class baglanti {
	 static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	 static final String DOMAIN_NAME = "localhost:3306";
	 static final String DB_NAME = "book-crossing"; 
	 static final String DB_URL = "jdbc:mysql://" + DOMAIN_NAME + "/" + DB_NAME +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";//Buraya ellemenize gerek yok
	 static final String USER = "root";
	 static final String PASS = "";
	 
	static Connection con;
    static Statement st;
    static PreparedStatement pst=null;
    
	
    static ResultSet bagla() {
		
    	ResultSet myRs = null;
        
		try {
		  Class.forName(JDBC_DRIVER);  
            System.out.println("Veritabanýna baðlanýlýyor...");
            con = DriverManager.getConnection(DB_URL,USER,PASS);
            
            System.out.println("Veritabanýna baðlandý.");
            st = con.createStatement();
          
          
		}
         catch (SQLException se) {
           
             System.out.println("baglanamadý");
          
        } catch (Exception e) {
          
            
        }
		  return myRs;
	}
	static void kayit_ol(String sql_sorgu) {
		 try {
			st.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	static ResultSet dogrula(String sql_sorgu) {
		ResultSet myRs = null;
		 try {
			myRs = st.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return myRs;
	 }
	static ResultSet listele1() {
		ResultSet myRs = null;
		 try {
			 myRs = st.executeQuery("select * from book;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return myRs;
	 }
	static ResultSet listele2() {
		ResultSet myRs = null;
		 try {
			 myRs = st.executeQuery("SELECT * FROM book order by bookRating DESC LIMIT 10;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return myRs;
	 }
	static ResultSet listele3() {
		ResultSet myRs = null;
		 try {
			 myRs = st.executeQuery("SELECT * FROM book order by countOfReading DESC LIMIT 10;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return myRs;
	 }
	static ResultSet users() {
		ResultSet myRs = null;
		 try {
			 myRs = st.executeQuery("select * from users;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return myRs;
	 }
	static ResultSet dogrula2(String sql_sorgu) {
		ResultSet myRs = null;
		 try {
			myRs = st.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return myRs;
	 }
	static ResultSet dogrula3(String sql_sorgu) {
		ResultSet myRs = null;
		 try {
			myRs = st.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return myRs;
	 }
	static ResultSet dogrula4(String sql_sorgu) {
		ResultSet myRs = null;
		 try {
			myRs = st.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return myRs;
	 }
	
	
}