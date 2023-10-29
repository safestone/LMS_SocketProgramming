package model;

import java.util.List;

import dao.MAccount_dao;

public class MAccount extends MAccount_dao{
	private MAccount_dao mAccount_dao;
	
	public MAccount() {
		this.mAccount_dao =  new MAccount_dao();
	}

	public List<String> login(List<String> receivedMessages) {		
		List<String> sendMessage = this.mAccount_dao.login(receivedMessages);
		return sendMessage;
		
	}

}
