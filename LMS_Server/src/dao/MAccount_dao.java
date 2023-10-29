package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import secure.secure;

public class MAccount_dao {
	private List<String> sendMessage;
	private secure sec;
	
	String dbDriver = "com.mysql.cj.jdbc.Driver";
    // DB URL
    // IP:PORT/스키마 
    String dbUrl = "jdbc:mysql://127.0.0.1:3306/data";
    // DB ID/PW
    String dbUser = "root";
    String dbPassword = "root";
    
    public MAccount_dao() {
    	this.sendMessage = new ArrayList<>();
    	this.sec = new secure();
    }
    
    public List<String> login(List<String> receivedMessages) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	        System.out.println("DB Connection [성공]");
	        
	        stmt = conn.createStatement();
	        
	        String sql = ("select * from account where ID = '"+receivedMessages.get(2)+"'");
	        
	        rs = stmt.executeQuery(sql);

	        while(rs.next()) {
	    		String decryptPW = sec.decry(rs.getString(2));
	        	if(decryptPW.equals(receivedMessages.get(3))) {
	        		
	        		sendMessage.add(rs.getString(1));
	            	sendMessage.add(decryptPW);
	            	sendMessage.add(rs.getString(3));
	            	sendMessage.add(rs.getString(4));
	            	
	            	String ID = rs.getString(1);
	            	String PW = decryptPW;
	            	String name = rs.getString(3);
	            	String Date = rs.getString(4);
	            	
	            	System.out.println(ID + PW + name + Date);
	        	}
            }
	        return sendMessage;
	        
        } catch (SQLException e) {
            System.out.println("DB Connection [실패]");
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("DB Connection [실패]");
            e.printStackTrace();
            return null;
        }
	}
	
}
