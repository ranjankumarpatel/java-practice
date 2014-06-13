package encrypt;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptText {
	
	public static void main(String[] args){
		try {
			BasicTextEncryptor encryptor = new BasicTextEncryptor();
			encryptor.setPassword("patel");
			System.out.println(encryptor.encrypt("ranjan"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
