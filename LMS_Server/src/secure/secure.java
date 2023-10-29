package secure;

public class secure {
	public String encry(String string) {
		String key = "9cF4bRzLX6Y7vA2p";
		
		AES128 aes = new AES128(key);
		
		String txt = string;
		String encrypt = aes.encrypt(txt);
 	
		System.out.println("평문: " + txt);
		System.out.println("암호화: " + encrypt);

		
		return encrypt;
	}
	
	public String decry(String encrypt) {
		String key = "9cF4bRzLX6Y7vA2p";
		
		AES128 aes = new AES128(key);
		
		String decrypt = aes.decrypt(encrypt);
		
		System.out.println("암호문: " + encrypt);
		System.out.println("복호화: " + decrypt);
		return decrypt; 
	}
}
