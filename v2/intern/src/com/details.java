package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class details {
	
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
	
	
public String readDetails() { 
		
		String output = ""; 
		
		
		try{ 
			
			Connection con = connect(); 
			
			if (con == null) {
				
				return "Error while connecting to the database for reading."; 
				
			} 
 
			//create html table
			output = "<table style=\"width:100%\" class='table table-hover' border='1' align =\"center\"><tr> <th scope='col'>CIRT STATUS</th> <th scope='col'>FRAU NAME</th> <th scope='col'>FRAA POSITION</th> <th scope='col'>SATT DEFAULTVALUE</th> <th scope='col'>Actual NUMBER</th> <th scope='col'>ENTERED TIME</th></tr>"; 
			
			//query
			String query = "select * from msan_details"; 
			//create statement
			Statement stmt = (Statement) con.createStatement(); 
			
			//create resultset
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			
			
			while (rs.next()) { 
				
					String REQ_ID = Integer.toString(rs.getInt("REQ_ID"));
					String CIRT_STATUS = rs.getString("CIRT_STATUS"); 
					String FRAU_NAME = rs.getString("FRAU_NAME");
					String FRAU_POSITION = rs.getString("FRAU_POSITION");
					String SATT_DEFAULTVALUE = Integer.toString(rs.getInt("SATT_DEFAULTVALUE"));
					String ACTUAL_NUMBER = Integer.toString(rs.getInt("ACTUAL_NUMBER"));
					String ENTERD_TIME = rs.getString("ENTERD_TIME");
					
					
					// Add into the html table
					output += "<tr><td><input id='hidItemIDUpdateA' name='hidItemIDUpdateA' type='hidden' value='" + REQ_ID + "'>"
							 + CIRT_STATUS + "</td>";
							 output += "<td>"+ FRAU_NAME + "</td>"; 
							 output += "<td>"+ FRAU_POSITION + "</td>";
							 output += "<td>"+ SATT_DEFAULTVALUE + "</td>";
							 output += "<td>"+ ACTUAL_NUMBER + "</td>";
							 output += "<td>"+ ENTERD_TIME + "</td>";
							
					
					
					
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

}
