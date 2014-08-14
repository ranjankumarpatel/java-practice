package org.encryption.encrypt;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.log4j.Logger;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;

public class Encrypto {
	private static final BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
	private static final BasicPasswordEncryptor basicPasswordEncryptor = new BasicPasswordEncryptor();
	private static final URLCodec urlCodec = new URLCodec();
	private static final Logger LOGGER = Logger.getLogger(Encrypto.class);
	
static{
	basicTextEncryptor.setPassword("PunRanjanya@13972684!");
	
	
}
public static String encryptURLParam(String param){
	String parameter = null;
	try {
		parameter = urlCodec.encode(basicTextEncryptor.encrypt(param));
	} catch (EncoderException e) {		
		e.printStackTrace();
		LOGGER.error(e.getMessage(), e);
	}
	return parameter;
	
}

public static String encryptURLParam(int param){
	String parameter = null;
	try {
		parameter = urlCodec.encode(basicTextEncryptor.encrypt(Integer.toString(param)));
	} catch (EncoderException e) {
		e.printStackTrace();
		LOGGER.error(e.getMessage(), e);
	}
	return parameter;
}

public static String decryptURLParam(String param){	
	return basicTextEncryptor.decrypt(param);
}

public static String encryptPassword(String password){
	return basicPasswordEncryptor.encryptPassword(password);
}

public static boolean validatePassword(String plainPassword,String encryptedPassword) throws DecoderException{
	return basicPasswordEncryptor.checkPassword(plainPassword,encryptedPassword);
}

public static String encryptText(String message){
	return basicTextEncryptor.encrypt(message);
}

}
