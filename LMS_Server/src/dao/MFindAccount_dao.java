package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import secure.secure;

public class MFindAccount_dao {
	List<String> sendMessages;
	private secure sec;

	String dbDriver = "com.mysql.cj.jdbc.Driver";
    // DB URL
    // IP:PORT/스키마 
    String dbUrl = "jdbc:mysql://127.0.0.1:3306/data";
    // DB ID/PW
    String dbUser = "root";
    String dbPassword = "root";
    public MFindAccount_dao() {
    	this.sendMessages = new ArrayList<>();
    	this.sec = new secure();
    }
	public List<String> findID(List<String> receivedMessages) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
        	Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	        System.out.println("DB Connection [성공]");
	        
	        stmt = conn.createStatement();
	        
	        String sql = ("select * from account where NAME = '"+receivedMessages.get(2)+"'");
	        
	        rs = stmt.executeQuery(sql);
	        
	        while(rs.next()) {
	        	if(rs.getString(4).equals(receivedMessages.get(3))) {
	        		sendMessages.add(rs.getString(1));  //id값
	        		System.out.println(rs.getString(1));
	        	} 
	        }
	        
	        return sendMessages;
		} catch (Exception e) {
			e.printStackTrace();
			return sendMessages;
		}			
	}
	public List<String> findPW(List<String> receivedMessages) {
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
	        	if(rs.getString(4).equals(receivedMessages.get(3))) {
	        		sendMessages.add(decryptPW);  //PW값
	        		System.out.println(rs.getString(2));
	        		System.out.println(decryptPW);
	        	} 
	        }
	        return sendMessages;
		} catch (Exception e) {
			e.printStackTrace();
			return sendMessages;
		}			
	}

}
