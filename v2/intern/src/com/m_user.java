package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class m_user {

	private Connection connect() { 
		 
		Connection con = null; 
			try{ 
				
					Class.forName("com.mysql.jdbc.Driver"); 
	 
					//database name, username , password
					con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/slt", "root", ""); 
			} 
			catch (Exception e) {
				
				e.printStackTrace();
				
			} 
			
			return con; 
	 } 
	
	public String readUser() { 
		
		String output = ""; 
		
		
		try{ 
			
			Connection con = connect(); 
			
			if (con == null) {
				
				return "Error while connecting to the database for reading."; 
				
			} 
 
			//create html table
			output = "<table style=\"width:50%\" class='table table-hover' border='1' align =\"center\"><tr> <th scope='col'>Employee Number</th> <th scope='col'>Employee Name</th> <th scope='col'>RTOM</th></tr>"; 
			
			//query
			String query = "select * from m_user"; 
			//create statement
			Statement stmt = (Statement) con.createStatement(); 
			
			//create resultset
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			
			
			while (rs.next()) { 
				
					String mEMP_NO = Integer.toString(rs.getInt("mEMP_NO")); 
					String mEMP_NAME = rs.getString("mEMP_NAME"); 
					String RTOM = rs.getString("RTOM"); 
					
					
					// Add into the html table
					output += "<tr><td><input id='hidItemIDUpdateA' name='hidItemIDUpdateA' type='hidden' value='" + mEMP_NO + "'>"
							 + mEMP_NO + "</td>";
							 output += "<td>"+ mEMP_NAME + "</td>"; 
							 output += "<td>"+ RTOM + "</td>"; 
							
					
					
					
					// buttons
							 
									

				}
			
			con.close(); 
			output += "</table>";
		} 
		catch (Exception e) { 
			
			 output = "{\"status\":\"error\", \"data\":  \"Error while updating the admin.\"}"; 
			 System.err.println(e.getMessage()); 
		 
 
		} 
		return output; 

} 
	
	
	public String updateUser(String RF_NO,String ASSIGN_TO){ 
		
		
		 String output = ""; 
		 
		 try{
			 
			 
			 Connection con = connect(); 
			 
			 if (con == null) {
				 
				 return "Error while connecting to the database for updating."; 
				 
			 } 
			 
			 
			 	// query
			 	String query = "UPDATE msan_req SET ASSIGN_TO=? WHERE RF_NO=?"; 
			 	
			 	//create statement
			 	PreparedStatement preparedStmt = con.prepareStatement(query); 
			 	
			 	
			 		// set values
			 		
			 		
			 		preparedStmt.setString(1, ASSIGN_TO);
			 		preparedStmt.setInt(2, Integer.parseInt(RF_NO));
			 		
			 		// execute the statement
			 		preparedStmt.execute(); 
			 		con.close();
			 		
			 		String newM_user = readUser(); 
					 output = "{\"status\":\"success\", \"data\": \"" + 
					 newM_user + "\"}"; 
		 
		 } 
		 
		 
		 catch (Exception e) { 
			 
			 output = "{\"status\":\"error\", \"data\":  \"Error while updating the user.\"}"; 
			 System.err.println(e.getMessage()); 
		 
		 }
		 
		 return output; 
		 
	} 
	
	
}
