package model;

import java.util.List;

import dao.MLectureBasket_dao;

public class MLectureBasket {
	private MLectureBasket_dao mLectureBasket_dao;
	
	public MLectureBasket() {
		this.mLectureBasket_dao = new MLectureBasket_dao();
	}
	
	public List<String> addBasket(List<String> receivedMessages) {
		List<String> sendMessages = mLectureBasket_dao.add(receivedMessages);
		return sendMessages;
	}

	public List<String> lookBasket(List<String> receivedMessages) {
		List<String> sendMessages = mLectureBasket_dao.look(receivedMessages);
		return sendMessages;
	}

	public List<String> deletBasket(List<String> receivedMessages) {
		List<String> sendMessages = mLectureBasket_dao.delete(receivedMessages);
		return sendMessages;
	}

	public List<String> addSincheong(List<String> receivedMessages) {
		List<String> sendMessages = mLectureBasket_dao.add(receivedMessages);
		return sendMessages;
	}

	public List<String> lookSincheong(List<String> receivedMessages) {
		List<String> sendMessages = mLectureBasket_dao.look(receivedMessages);
		return sendMessages;
	}

	public List<String> deleteSincheong(List<String> receivedMessages) {
		List<String> sendMessages = mLectureBasket_dao.delete(receivedMessages);
		return sendMessages;
	}

}
