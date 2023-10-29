package presentation;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import control.CLogin;
import valueObject.VLogin;

public class PLogin {
	private CLogin cLogin;
	private VLogin vLogin;
    private List<String> sendMessages;
    
    public PLogin() {
    	this.cLogin = new CLogin("localhost", 12345);
    	this.vLogin = new VLogin();
		this.sendMessages = new ArrayList<>();
	}

	public List<String> login(Scanner sc) {
		
		System.out.println("사용자 아이디를 입력하세요");
		String userId = sc.next();
		System.out.println("사용자 비밀번호를 입력하세요");
		String password = sc.next();
		
		sendMessages.add("cLogin");
		sendMessages.add("login");
		sendMessages.add(userId);
		sendMessages.add(password);
		
		
		List<String> receivedMessages = cLogin.login(sendMessages);
		if (receivedMessages.get(0).equals("null")) {
			System.out.println("잘 못 입력하셨습니다.");
		} else {
			System.out.println(receivedMessages.get(2) + "님 안녕하세요");
		}
		return receivedMessages;
	}

}
