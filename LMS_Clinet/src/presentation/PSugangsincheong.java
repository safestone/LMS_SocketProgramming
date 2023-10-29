package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PSugangsincheong {
	PLectureSelection pLectureSelection;
	PLectureBasket pMiridamgiBasket;
	List<String> terminalResult;
	
	public PSugangsincheong() {
		this.pLectureSelection = new PLectureSelection();
		this.pMiridamgiBasket = new PLectureBasket();
		this.terminalResult = new ArrayList<>();
	}

	public void run(List<String> receivedMessages, Scanner keyboard) {
		boolean bRunning = true;
		while(bRunning) {
			if(terminalResult.isEmpty()) {
				System.out.println("0.강좌 선택");
			} else {
				System.out.println("0.강좌 선택 1.미리담기 2.수강신청 9.돌아가기");
			}
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			
			switch (selection) {
			case 0:
	            if (!terminalResult.isEmpty()) {
	                terminalResult.clear();
	            }
				terminalResult = pLectureSelection.selectLecture(keyboard);
				break;
			case 1:
				pMiridamgiBasket.Basket(receivedMessages, terminalResult, keyboard);
				break;
			case 2:
				pMiridamgiBasket.sincheong(receivedMessages, terminalResult, keyboard);
				break;
			case 9:
				bRunning = false;
				break;
			default:
				break;
			}
		}

	}

}
