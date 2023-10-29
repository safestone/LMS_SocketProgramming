package control;

import java.util.List;

import general.ICLectrueBasket;
import model.MLectureBasket;

public class CLectrueBasket implements ICLectrueBasket{
	private MLectureBasket mLectureBasket;
	
	public CLectrueBasket() {
		this.mLectureBasket = new MLectureBasket();
	}
	
	@Override
	public List<String> addBasket(List<String> receivedMessages) {
		List<String> sendMessages = mLectureBasket.addBasket(receivedMessages);
		return sendMessages;
	}
	@Override
	public List<String> lookBasket(List<String> receivedMessages) {
		List<String> sendMessages = mLectureBasket.lookBasket(receivedMessages);
		return sendMessages;
	}

	@Override
	public List<String> deleteBasket(List<String> receivedMessages) {
		List<String> sendMessages = mLectureBasket.deletBasket(receivedMessages);
		return sendMessages;
	}

	@Override
	public List<String> addSincheong(List<String> receivedMessages) {
		List<String> sendMessages = mLectureBasket.addSincheong(receivedMessages);
		return sendMessages;
	}

	@Override
	public List<String> lookSincheong(List<String> receivedMessages) {
		List<String> sendMessages = mLectureBasket.lookSincheong(receivedMessages);
		return sendMessages;
	}

	@Override
	public List<String> deleteSincheong(List<String> receivedMessages) {
		List<String> sendMessages = mLectureBasket.deleteSincheong(receivedMessages);
		return sendMessages;
	}
	
}
