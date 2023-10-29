package control;

import java.util.List;

import general.ICCreateAccount;
import model.MCreateAccount;

public class CCreateAccount implements ICCreateAccount{
	private MCreateAccount mCreateAccount;
	
	public CCreateAccount() {
		mCreateAccount = new MCreateAccount();
	}

	public List<String> createAccount(List<String> recivedMessages) {
		List<String> sendMessages = mCreateAccount.createAccount(recivedMessages);
		return sendMessages;
	}

}
