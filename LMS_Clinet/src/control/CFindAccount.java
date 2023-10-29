package control;

import java.util.List;

import general.ICFindAccount;
import main.Stub;

public class CFindAccount extends Stub implements ICFindAccount{

	public CFindAccount(String server_IP, int servr_Port) {
		super(server_IP, servr_Port);
	}

	@Override
	public List<String> findID(List<String> sendMesseage) {
		List<String> receivedMessages = this.request(sendMesseage);
		return receivedMessages;
	}

	@Override
	public List<String> findPW(List<String> sendMesseage) {
		List<String> receivedMessages = this.request(sendMesseage);
		return receivedMessages;
	}



}
