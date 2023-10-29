package control;

import java.util.List;

import general.ICFindAccount;
import model.MFindAccount;

public class CFindAccount implements ICFindAccount{
	MFindAccount mFindAccount;
	public CFindAccount() {
		this.mFindAccount = new MFindAccount();
	}
	public List<String> findID(List<String> receivedMessages) {
		List<String> sendMessages = this.mFindAccount.findID(receivedMessages);
		return sendMessages;
		
	}
	public List<String> findPW(List<String> receivedMessages) {
		List<String> sendMessages = this.mFindAccount.findPW(receivedMessages);
		return sendMessages;
		
	}
}
