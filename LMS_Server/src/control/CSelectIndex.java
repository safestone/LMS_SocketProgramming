package control;

import java.util.List;

import general.ICSelectIndex;
import model.MSelectIndex;

public class CSelectIndex implements ICSelectIndex{
	private MSelectIndex mSelectIndex;

	public List<String> getIndex(List<String> receivedMessages) {
		mSelectIndex = new MSelectIndex();
		List<String> sendMessages = mSelectIndex.getIndex(receivedMessages);
		return sendMessages;
	}

	@Override
	public List<String> getTerminal(List<String> receivedMessage) {
		mSelectIndex = new MSelectIndex();
		List<String> sendMessages = mSelectIndex.getTermianl(receivedMessage);
		return sendMessages;
	}
}
