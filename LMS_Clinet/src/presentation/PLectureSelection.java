package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import control.CSelectIndex;

public class PLectureSelection {
	CSelectIndex cSelectIndex;
	List<String> sendMessage;
	List<String> terminalResult;
	
	public PLectureSelection() {
		this.cSelectIndex = new CSelectIndex("localhost", 12345);
		this.sendMessage = new ArrayList<>();
		this.terminalResult = new ArrayList<>();
	}
	
	private String selectIndex(String message, String fileName, Scanner keyboard) {
		System.out.println(message);
		
		sendMessage.add("cSelectIndex");
		sendMessage.add("getIndex");
		sendMessage.add(fileName);
		
		List<String> receivedMessages = cSelectIndex.getIndex(sendMessage);
		
		for (String result : receivedMessages) {
			System.out.println(result);
		}
		
		String first[] = receivedMessages.get(0).split("[ ]");
		int num = (Integer.parseInt(first[0]) % 10);
		
		if(num == 0) {
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			
			String selectMessage = receivedMessages.get(selection % 10);
			String option[] = selectMessage.split("[ ]");
			
			String nextIndex = option[2];
			return nextIndex;
		} else if (num == 1) {
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			
			String selectMessage = receivedMessages.get(selection % 10 - 1);
			String option[] = selectMessage.split("[ ]");
			
			String nextIndex = option[2];
			return nextIndex;
		}
		return null;		

	}
	
	private List<String> terminal(String message, String fileName, Scanner keyboard) {
		System.out.println(message);
		
		sendMessage.add("cSelectIndex");
		sendMessage.add("getTerminal");
		sendMessage.add(fileName);
		
		List<String> receivedMessages = cSelectIndex.getTerminal(sendMessage);
		
		for (String result : receivedMessages) {
			System.out.println(result);
		}
		
		String first[] = receivedMessages.get(0).split("[ ]");
		int num = (Integer.parseInt(first[0]) % 10);
		
		if(num == 0) {
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			
			String selectMessage = receivedMessages.get(selection % 10);
			System.out.println("선택: " + receivedMessages.get(selection % 10));
			String option[] = selectMessage.split("[ ]");
			
			terminalResult.add(fileName);
			terminalResult.add(option[0]);
			
			return terminalResult;
		} else if (num == 1) {
			String command = keyboard.next();
			int selection = Integer.parseInt(command);
			
			String selectMessage = receivedMessages.get((selection % 10) - 1);
			System.out.println("선택: " + receivedMessages.get((selection % 10) - 1));
			String option[] = selectMessage.split("[ ]");
			
			terminalResult.add(fileName);
			terminalResult.add(option[0]);
			
			return terminalResult;
		}
		return null;
	}
	
	public List<String> selectLecture(Scanner keyboard) {
		String campusFileName = selectIndex("캠퍼스 코드를 선택하세요", "root", keyboard);
		String collegeFileName = selectIndex("대학 코드를 선택하세요", campusFileName, keyboard);
		String departmentFileName = selectIndex("과목 코드를 선택하세요", collegeFileName, keyboard);
		
		List<String> terminalResult = terminal("강좌 코드를 선택하세요", departmentFileName, keyboard);
		return terminalResult;
	}
}
