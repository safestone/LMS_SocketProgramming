package control;

import java.util.List;

import general.ICCreateAccount;
import main.Stub;

public class CCreateAccount extends Stub implements ICCreateAccount{

	public CCreateAccount(String server_IP, int servr_Port) {
		super(server_IP, servr_Port);
	}

	public List<String> createAccount(List<String> sendMessages) {
		List<String> recivedMessages = this.request(sendMessages);
		return recivedMessages;
	}

}
