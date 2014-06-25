package org.encryption.encrypt;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptionUtility {
	
	private static final String password = "RanjanKumarPatel";
	
	public EncryptionUtility() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public static String encryptText(String text){
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword(password);
		return encryptor.encrypt(text);
	}
	
	public static String decryptText(String text){
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword(password);
		return encryptor.decrypt(text);
	}
	
	

	

}
