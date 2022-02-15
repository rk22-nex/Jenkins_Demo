package CSV.writeread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class dbconnection {
	public static void main(String[] arg){
		
		dbconnection d =new dbconnection();
		System.out.println(d.getconnection());}
		public Connection getconnection() {
			Connection con =null;
			try {

				Class.forName("com.mysql.jdbc.Driver");  
			 
				// con = DriverManager.getConnection("jdbc:mysql://192.168.11.210:3306/student","root","Mobi7548"); 
		//	con = DriverManager.getConnection("jdbc:mysql://192.168.10.203:3306/mobiversa","ezywirepay","MQ711ZLW4UI1VPX2"); 
//demo db we need to use this(below)  for checking if it works we can comment this and uncommented the above(live) and sent to sangeetha
				con = DriverManager.getConnection("jdbc:mysql://192.168.11.210:3306/mobiversa","root","Mobi7548"); 
				
			}
			catch(ClassNotFoundException e) {
			System.out.println("db not connected");
			e.printStackTrace();
			
	}catch(SQLException e) {
		
		e.printStackTrace();
		
	}
	return con;
	}
	}


