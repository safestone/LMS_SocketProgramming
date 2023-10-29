package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import control.CFindAccount;

public class PFindAccount {
	private CFindAccount cFindAccount;
	
	public PFindAccount() {
		cFindAccount = new CFindAccount("localhost", 12345);
	}

	public void findId(Scanner keyboard) {
		System.out.println("이름을 입력해주세요.");
		String name = keyboard.next();
		System.out.println("생년월일을 입력해주세요.");
		String birth = keyboard.next();
		
		List<String> sendMesseage = new ArrayList<>();
		sendMesseage.add("cFindAccount");
		sendMesseage.add("findID");
		sendMesseage.add(name);
		sendMesseage.add(birth);
		
		List<String> receivedMessages = cFindAccount.findID(sendMesseage);
		
		if (receivedMessages.get(0).equals("null")) {
			System.out.println("입력하신 정보에 해당하는 계정이 존재하지 않습니다.");
		} else {
			for(String result : receivedMessages) {
				System.out.println("ID:" + result);
			}
		}

	}

	public void findPW(Scanner keyboard) {
		System.out.println("아이디를 입력해주세요.");
		String id = keyboard.next();
		System.out.println("생년월일 입력해주세요.");
		String birth = keyboard.next();
		
		List<String> sendMesseage = new ArrayList<>();
		sendMesseage.add("cFindAccount");
		sendMesseage.add("findPW");
		sendMesseage.add(id); //id 전송
		sendMesseage.add(birth); //생년월일
		
		List<String> receivedMessages = cFindAccount.findPW(sendMesseage);

		if (receivedMessages.get(0).equals("null")) {
			System.out.println("입력하신 정보에 해당하는 계정이 존재하지 않습니다.");
		} else {
			for(String result : receivedMessages) {
				System.out.println("PW: "+result);
			}
		}

	}

}
