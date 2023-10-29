package control;

import java.util.List;

import general.ICLectrueBasket;
import main.Stub;

public class CLectrueBasket extends Stub implements ICLectrueBasket{

	public CLectrueBasket(String server_IP, int servr_Port) {
		super(server_IP, servr_Port);
	}

	public List<String> addBasket(List<String> sendMessages) {
		List<String> receivedMessages = this.request(sendMessages);
		return receivedMessages;
	}

	@Override
	public List<String> lookBasket(List<String> sendMessages) {
		List<String> receivedMessages = this.request(sendMessages);
		return receivedMessages;
	}

	@Override
	public List<String> deleteBasket(List<String> sendMessages) {
		List<String> receivedMessages = this.request(sendMessages);
		return receivedMessages;
	}

	@Override
	public List<String> addSincheong(List<String> sendMessages) {
		List<String> receivedMessages = this.request(sendMessages);
		return receivedMessages;
	}

	@Override
	public List<String> lookSincheong(List<String> sendMessages) {
		List<String> receivedMessages = this.request(sendMessages);
		return receivedMessages;
	}

	@Override
	public List<String> deleteSincheong(List<String> sendMessages) {
		List<String> receivedMessages = this.request(sendMessages);
		return receivedMessages;
	}

}
