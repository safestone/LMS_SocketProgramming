package general;

import java.util.List;

public interface ICLectrueBasket {
	public List<String> addBasket(List<String> receivedMessages);
	public List<String> lookBasket(List<String> receivedMessages);
	public List<String> deleteBasket(List<String> receivedMessages);
	public List<String> addSincheong(List<String> receivedMessages);
	public List<String> lookSincheong(List<String> receivedMessages);
	public List<String> deleteSincheong(List<String> receivedMessages);

}
