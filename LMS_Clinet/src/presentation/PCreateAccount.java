package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import control.CCreateAccount;

public class PCreateAccount {
	List<String> sendMessages;
	private CCreateAccount cCreateAccount;

	public PCreateAccount() {
		this.sendMessages = new ArrayList<>();
		this.cCreateAccount = new CCreateAccount("localhost", 12345);
	}
	public void createAccount(Scanner keyboard) {
		System.out.println("ID: ");
		String ID = keyboard.next();
		System.out.println("PW: ");
		String PW = keyboard.next();
		System.out.println("name: ");
		String NAME = keyboard.next();
		System.out.println("date of birth: ");
		String DATE = keyboard.next();
		
		sendMessages.add("cCreateAccount");
		sendMessages.add("createAccount");
		sendMessages.add(ID);
		sendMessages.add(PW);
		sendMessages.add(NAME);
		sendMessages.add(DATE);
		
		List<String> receivedMessages = cCreateAccount.createAccount(sendMessages);
		if (receivedMessages.get(0).equals("null")) {
			System.out.println("입력하신 정보에 해당하는 계정이 이미 존재합니다.");
		} else {
			System.out.println(receivedMessages.get(0)+"님 회원가입이 완료되었습니다.");
			System.out.println("암호문: " + receivedMessages.get(1));
			System.out.println("해독문: " + receivedMessages.get(2));
		}
	}

}
