package model;

import java.util.List;

import dao.MFindAccount_dao;

public class MFindAccount {
	private MFindAccount_dao mFindAccount_dao;
	public MFindAccount() {
		this.mFindAccount_dao = new MFindAccount_dao();
	}
	public List<String> findID(List<String> receivedMessages) {
		List<String> sendMessages = this.mFindAccount_dao.findID(receivedMessages);
		return sendMessages;
	}

	public List<String> findPW(List<String> receivedMessages) {
		List<String> sendMessages = this.mFindAccount_dao.findPW(receivedMessages);
		return sendMessages;
	}

}
