package main;
import java.util.List;
import java.util.Scanner;

import presentation.PCreateAccount;
import presentation.PFindAccount;
import presentation.PLogin;
import presentation.PSugangsincheong;


public class CMain {
	private Scanner keyboard;
	private PLogin pLogin;
	private PSugangsincheong pSugangsincheong;
	private PFindAccount pFindID;
	private PFindAccount pFindPW;
	private PCreateAccount pCreateAccount;
	
	public CMain() {
		this.pLogin = new PLogin();
		this.pSugangsincheong = new PSugangsincheong();
		this.pFindID = new PFindAccount();
		this.pFindPW = new PFindAccount();
		this.pCreateAccount = new PCreateAccount();
	}
	
	private void run() {
		try {
			keyboard = new Scanner(System.in);
			List<String> receivedMessages = pLogin.login(keyboard);

			while (true) {
				if(!(receivedMessages.get(0).equals("null"))) {
					pSugangsincheong.run(receivedMessages, keyboard);
					receivedMessages.clear();
					receivedMessages.add("null");
				} else {
					System.out.println("0.회원가입 | 1. 로그인 다시 시도 | 2. 아이디 찾기 | 3. 비밀번호 찾기 | 4.종료 |");
					int answer = keyboard.nextInt();
					if (answer == 0) {
						pCreateAccount.createAccount(keyboard);
					} else if (answer == 1) {
						receivedMessages.clear();
						receivedMessages = pLogin.login(keyboard);
					} else if (answer == 2) {
						pFindID.findId(keyboard);
					} else if (answer == 3) {
						pFindPW.findPW(keyboard);
					} else if (answer == 4) {
						System.out.println("종료되었습니다.");
						System.exit(0);
					}
				}	
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getLocalizedMessage();
			System.out.println(e.getLocalizedMessage());
		}

	}
	
	public static void main(String[] args) {
		CMain main = new CMain(); //main이라는 곳에 main 주소를 담는 것을 메모리에 만듬.
		main.run();
	}
}
