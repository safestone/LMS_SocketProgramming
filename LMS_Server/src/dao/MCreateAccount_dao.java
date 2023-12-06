package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import secure.AES128;
import secure.secure;

public class MCreateAccount_dao {
	List<String> sendMessages;
	private secure sec;
	
	String dbDriver = "com.mysql.cj.jdbc.Driver";
    // DB URL
    // IP:PORT/스키마 
    String dbUrl = "jdbc:mysql://127.0.0.1:3306/data";
    // DB ID/PW
    String dbUser = "root";
    String dbPassword = "root";
    
    public MCreateAccount_dao() {
    	this.sec = new secure();
    	this.sendMessages = new ArrayList<>();
    }
    
	public List<String> createAccount(List<String> recivedMessages) {
		Connection conn = null;
		Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // JDBC 드라이버 로드
            Class.forName(dbDriver);
            
            // 데이터베이스 연결
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            
            // SQL INSERT 쿼리
            String insertQuery = "INSERT INTO account (ID, PW, NAME, DATE) VALUES (?, ?, ?, ?)";
            
            // PreparedStatement 생성
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            
            //암호화 하기
            String encryptPW = sec.encry(recivedMessages.get(3));
            
            // 데이터 설정
            preparedStatement.setString(1, recivedMessages.get(2));
            preparedStatement.setString(2, encryptPW);
            preparedStatement.setString(3, recivedMessages.get(4));
            preparedStatement.setString(4, recivedMessages.get(5));
            
            // 쿼리 실행
            preparedStatement.executeUpdate();
            
            String decryptPW = sec.decry(encryptPW);
            
            sendMessages.add(recivedMessages.get(4));
            sendMessages.add(encryptPW);
            sendMessages.add(decryptPW);
            
            return sendMessages;
            
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sendMessages;
	}
	
	

}
