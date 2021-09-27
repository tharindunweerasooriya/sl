package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class user {

	// connect to the database
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
	
	
	
	
	
	
		public String login(String EMP_NAME) {
			
			String output ="";
			
			try {
				
				Connection con = connect();
				
				if(con == null) {
					
					return "error while connecting to dadabase";
				}
				
				System.out.println("error");
				
				//query
				String query = "select `EMP_NAME` from user where EMP_NAME =?";
				
				//create statement
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				System.out.println(preparedStmt);
				System.out.println(EMP_NAME);
				
				
				preparedStmt.setString(1, EMP_NAME);
				
				
				ResultSet rs = preparedStmt.executeQuery();
				
				
				if(rs.next()) {
					
					con.close();
					output = "success";
				}
				else {
					
					con.close();
					if(EMP_NAME.equals("")) {
						
						return "User cannot be empty";
					}
					
					
					else {
						
						return "incorrect username or password";
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				output = "Error while deleting the user."; 
				 System.err.println(e.getMessage()); 
				
			}
			return output;
		}
		
		
		public String readAdmin() { 
			
			String output = ""; 
			
			
			try{ 
				
				Connection con = connect(); 
				
				if (con == null) {
					
					return "Error while connecting to the database for reading."; 
					
				} 
	 
				//create html table
				output = "<table class='table table-hover' border='1'><tr> <th scope='col'>Reference Number</th> <th scope='col'>MSAN_Name</th> <th scope='col'>Prgress Status</th> <th scope='col'>Request Time</th> <th scope='col'>Enterd By</th> <th scope='col'>Enterd On</th> <th scope='col'>Assign To</th> <th scope='col'>Assign On</th> <th scope='col'>Completed On</th> <th scope='col'>Assign</th></tr>"; 
				
				//query
				String query = "select * from msan_req"; 
				//create statement
				Statement stmt = (Statement) con.createStatement(); 
				
				//create resultset
				ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
				
				
				while (rs.next()) { 
					
						String RF_NO = Integer.toString(rs.getInt("RF_NO")); 
						String MSAN_NAME = rs.getString("MSAN_NAME"); 
						String PROGRESS_STATUS = rs.getString("PROGRESS_STATUS"); 
						String REQ_TIME =rs.getString("REQ_TIME"); 
						String ENTERED_BY = rs.getString("ENTERED_BY"); 
						String ENTERED_ON = rs.getString("ENTERED_ON");
						String ASSIGN_TO = rs.getString("ASSIGN_TO");
						String ASSIGN_ON = rs.getString("ASSIGN_ON");
						String COMLETED_ON = rs.getString("COMLETED_ON");
						
						// Add into the html table
						output += "<tr><td><input id='hidItemIDUpdateA' name='hidItemIDUpdateA' type='hidden' value='" + RF_NO + "'>"
								 + RF_NO + "</td>";
								 output += "<td>"+ MSAN_NAME + "</td>"; 
								 output += "<td>"+ PROGRESS_STATUS + "</td>"; 
								 output += "<td>" + REQ_TIME + "</td>"; 
								 output += "<td>" + ENTERED_BY + "</td>"; 
								 output += "<td>" + ENTERED_ON + "</td>";
								 output += "<td>" + ASSIGN_TO + "</td>";
								 output += "<td>" + ASSIGN_ON + "</td>";
								 output += "<td>" + COMLETED_ON + "</td>";
						
						
						
						// buttons
								 output += "<td><input name='btnUpdateA' type='button' value='Assign' class='btnUpdateA btn btn-danger' data-id='" + RF_NO + "'>";
										

								 
								 
								 
								 
									
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
		
		public String updateAdmin(String RF_NO,String ASSIGN_TO){ 
			
			
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
				 		
				 		String newAdmin = readAdmin(); 
						 output = "{\"status\":\"success\", \"data\": \"" + 
						 newAdmin + "\"}"; 
			 
			 } 
			 
			 
			 catch (Exception e) { 
				 
				 output = "{\"status\":\"error\", \"data\":  \"Error while updating the user.\"}"; 
				 System.err.println(e.getMessage()); 
			 
			 }
			 
			 return output; 
			 
		} 
		
		
}
