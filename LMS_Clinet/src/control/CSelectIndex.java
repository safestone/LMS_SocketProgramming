package control;

import java.util.List;

import general.ICSelectIndex;
import main.Stub;

public class CSelectIndex extends Stub implements ICSelectIndex{

	public CSelectIndex(String server_IP, int servr_Port) {
		super(server_IP, servr_Port);
	}

	public List<String> getIndex(List<String> sendMessage) {
		List<String> receivedMessages = this.request(sendMessage);
		return receivedMessages;
	}

	@Override
	public List<String> getTerminal(List<String> sendMessage) {
		List<String> receivedMessages = this.request(sendMessage);
		return receivedMessages;
	}

}
