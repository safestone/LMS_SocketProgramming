package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MLectureBasket_dao {
    List<String> sendMessages;
	String dbDriver = "com.mysql.cj.jdbc.Driver";
    // DB URL
    // IP:PORT/스키마 
    String sourceDbUrl = "jdbc:mysql://127.0.0.1:3306/data";
    String targetDbUrl = "jdbc:mysql://127.0.0.1:3306/miridamgi";

    // DB ID/PW
    String dbUser = "root";
    String dbPassword = "root";
    public MLectureBasket_dao() {
    	sendMessages = new ArrayList<>();
    }
    public List<String> add(List<String> receivedMessages) {
         try {
             // Connect to the source database
             Connection sourceConnection = DriverManager.getConnection(sourceDbUrl, dbUser, dbPassword);

             // Connect to the target database
             Connection targetConnection = DriverManager.getConnection(targetDbUrl, dbUser, dbPassword);

             // Query to retrieve data from the source table
             String selectQuery = "SELECT * FROM "+ receivedMessages.get(2) +" WHERE code='"+receivedMessages.get(3)+"'";
             PreparedStatement selectStatement = sourceConnection.prepareStatement(selectQuery);
             ResultSet resultSet = selectStatement.executeQuery();
             
             String createTableSQL = "CREATE TABLE IF NOT EXISTS "+receivedMessages.get(4)+" ("
                     + "code INT PRIMARY KEY,"
                     + "lecture VARCHAR(45) NOT NULL,"
                     + "name VARCHAR(45) NOT NULL,"
                     + "credit INT NOT NULL,"
                     + "time VARCHAR(45) NOT NULL"
                     + ")";
             targetConnection.createStatement().executeUpdate(createTableSQL);
             
             // Prepare the insert statement for the target table
             String insertQuery = "INSERT INTO "+receivedMessages.get(4)+"(code, lecture, name, credit, time) VALUES (?, ?, ?, ?, ?)";
             PreparedStatement insertStatement = targetConnection.prepareStatement(insertQuery);
             

             
             while (resultSet.next()) {
                 sendMessages.add(resultSet.getString(1));
                 sendMessages.add(resultSet.getString(2));
                 sendMessages.add(resultSet.getString(3));
                 sendMessages.add(resultSet.getString(4));
                 sendMessages.add(resultSet.getString(5));


                 // Set the values for the insert statement
                 insertStatement.setString(1, sendMessages.get(0));
                 insertStatement.setString(2, sendMessages.get(1));
                 insertStatement.setString(3, sendMessages.get(2));
                 insertStatement.setString(4, sendMessages.get(3));
                 insertStatement.setString(5, sendMessages.get(4));

                 // Insert data into the target table
                 insertStatement.executeUpdate();
             }

             // Close resources
             resultSet.close();
             selectStatement.close();
             insertStatement.close();
             sourceConnection.close();
             targetConnection.close();

             System.out.println("Data transferred from source to target successfully.");
             
             return sendMessages;
         } catch (SQLException e) {
             e.printStackTrace();
             String errorLecture = sendMessages.get(1);
             sendMessages.clear();
             sendMessages.add(null);
             sendMessages.add(errorLecture);
             return sendMessages;
         }
    }

	public List<String> look(List<String> receivedMessages) {
        try {
			Connection targetConnection = DriverManager.getConnection(targetDbUrl, dbUser, dbPassword);
			Statement stmt = targetConnection.createStatement();
			
			String sql = ("SELECT * FROM " + receivedMessages.get(2));
			
			ResultSet rs = stmt.executeQuery(sql);
            List<String> sendMessages = new ArrayList<>();

			while(rs.next()) {
				String result = (rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
				sendMessages.add(result);
			}
			
			return sendMessages;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<String> delete(List<String> receivedMessages) {
		try {
			Connection targetConnection = DriverManager.getConnection(targetDbUrl, dbUser, dbPassword);
			Statement stmt = targetConnection.createStatement();

			String delete = "DELETE FROM "+receivedMessages.get(2)+" where code='"+receivedMessages.get(3)+"'";
			
			stmt.executeUpdate(delete);
			
			String sql = ("SELECT * FROM " + receivedMessages.get(2));
			ResultSet rs = stmt.executeQuery(sql);
            List<String> sendMessages = new ArrayList<>();
			
			while(rs.next()) {
				String result = (rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
				sendMessages.add(result);
			}
			
			return sendMessages;
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
