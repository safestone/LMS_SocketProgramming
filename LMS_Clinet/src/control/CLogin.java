package control;
import java.util.List;

import general.ICLogin;
import main.Stub;

public class CLogin extends Stub implements ICLogin{

	public CLogin(String server_IP, int servr_Port) {
		super(server_IP, servr_Port);
	}

	@Override
	public List<String> login(List<String> sendMessages) {
		List<String> receivedMessages = this.request(sendMessages);
		return receivedMessages;
	}
	

}
