package control;
import java.util.List;

import general.ICLogin;
import model.MAccount;

public class CLogin implements ICLogin{
	private MAccount mAccount;
	
	public List<String> login(List<String> receivedMessages) {
		mAccount = new MAccount();
		List<String> sendMessages = this.mAccount.login(receivedMessages);
		
		return sendMessages;
	}
}
