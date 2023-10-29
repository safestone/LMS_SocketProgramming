package model;

import java.util.List;

import dao.MCreateAccount_dao;

public class MCreateAccount {
	private MCreateAccount_dao mCreateAccount_dao;
	public MCreateAccount() {
		mCreateAccount_dao = new MCreateAccount_dao();
	}
	public List<String> createAccount(List<String> recivedMessages) {
		List<String> sendMessages = mCreateAccount_dao.createAccount(recivedMessages);
		return sendMessages;
	}

}
