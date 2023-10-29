package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import control.CCreateAccount;
import control.CFindAccount;
import control.CLectrueBasket;
import control.CLogin;
import control.CSelectIndex;

public class Skeleton {
	private final int PORT;
	private HashMap<String, Object> objcetMap;

	public Skeleton() {
		this.PORT = 12345;
		this.objcetMap = new HashMap<String, Object>();
		this.objcetMap.put("cLogin", new CLogin());
		this.objcetMap.put("cSelectIndex", new CSelectIndex());
		this.objcetMap.put("cLectureBasket", new CLectrueBasket());
		this.objcetMap.put("cFindAccount", new CFindAccount());
		this.objcetMap.put("cCreateAccount", new CCreateAccount());
	}

	public void process() {
		 try {
	            // Create a server socket that listens on the specified port
	            ServerSocket serverSocket = new ServerSocket(PORT);
	            System.out.println("Server is listening on port " + PORT);

	            while (true) {
	                // Wait for a client to connect
	                Socket clientSocket = serverSocket.accept();
	                System.out.println("Client connected: " + clientSocket.getInetAddress());

	                Session session = new Session(clientSocket, objcetMap);
	                session.start();
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
    }
	public class Session extends Thread{
		private Socket clientSocket;
		private HashMap<String,Object> objectMap;
	    private List<String> receivedMessages;
	    private List<String> sendMessages;

		public Session(Socket clientSocket, HashMap<String, Object> objcetMap) {
			this.clientSocket = clientSocket;
			this.objectMap = objcetMap;
			this.receivedMessages = new ArrayList<>();
			this.sendMessages = new ArrayList<>();
		}

		public void run(){
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	            
                String message;
                while ((message = in.readLine()) != null) {
                    if(message.equals("END_OF_MESSAGES")) {
                    	break;
                    }
                	System.out.println("Received from client: " + message);
                    receivedMessages.add(message); // Store the message in the list
                }
                
	            Object object = this.objectMap.get(receivedMessages.get(0));
				sendMessages = (List<String>) object.getClass().getMethod(receivedMessages.get(1), List.class).invoke(object, receivedMessages);
				
				if(sendMessages.isEmpty()) {
					out.println("null");
				} else {
		            for (String send : sendMessages) {
		                out.println(send);
		            }	
				}
	            out.println("END_OF_MESSAGES");
				
	            receivedMessages.clear();
	            sendMessages.clear();
	            
                clientSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} 
}
