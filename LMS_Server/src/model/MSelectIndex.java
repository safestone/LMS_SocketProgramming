package model;

import java.util.List;

import dao.MSelectIndex_dao;

public class MSelectIndex {
	private MSelectIndex_dao mSelectIndex_dao;
	public MSelectIndex() {
		this.mSelectIndex_dao = new MSelectIndex_dao();
	}
	public List<String> getIndex(List<String> receivedMessages) {
		List<String> sendMessages = mSelectIndex_dao.getIndex(receivedMessages);
		return sendMessages;
	}
	public List<String> getTermianl(List<String> receivedMessage) {
		List<String> sendMessages = mSelectIndex_dao.getTerminal(receivedMessage);
		return sendMessages;
	}

}
