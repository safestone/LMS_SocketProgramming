package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import control.CLectrueBasket;

public class PLectureBasket {
	private CLectrueBasket cLectureBasket;
	private List<String> sendMessages;
	
	public PLectureBasket() {
		this.cLectureBasket = new CLectrueBasket("localhost", 12345);
		this.sendMessages = new ArrayList<>();
	}
	

	public void Basket(List<String> receivedMessages, List<String> terminalResult, Scanner keyboard) {
		boolean bRunnig = true;
		while(bRunnig) {
			System.out.println("0.추가 1.조회 2.삭제 9.돌아가기");
			String command = keyboard.next();
			int select = Integer.parseInt(command);
			
			switch(select) {
			case 0:
				sendMessages.add("cLectureBasket");
				sendMessages.add("addBasket");
				sendMessages.add(terminalResult.get(0));  //강좌 파일 이름
				sendMessages.add(terminalResult.get(1));  //강좌 코드
				sendMessages.add(receivedMessages.get(0)+"basket"); //사용자의 아이디 - 미리담기 db의 식별자로 쓰일거임.
				
				List<String> addResult = cLectureBasket.addBasket(sendMessages);
				if(addResult.get(0).equals("null")) {
					System.out.println(addResult.get(1)+"은 이미 추가된 강좌입니다.");
				} else {
					System.out.println("성공적으로 " + addResult.get(1) + "가 추가되었습니다.");
				}
				break;
			case 1:
				sendMessages.add("cLectureBasket");
				sendMessages.add("lookBasket");
				sendMessages.add(receivedMessages.get(0)+"basket");  //사용자의 아이디
				List<String> lookResult = cLectureBasket.lookBasket(sendMessages);
				if(lookResult.get(0).equals("null")) {
				} else {
					for (String response : lookResult) {
						System.out.println(response);
					}
				}
				break;
			case 2:
				System.out.println("삭제할 강좌의 번호를 입력주세요.");
				String deleteNum = keyboard.next();
				
				sendMessages.add("cLectureBasket");
				sendMessages.add("deleteBasket");
				sendMessages.add(receivedMessages.get(0)+"basket"); //사용자의 아이디
				sendMessages.add(deleteNum);  //삭제할 코드
				
				List<String> deleteResult = cLectureBasket.deleteBasket(sendMessages);
				for (String response : deleteResult) {
					System.out.println(response);
				}
				break;
			case 9:
				bRunnig = false;
				break;
			default:
				break;
			}
		}
	}


	public void sincheong(List<String> receivedMessages, List<String> terminalResult, Scanner keyboard) {
		boolean bRunnig = true;
		while(bRunnig) {
			System.out.println("0.추가 1.조회 2.삭제 9.돌아가기");
			String command = keyboard.next();
			int select = Integer.parseInt(command);
			
			switch(select) {
			case 0:
				sendMessages.add("cLectureBasket");
				sendMessages.add("addSincheong");
				sendMessages.add(terminalResult.get(0));  //강좌 파일 이름
				sendMessages.add(terminalResult.get(1));  //강좌 코드
				sendMessages.add(receivedMessages.get(0)+"sincheong"); //사용자의 아이디 - 신청 db의 식별자로 쓰일거임.
				
				List<String> addResult = cLectureBasket.addSincheong(sendMessages);
				if(addResult.get(0).equals("null")) {
					System.out.println(addResult.get(1)+"은 이미 추가된 강좌입니다.");
				} else {
					System.out.println("성공적으로 " + addResult.get(1) + "가 추가되었습니다.");
				}
				break;
//			case 1:
//				sendMessages.add("cLectureBasket");
//				sendMessages.add("lookBasket");
//				sendMessages.add(receivedMessages.get(0)+"basket");  //사용자의 아이디
//				List<String> lookResulMiridamgi = cLectureBasket.lookBasket(sendMessages);
//				for (String response : lookResulMiridamgi) {
//					System.out.println(response);
//				}
//				
//				String first[] = lookResulMiridamgi.get(0).split("[ ]");
//				int num = (Integer.parseInt(first[0]) % 10);
//				
//				while(true) {
//					System.out.println("0.신청 1.돌아가기");
//					int answer = keyboard.nextInt();	
//					switch(answer) {
//					case 0:
//						System.out.println("신청하고자 하는 강좌의 코드를 입력해주세요.");
//						int code = keyboard.nextInt();
//						if(num == 0) {
//							String selectMessage = lookResulMiridamgi.get(code % 10);
//							String option[] = selectMessage.split("[ ]");
//							
//						} else if(num == 1) {
//							String selectMessage = lookResulMiridamgi.get((code % 10) - 1);
//							String option[] = selectMessage.split("[ ]");
//						}
//					}
//				}
			case 1:
				sendMessages.add("cLectureBasket");
				sendMessages.add("lookSincheong");
				sendMessages.add(receivedMessages.get(0)+"sincheong");  //사용자의 아이디
				List<String> lookResult = cLectureBasket.lookSincheong(sendMessages);
				if(lookResult.get(0).equals("null")) {
				} else {
					for (String response : lookResult) {
						System.out.println(response);
					}
				}
				break;
			case 2:
				System.out.println("삭제할 강좌의 번호를 입력주세요.");
				String deleteNum = keyboard.next();
				
				sendMessages.add("cLectureBasket");
				sendMessages.add("deleteBasket");
				sendMessages.add(receivedMessages.get(0)+"sincheong"); //사용자의 아이디
				sendMessages.add(deleteNum);  //삭제할 코드
				
				List<String> deleteResult = cLectureBasket.deleteBasket(sendMessages);
				for (String response : deleteResult) {
					System.out.println(response);
				}
				break;
			case 9:
				bRunnig= false;
				break;
			default:
				break;
			}
		}
	}



}
