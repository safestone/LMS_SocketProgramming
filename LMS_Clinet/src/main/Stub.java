package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Stub {
	private List<String> receivedMessages;
	private String SERVER_ADDRESS;
    private int SERVER_PORT;
	
    public Stub(String server_IP, int servr_Port) {
		this.SERVER_ADDRESS = server_IP;
		this.SERVER_PORT = servr_Port;
		this.receivedMessages = new ArrayList<>();
	}
	
	public List<String> request(List<String> sendMessages) {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);

            // Create input and output streams for the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            for (String send : sendMessages) {
                out.println(send);
            }
            out.println("END_OF_MESSAGES");
            
            receivedMessages.clear();
            
            String message;
            while ((message = in.readLine()) != null) {
                if(message.equals("END_OF_MESSAGES")) {
                	break;
                }
                receivedMessages.add(message); // Store the message in the list
            }
            
            sendMessages.clear();
            
            // Close the socket when done
            socket.close();
            
            return receivedMessages;
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}
}
