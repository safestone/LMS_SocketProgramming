package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MSelectIndex_dao {
	List<String> sendMessages;
	String dbDriver = "com.mysql.cj.jdbc.Driver";
    // DB URL
    // IP:PORT/스키마 
    String dbUrl = "jdbc:mysql://127.0.0.1:3306/data";
    // DB ID/PW
    String dbUser = "root";
    String dbPassword = "root";
    
    public MSelectIndex_dao() {
    	sendMessages = new ArrayList<>();
    }
    
	public List<String> getIndex(List<String> receivedMessages) {
		
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
	        try {
				Class.forName(dbDriver);
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		        System.out.println("DB Connection [성공]");
		        
		        stmt = conn.createStatement();
		        
		        String sql = ("select * from "+receivedMessages.get(2));
		        
		        rs = stmt.executeQuery(sql);
		        
		        while (rs.next()) {
		        	String result = (rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
		        	sendMessages.add(result);
				}
		        
		        conn.close();
		        stmt.close();
		        rs.close();
	        } catch (SQLException e) {
	            System.out.println("DB Connection [실패]");
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            System.out.println("DB Connection [실패]");
	            e.printStackTrace();
	        }
	        
	        return sendMessages;
	}

	public List<String> getTerminal(List<String> receivedMessages) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
	        try {
				Class.forName(dbDriver);
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		        System.out.println("DB Connection [성공]");
		        
		        stmt = conn.createStatement();
		        
		        String sql = ("select * from "+receivedMessages.get(2));
		        
		        rs = stmt.executeQuery(sql);
		        
		        while (rs.next()) {
		        	String result = (rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
		        	sendMessages.add(result);
				}
		        
		        conn.close();
		        stmt.close();
		        rs.close();
	        } catch (SQLException e) {
	            System.out.println("DB Connection [실패]");
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            System.out.println("DB Connection [실패]");
	            e.printStackTrace();
	        }
	        
	        return sendMessages;
	}

}
